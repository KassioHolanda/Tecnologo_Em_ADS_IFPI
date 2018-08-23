package com.android.biblio.biblio.fragments.bibliotecario;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.models.Autor;
import com.android.biblio.biblio.models.Categoria;
import com.android.biblio.biblio.models.Editora;
import com.android.biblio.biblio.models.Titulo;
import com.android.biblio.biblio.models.Usuario;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalharTituloFragment extends Fragment {


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
    private Preferencias preferencias;
    private int quantidadeEstoque;
    public Titulo tituloSelecionado;
    private Button atualizarTitulo;
    private String date;
    public Usuario usuarioLogado;

    public Editora editora;
    public Categoria categoria;
    public Autor autor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalhar_titulo, container, false);
        setupInit();
        binding(view);
        recuperarTitulo();
        recuperarUsuarioLogado();
        onClickItem();
        return view;
    }

    public void setupInit() {
        mensagens = new Mensagens();
        preferencias = new Preferencias(getContext());
        apiService = new APIService(getToken());
    }

    private String getToken() {
        String token = preferencias.getSavedString(mensagens.TOKEN);
//        Toast.makeText(getContext(), "" + token, Toast.LENGTH_SHORT).show();
        return token;
    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Detalhar Titulo");
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
        atualizarTitulo = v.findViewById(R.id.atualizar_titulo_id);
    }

    public void onClickItem() {
        atualizarTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualizarTituloAPI();
            }
        });
    }

    public void recuperarTitulo() {
        Bundle bundle = getArguments();
        long titulo = bundle.getLong("titulo_id");

        Call<Titulo> call = apiService.getTituloEndPoint().getTitulo(titulo);
        call.enqueue(new Callback<Titulo>() {
            @Override
            public void onResponse(Call<Titulo> call, Response<Titulo> response) {
                tituloSelecionado = response.body();
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
                Toast.makeText(getContext(), "Autor Recuperado", Toast.LENGTH_SHORT).show();
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

            }
        });

        quantidadeEstoque = tituloSelecionado.getEstoque();
        tituloDetail.setText(tituloSelecionado.getNome());
        descricaoDetail.setText(tituloSelecionado.getDescricao());
        isbnDetail.setText(tituloSelecionado.getIsbn());
        estoqueDetail.setText("" + tituloSelecionado.getEstoque());
        precoDetail.setText("" + tituloSelecionado.getPrecoAluguel());
        anoDetail.setText("" + tituloSelecionado.getAno());
    }

    public void recuperarUsuarioLogado() {
        final Call<Usuario> usuario = apiService.getUserEndPoint().getUsuario(preferencias.getSavedLong("ID_USUARIO"));

        usuario.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                usuarioLogado = response.body();
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });
    }

    public void atualizarTituloAPI() {
        tituloSelecionado.setDescricao(descricaoDetail.getText().toString());
        tituloSelecionado.setIsbn(isbnDetail.getText().toString());
        tituloSelecionado.setEstoque(Integer.valueOf(estoqueDetail.getText().toString()));
        tituloSelecionado.setPrecoAluguel(Float.valueOf(precoDetail.getText().toString()));
        tituloSelecionado.setAno(anoDetail.getText().toString());

        Call<Titulo> call = apiService.getTituloEndPoint().putTitulo(tituloSelecionado.getId(), tituloSelecionado);

        call.enqueue(new Callback<Titulo>() {
            @Override
            public void onResponse(Call<Titulo> call, Response<Titulo> response) {
                Toast.makeText(getContext(), "" + mensagens.DATE_CHANGED, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Titulo> call, Throwable t) {
                Toast.makeText(getContext(), "" + mensagens.ERROR_CONECTION, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
