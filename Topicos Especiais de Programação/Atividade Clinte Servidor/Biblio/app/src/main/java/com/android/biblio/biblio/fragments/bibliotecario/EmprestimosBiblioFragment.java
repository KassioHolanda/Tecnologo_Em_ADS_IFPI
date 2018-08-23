package com.android.biblio.biblio.fragments.bibliotecario;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.adapters.AdapterEmprestimos;
import com.android.biblio.biblio.models.Emprestimo;
import com.android.biblio.biblio.service.APIService;
import com.android.biblio.biblio.service.ListaEmprestimoAPIModel;
import com.android.biblio.biblio.utils.Mensagens;
import com.android.biblio.biblio.utils.Preferencias;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmprestimosBiblioFragment extends Fragment {

    private APIService apiService;
    private RecyclerView recyclerViewEmprestimo;
    private Preferencias preferencias;
    private Mensagens mensagens;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emprestimo_biblio, container, false);
        setupInit();
        binding(view);
        carregarEmprestimos();
        return view;
    }

    public void binding(View view) {
        recyclerViewEmprestimo = view.findViewById(R.id.recycler_view_emprestimo);
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

    public void carregarEmprestimos() {
        Call<ListaEmprestimoAPIModel> call = apiService.getEmprestimoEndPoint().emprestimos();
        call.enqueue(new Callback<ListaEmprestimoAPIModel>() {
            @Override
            public void onResponse(Call<ListaEmprestimoAPIModel> call, Response<ListaEmprestimoAPIModel> response) {
                if (response.isSuccessful()) {
                    atualizaAdapter(response.body().getResults());
                }
//                Toast.makeText(getContext(), "" + response.code(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ListaEmprestimoAPIModel> call, Throwable t) {
                Toast.makeText(getContext(), "" + mensagens.ERROR_CONECTION, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void atualizaAdapter(List<Emprestimo> emprestimos) {
        AdapterEmprestimos adapterTitulo = new AdapterEmprestimos(getContext(), emprestimos);
        recyclerViewEmprestimo.setAdapter(adapterTitulo);
        recyclerViewEmprestimo.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Emprestimos");
    }
}
