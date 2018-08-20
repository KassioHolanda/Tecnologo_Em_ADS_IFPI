package com.android.biblio.biblio.fragments.bibliotecario;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.models.Editora;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.service.ListaEditoraAPIModel;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorasFragment extends Fragment {

    private ListView editorasListView;
    private APIService apiService;
    private FloatingActionButton fabAddEditora;
    private Preferencias preferencias;
    private Mensagens mensagens;
    private Editora editora;
    private EditText nomeEditora;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_editoras, container, false);
        binding(view);
        setupInit();
        onClickItem(view);
        carregarEditorasAPI();
        registerForContextMenu(editorasListView);
        return view;
    }

    public void setupInit() {
        mensagens = new Mensagens();
        preferencias = new Preferencias(getContext());
        apiService = new APIService(getToken());
    }

    public void binding(View view) {
        editorasListView = view.findViewById(R.id.list_view_editoras_id);
        fabAddEditora = view.findViewById(R.id.fab_add_editora_id);
    }

    public void onClickItem(final View view) {
        fabAddEditora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novaEditoraAPI(view);
            }
        });

        editorasListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                editora = (Editora) parent.getItemAtPosition(position);
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        final MenuItem editar = menu.add("Editar");
        MenuItem remover = menu.add("Remover");

        remover.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Remoção").setMessage("Deseja remover " + editora.getNome()).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        removerEditoraAPI(editora);
                    }
                }).setNegativeButton("Nao", null).show();
                return false;
            }
        });

        editar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(final MenuItem item) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                final View viewDialog = getLayoutInflater().inflate(R.layout.dialog_novos_campos, null);

                nomeEditora = viewDialog.findViewById(R.id.nome_campo_id);
                nomeEditora.setText(editora.getNome());

                builder.setView(viewDialog).setTitle("Editar Editora")
                        .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                editora.setNome(nomeEditora.getText().toString());

                                Call<Editora> call = apiService.getEditoraEndPoint().putEditora(editora.getId(), editora);
                                call.enqueue(new Callback<Editora>() {
                                    @Override
                                    public void onResponse(Call<Editora> call, Response<Editora> response) {
                                        Toast.makeText(getContext(), "" + mensagens.EDITORA_SAVE, Toast.LENGTH_LONG).show();
                                        carregarEditorasAPI();
                                    }

                                    @Override
                                    public void onFailure(Call<Editora> call, Throwable t) {
                                        Toast.makeText(getContext(), "" + mensagens.ERROR_SAVE, Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }).setNegativeButton("Cancelar", null).show();

                return false;
            }
        });

    }

    private String getToken() {
        String token = preferencias.getSavedString(mensagens.TOKEN);
//        Toast.makeText(getContext(), "" + token, Toast.LENGTH_SHORT).show();
        return token;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Editoras");
    }

    public void carregarEditorasAPI() {
        Call<ListaEditoraAPIModel> call = apiService.getEditoraEndPoint().editoras();

        call.enqueue(new Callback<ListaEditoraAPIModel>() {
            @Override
            public void onResponse(Call<ListaEditoraAPIModel> call, Response<ListaEditoraAPIModel> response) {
                atualizarAdapter(response.body().getResults());
            }

            @Override
            public void onFailure(Call<ListaEditoraAPIModel> call, Throwable t) {

            }
        });
    }

    public void removerEditoraAPI(Editora editora) {
        Call<ResponseBody> call = apiService.getEditoraEndPoint().deleteEditora(editora.getId());

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(getContext(), "EDITORA DELETADA", Toast.LENGTH_SHORT).show();
                carregarEditorasAPI();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void atualizarAdapter(List<Editora> listaEditoraAPIModels) {
        ArrayAdapter<Editora> editoraArrayAdapter = new ArrayAdapter<Editora>(getContext(), android.R.layout.simple_list_item_1, listaEditoraAPIModels);
        editorasListView.setAdapter(editoraArrayAdapter);
    }

    public void novaEditoraAPI(final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        final View viewDialog = getLayoutInflater().inflate(R.layout.dialog_novos_campos, null);

        builder.setView(viewDialog).setTitle("Nova Editora")
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText nomeEditora = viewDialog.findViewById(R.id.nome_campo_id);

                        String nome = nomeEditora.getText().toString();
                        Editora editora = new Editora(nome);

                        Call<Editora> call = apiService.getEditoraEndPoint().postEditora(editora);
                        call.enqueue(new Callback<Editora>() {
                            @Override
                            public void onResponse(Call<Editora> call, Response<Editora> response) {
                                Toast.makeText(getContext(), "" + mensagens.EDITORA_SAVE, Toast.LENGTH_LONG).show();
                                carregarEditorasAPI();
                            }

                            @Override
                            public void onFailure(Call<Editora> call, Throwable t) {
                                Toast.makeText(getContext(), "" + mensagens.ERROR_SAVE, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).setNegativeButton("Cancelar", null).show();
    }


}
