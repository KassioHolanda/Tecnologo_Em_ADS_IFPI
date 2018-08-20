package com.android.biblio.biblio.fragments.user;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.models.Autor;
import com.android.biblio.biblio.models.Categoria;
import com.android.biblio.biblio.models.Editora;
import com.android.biblio.biblio.models.Emprestimo;
import com.android.biblio.biblio.models.Reserva;
import com.android.biblio.biblio.models.Titulo;
import com.android.biblio.biblio.models.Usuario;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrarEmprestimoFragment extends Fragment {

    private TextView tituloDetail;
    private EditText descricaoDetail;
    private EditText isbnDetail;
    private EditText estoqueDetail;
    private EditText generoDetail;
    private EditText autorDetail;
    private EditText precoDetail;
    private EditText editoraDetail;
    private EditText anoDetail;
    private Mensagens mensagens;
    private APIService apiService;
    private Button emprestimoDetail;
    private Preferencias preferencias;
    private int quantidadeEstoque;
    private Titulo tituloSelecionado;
    private Date data;
    private String date;
    private Usuario usuarioLogado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registrar_emprestimo, container, false);
        setupInit();
        binding(v);
        atualizarTextos();
        onClickItem();
        data = new Date();
        recuperarUsuarioLogado();
        return v;
    }

    public void binding(View v) {
        estoqueDetail = v.findViewById(R.id.estoque_detail_id);
        tituloDetail = v.findViewById(R.id.titulo_detail_id);
        descricaoDetail = v.findViewById(R.id.descricao_detail_id);
        isbnDetail = v.findViewById(R.id.isbn_detail_id);
        generoDetail = v.findViewById(R.id.genero_detail_id);
        autorDetail = v.findViewById(R.id.autor_detail_id);
        precoDetail = v.findViewById(R.id.preco_detail_id);
        editoraDetail = v.findViewById(R.id.editora_detail_id);
        anoDetail = v.findViewById(R.id.ano_detail_id);
        emprestimoDetail = v.findViewById(R.id.emprestimo_detail_id);
    }

    public void onClickItem() {
        emprestimoDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantidadeEstoque == 0) {
                    alertaReserva();
                } else {
                    Emprestimo emprestimo = new Emprestimo(
                            tituloSelecionado.getId(), usuarioLogado.getId(),5, data);
                    registrarEmprestimoAPI(emprestimo);
                }
            }
        });
    }

    public void registrarEmprestimoAPI(Emprestimo emprestimo) {
        Call<Emprestimo> emprestimoCall = apiService.getEmprestimoEndPoint().postEmprestimo(emprestimo);
        emprestimoCall.enqueue(new Callback<Emprestimo>() {
            @Override
            public void onResponse(Call<Emprestimo> call, Response<Emprestimo> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "" + mensagens.EMPRESTIMO_SAVE + ", Você tem 5 dias de emprestimo", Toast.LENGTH_SHORT).show();
                }

                if (response.code() == 400) {
                    Toast.makeText(getContext(), "Você ja possui um emprestimo!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Emprestimo> call, Throwable t) {
                Toast.makeText(getContext(), "" + mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void alertaReserva() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//        final View viewDialog = getLayoutInflater().inflate(R.layout.dialog_reserva, null);

        builder.setTitle("Reserva!");
        builder.setMessage("O titulo não possui livros disponiveis para emprestimo, deseja realizar uma reserva?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Reserva reserva = new Reserva(tituloSelecionado.getId(), usuarioLogado.getId(), data, true);
                registrarReservaAPI(reserva);
            }
        }).setNegativeButton("Nao", null).show();
    }


    public void atualizarTextos() {
        Bundle bundle = getArguments();
        long titulo = bundle.getLong("titulo_id");

        Call<Titulo> call = apiService.getTituloEndPoint().getTitulo(titulo);
        call.enqueue(new Callback<Titulo>() {
            @Override
            public void onResponse(Call<Titulo> call, Response<Titulo> response) {
                tituloSelecionado = response.body();
                quantidadeEstoque = response.body().getEstoque();
                tituloDetail.setText(response.body().getNome());
                descricaoDetail.setText(response.body().getDescricao());
                isbnDetail.setText(response.body().getIsbn());
//                generoDetail.setText(response.body().getCategoria().getNome());
//                autorDetail.setText(response.body().getAutor().getNome());
//                editoraDetail.setText(response.body().getEditora().getNome());
                estoqueDetail.setText("" + response.body().getEstoque());
                precoDetail.setText("" + response.body().getPrecoAluguel());
                anoDetail.setText("" + response.body().getAno());
                recuperarDadosAPI();
            }

            @Override
            public void onFailure(Call<Titulo> call, Throwable t) {

            }
        });

    }

    public void recuperarDadosAPI() {
        final Call<Autor> autorCall = apiService.getAutorEndPoint().getAutor(tituloSelecionado.getAutor());
        autorCall.enqueue(new Callback<Autor>() {
            @Override
            public void onResponse(Call<Autor> call, Response<Autor> response) {
//                autor = response.body();
                autorDetail.setText(response.body().getNome());
//                Toast.makeText(getContext(), "Autor Recuperado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Autor> call, Throwable t) {
            }
        });

        Call<Editora> call = apiService.getEditoraEndPoint().getEditora(tituloSelecionado.getEditora());
        call.enqueue(new Callback<Editora>() {
            @Override
            public void onResponse(Call<Editora> call, Response<Editora> response) {
//                editora = response.body();
                editoraDetail.setText(response.body().getNome());
//                Toast.makeText(getContext(), "Autor Recuperado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Editora> call, Throwable t) {
            }
        });

        Call<Categoria> callCat = apiService.getCategoriaEndPoint().getCategoria(tituloSelecionado.getCategoria());
        callCat.enqueue(new Callback<Categoria>() {
            @Override
            public void onResponse(Call<Categoria> call, Response<Categoria> response) {
//                categoria = response.body();
                generoDetail.setText(response.body().getNome());
//                Toast.makeText(getContext(), "Categoria Recuperada", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Categoria> call, Throwable t) {
                Toast.makeText(getContext(), "" + mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
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
        getActivity().setTitle("Detalhes");
    }

    public void recuperarUsuarioLogado() {
        final Call<Usuario> usuario = apiService.getUserEndPoint().getUsuario(preferencias.getSavedLong(mensagens.ID_USUARIO));

        usuario.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                usuarioLogado = response.body();
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(getContext(), "" + mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void registrarReservaAPI(Reserva reserva) {
        Call<Reserva> call = apiService.getReservaEndPoint().postReserva(reserva);

        call.enqueue(new Callback<Reserva>() {
            @Override
            public void onResponse(Call<Reserva> call, Response<Reserva> response) {
                if (response.code() == 400) {
                    Toast.makeText(getContext(), "" + response.message(), Toast.LENGTH_LONG).show();
                }

                Toast.makeText(getContext(), "RESERVA SALVA", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Reserva> call, Throwable t) {
                Toast.makeText(getContext(), "" + mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
