package com.android.biblio.biblio.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.fragments.bibliotecario.RegistrarTituloFragment;
import com.android.biblio.biblio.fragments.user.PaginaInicialFragment;
import com.android.biblio.biblio.fragments.user.RegistrarEmprestimoFragment;
import com.android.biblio.biblio.models.Editora;
import com.android.biblio.biblio.models.Titulo;
import com.android.biblio.biblio.service.ListaTitulosAPIModel;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterTituloUser extends RecyclerView.Adapter<AdapterTituloUser.ViewHolder> {

    private final Context context;
    private final List<Titulo> titulos;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView descricaoTitulo;
        protected TextView nomeTitulo;
        protected TextView anoLancamento;
        protected Button tituloDetalheUser;

        public ViewHolder(View view) {
            super(view);
            descricaoTitulo = view.findViewById(R.id.descricao_titulo_id);
            nomeTitulo = view.findViewById(R.id.nome_titulo_id);
            anoLancamento = view.findViewById(R.id.ano_lancamento_id);
            tituloDetalheUser = view.findViewById(R.id.titulo_detalhe_user_id);
        }
    }

    public AdapterTituloUser(Context context, List<Titulo> titulos) {
        this.context = context;
        this.titulos = titulos;
    }

    @NonNull
    @Override
    public AdapterTituloUser.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_titulos_user, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterTituloUser.ViewHolder holder, final int position) {
        holder.descricaoTitulo.setText(titulos.get(position).getDescricao());
        holder.nomeTitulo.setText(titulos.get(position).getNome());
        holder.anoLancamento.setText(titulos.get(position).getAno());
        holder.tituloDetalheUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putLong("titulo_id", titulos.get(position).getId());
                RegistrarEmprestimoFragment registrarEmprestimoFragment = new RegistrarEmprestimoFragment();
                registrarEmprestimoFragment.setArguments(bundle);

                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, registrarEmprestimoFragment).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return titulos.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
