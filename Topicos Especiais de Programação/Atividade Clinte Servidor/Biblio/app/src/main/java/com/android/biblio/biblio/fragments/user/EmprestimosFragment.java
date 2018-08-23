package com.android.biblio.biblio.fragments.user;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.adapters.AdapterEmprestimos;
import com.android.biblio.biblio.adapters.AdapterEmprestimosUsuario;
import com.android.biblio.biblio.app.LoginActivity;
import com.android.biblio.biblio.fragments.bibliotecario.RegistrarTituloFragment;
import com.android.biblio.biblio.models.Editora;
import com.android.biblio.biblio.models.Emprestimo;
import com.android.biblio.biblio.models.Titulo;
import com.android.biblio.biblio.models.Usuario;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.service.ListaEmprestimoAPIModel;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmprestimosFragment extends Fragment {

    private EditText tituloEmprestimo;
    private EditText quantidadeDias;
    private EditText dataEmprestimo;
    private EditText dataDevolucao;
    private Mensagens mensagens;
    private Preferencias preferencias;
    private APIService apiService;
    private Usuario usuarioLogado;
    private Button cancelarEmprestimo;
    private Button devolverEmprestimo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emprestimos, container, false);
        bindind(view);
        setupInit();
        carregarEmprestimos();
        onClickItem();
        return view;
    }

    public void bindind(View view) {
        tituloEmprestimo = view.findViewById(R.id.titulo_emprestimo_detalhe_id);
        dataEmprestimo = view.findViewById(R.id.data_emprestimo_detalhe_id);
        quantidadeDias = view.findViewById(R.id.quantidade_dias_emprestimo_detalhe_id);
        dataDevolucao = view.findViewById(R.id.data_devolucao_detalhe_id);
        cancelarEmprestimo = view.findViewById(R.id.cancelar_emprestiom_id);
        devolverEmprestimo = view.findViewById(R.id.devolver_emprestiom_id);
    }

    public void onClickItem() {
        cancelarEmprestimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Emprestimo emprestimo = usuarioLogado.getMeusEmprestimos().get(0);
                Call<ResponseBody> call = apiService.getEmprestimoEndPoint().deleteEmprestimo(emprestimo.getId());

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getContext(), "Emprestimo Cancelado", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getContext(), "" + mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        devolverEmprestimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date = new Date();
                Emprestimo emprestimo = usuarioLogado.getMeusEmprestimos().get(0);
                emprestimo.setDataDevolucao(date);
                Call<Emprestimo> call = apiService.getEmprestimoEndPoint().putEmprestimo(emprestimo.getId(), emprestimo);
                call.enqueue(new Callback<Emprestimo>() {
                    @Override
                    public void onResponse(Call<Emprestimo> call, Response<Emprestimo> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getContext(), "EMPRESTIMO DEVOLVIDO!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Emprestimo> call, Throwable t) {
                        Toast.makeText(getContext(), "" + mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    public void setupInit() {
        mensagens = new Mensagens();
        preferencias = new Preferencias(getContext());
        apiService = new APIService(getToken());
    }

    private String getToken() {
        String token = preferencias.getSavedString(mensagens.TOKEN);
        return token;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Meus Emprestimos");
    }

    public void carregarEmprestimos() {
        Call<Usuario> call = apiService.getUserEndPoint().getUsuario(preferencias.getSavedLong(mensagens.ID_USUARIO));
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
//                if (response.isSuccessful()) {
                    usuarioLogado = response.body();
                    if (usuarioLogado.getMeusEmprestimos().size() == 0) {
                        Toast.makeText(getContext(), "Você não possui emprestimos...", Toast.LENGTH_SHORT).show();
                    }

                    if (response.code() == 403) {
                        Toast.makeText(getContext(), "Sessão expirou, faça login novamente...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(), LoginActivity.class));
                    }

                    try {
                        carregarTitulo(response.body().getMeusEmprestimos().get(0).getTitulo());
                        quantidadeDias.setText("" + response.body().getMeusEmprestimos().get(0).getQuantidadeDias());
                        dataEmprestimo.setText("" + response.body().getMeusEmprestimos().get(0).getDataEmprestimo());
                    } catch (Exception e) {
                        tituloEmprestimo.setText("");
                        quantidadeDias.setText("");
                        dataEmprestimo.setText("");

                        Toast.makeText(getContext(), "Você não possui emprestimos...", Toast.LENGTH_SHORT).show();
                        FragmentManager fragmentManager = getFragmentManager();
                        PaginaInicialFragment paginaInicialFragment = new PaginaInicialFragment();
                        fragmentManager.beginTransaction().replace(R.id.content_frame, paginaInicialFragment).addToBackStack(null).commit();
                    }
                }
//            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(getContext(), mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void carregarTitulo(long titulo) {
        Call<Titulo> call = apiService.getTituloEndPoint().getTitulo(titulo);
        call.enqueue(new Callback<Titulo>() {
            @Override
            public void onResponse(Call<Titulo> call, Response<Titulo> response) {
                if (response.isSuccessful()) {
                    try {
                        tituloEmprestimo.setText("" + response.body().getNome());
                    } catch (Exception e) {
                        tituloEmprestimo.setText("");
                    }

                }
            }

            @Override
            public void onFailure(Call<Titulo> call, Throwable t) {
                Toast.makeText(getContext(), mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
