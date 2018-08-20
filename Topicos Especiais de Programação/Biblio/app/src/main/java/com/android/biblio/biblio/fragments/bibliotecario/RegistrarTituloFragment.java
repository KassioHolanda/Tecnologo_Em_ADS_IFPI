package com.android.biblio.biblio.fragments.bibliotecario;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.models.Autor;
import com.android.biblio.biblio.models.Categoria;
import com.android.biblio.biblio.models.Editora;
import com.android.biblio.biblio.models.Titulo;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.service.ListaAutoresAPIModel;
import com.android.biblio.biblio.service.ListaCategoriaAPIModel;
import com.android.biblio.biblio.service.ListaEditoraAPIModel;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrarTituloFragment extends Fragment {

    private APIService apiService;
    private Preferencias preferencias;
    private Button registrarTitulos;
    private Spinner categoriasSpinner;
    private Spinner editorasSpinner;
    private Spinner autoresSpinner;
    private TextView anoTitulo;
    private TextView precoTitulo;
    private TextView isbn;
    private TextView descricao;
    private TextView nome;
    private Mensagens mensagens;
    private EditText estoque;
    private Button registrarEditora;
    private Button registrarAutor;
    private Button registrarCategoria;
    private List<Categoria> categoriaList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registrar_titulo, container, false);
        binding(view);
        setupInit();
        onClickItem();
        atualizarSpinnerCategoria();
        atualizarSpinnerAutor();
        atualizarSpinnerEditoras();
        return view;
    }

    public void setupInit() {
        mensagens = new Mensagens();
        preferencias = new Preferencias(getContext());
        apiService = new APIService(getToken());
    }

    public void binding(View view) {
        registrarTitulos = view.findViewById(R.id.registrar_titulos_id);
        categoriasSpinner = view.findViewById(R.id.categorias_spinner_id);
        editorasSpinner = view.findViewById(R.id.editoras_spinner_id);
        autoresSpinner = view.findViewById(R.id.autores_spinner_id);
        anoTitulo = view.findViewById(R.id.ano_titulo_id);
        precoTitulo = view.findViewById(R.id.preco_titulo_id);
        descricao = view.findViewById(R.id.descricao_id);
        nome = view.findViewById(R.id.nome_id);
        isbn = view.findViewById(R.id.isbn_id);
        estoque = view.findViewById(R.id.estoque_titulo_id);
        registrarAutor = view.findViewById(R.id.registrar_autor_id);
        registrarCategoria = view.findViewById(R.id.registrar_categoria_id);
        registrarEditora = view.findViewById(R.id.registrar_editora_id);
    }

    public void onClickItem() {
        registrarTitulos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarTitulo();
            }
        });

        registrarEditora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarEditoraAPI();
            }
        });
        registrarAutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarAutorAPI();
            }
        });

        registrarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarCategoriaAPI();
            }
        });
    }

    public void registrarEditoraAPI() {
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
                                atualizarSpinnerEditoras();
                            }

                            @Override
                            public void onFailure(Call<Editora> call, Throwable t) {
                                Toast.makeText(getContext(), "" + mensagens.ERROR_SAVE, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).setNegativeButton("Cancelar", null).show();
    }


    public void registrarCategoriaAPI() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        final View viewDialog = getLayoutInflater().inflate(R.layout.dialog_novos_campos, null);

        builder.setView(viewDialog).setTitle("Nova Categoria")
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText nomeCampo = viewDialog.findViewById(R.id.nome_campo_id);

                        String nome = nomeCampo.getText().toString();
                        Categoria categoria = new Categoria(nome);

                        Call<Categoria> call = apiService.getCategoriaEndPoint().postCategoria(categoria);
                        call.enqueue(new Callback<Categoria>() {
                            @Override
                            public void onResponse(Call<Categoria> call, Response<Categoria> response) {
                                Toast.makeText(getContext(), "" + mensagens.CATEGORIA_SAVE, Toast.LENGTH_LONG).show();
                                atualizarSpinnerCategoria();
                            }

                            @Override
                            public void onFailure(Call<Categoria> call, Throwable t) {
                                Toast.makeText(getContext(), "" + mensagens.ERROR_SAVE, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).setNegativeButton("Cancelar", null).show();
    }


    public void registrarAutorAPI() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        final View viewDialog = getLayoutInflater().inflate(R.layout.dialog_novos_campos, null);

        builder.setView(viewDialog).setTitle("Nova Autor")
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText nomeEditora = viewDialog.findViewById(R.id.nome_campo_id);

                        String nome = nomeEditora.getText().toString();
                        Autor autor = new Autor(nome);

                        Call<Autor> call = apiService.getAutorEndPoint().postAutor(autor);
                        call.enqueue(new Callback<Autor>() {
                            @Override
                            public void onResponse(Call<Autor> call, Response<Autor> response) {
                                Toast.makeText(getContext(), "" + mensagens.AUTOR_SAVE, Toast.LENGTH_LONG).show();
                                atualizarSpinnerAutor();
                            }

                            @Override
                            public void onFailure(Call<Autor> call, Throwable t) {
                                Toast.makeText(getContext(), "" + mensagens.ERROR_SAVE, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).setNegativeButton("Cancelar", null).show();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Registrar Titulo");
    }

    private String getToken() {
        String token = preferencias.getSavedString(mensagens.TOKEN);
//        Toast.makeText(getContext(), "" + token, Toast.LENGTH_SHORT).show();
        return token;
    }

    public void registrarTitulo() {
        String nomeTitulo = nome.getText().toString();
        String ano = anoTitulo.getText().toString();
        String descricaoTitulo = descricao.getText().toString();
        Float preco = (float) Float.valueOf(precoTitulo.getText().toString());
        Categoria categoria = (Categoria) categoriasSpinner.getSelectedItem();
        Autor autor = (Autor) autoresSpinner.getSelectedItem();
        Editora editora = (Editora) editorasSpinner.getSelectedItem();
        String isbnTitulo = isbn.getText().toString();
        int estoqueTitulo = Integer.parseInt(estoque.getText().toString());

        Titulo titulo = new Titulo(nomeTitulo, descricaoTitulo, isbnTitulo, autor.getId(), categoria.getId(), preco, editora.getId(), ano, estoqueTitulo);
        registrarTituloAPI(titulo);
    }

    public void registrarTituloAPI(Titulo titulo) {
        Call<Titulo> call = apiService.getTituloEndPoint().postTitulo(titulo);

        call.enqueue(new Callback<Titulo>() {
            @Override
            public void onResponse(Call<Titulo> call, Response<Titulo> response) {
                Toast.makeText(getContext(), "" + mensagens.TITULO_SAVE, Toast.LENGTH_SHORT).show();

                FragmentManager fragmentManager = getFragmentManager();
                TitulosFragment titulosFragment = new TitulosFragment();
                fragmentManager.beginTransaction().replace(R.id.content_biblio, titulosFragment).addToBackStack(null).commit();
            }

            @Override
            public void onFailure(Call<Titulo> call, Throwable t) {

            }
        });
    }

    public void atualizarSpinnerCategoria() {
        Call<ListaCategoriaAPIModel> call = apiService.getCategoriaEndPoint().categorias();
        call.enqueue(new Callback<ListaCategoriaAPIModel>() {
            @Override
            public void onResponse(Call<ListaCategoriaAPIModel> call, Response<ListaCategoriaAPIModel> response) {
                if (response.code() == 500) {

                }

                ArrayAdapter<Categoria> categoriaArrayAdapter = new ArrayAdapter<Categoria>(getContext(), android.R.layout.simple_spinner_item, response.body().getResults());
                categoriaArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                categoriasSpinner.setAdapter(categoriaArrayAdapter);
            }

            @Override
            public void onFailure(Call<ListaCategoriaAPIModel> call, Throwable t) {
                Toast.makeText(getContext(), "erro", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void atualizarSpinnerAutor() {
        Call<ListaAutoresAPIModel> call = apiService.getAutorEndPoint().autores();
        call.enqueue(new Callback<ListaAutoresAPIModel>() {
            @Override
            public void onResponse(Call<ListaAutoresAPIModel> call, Response<ListaAutoresAPIModel> response) {
                ArrayAdapter<Autor> autorArrayAdapter = new ArrayAdapter<Autor>(getContext(), android.R.layout.simple_spinner_item, response.body().getResults());
                autorArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                autoresSpinner.setAdapter(autorArrayAdapter);
            }

            @Override
            public void onFailure(Call<ListaAutoresAPIModel> call, Throwable t) {
                Toast.makeText(getContext(), "erro", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void atualizarSpinnerEditoras() {
        Call<ListaEditoraAPIModel> call = apiService.getEditoraEndPoint().editoras();
        call.enqueue(new Callback<ListaEditoraAPIModel>() {
            @Override
            public void onResponse(Call<ListaEditoraAPIModel> call, Response<ListaEditoraAPIModel> response) {
                ArrayAdapter<Editora> autorArrayAdapter = new ArrayAdapter<Editora>(getContext(), android.R.layout.simple_spinner_item, response.body().getResults());
                autorArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                editorasSpinner.setAdapter(autorArrayAdapter);
            }

            @Override
            public void onFailure(Call<ListaEditoraAPIModel> call, Throwable t) {
                Toast.makeText(getContext(), ""+mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
