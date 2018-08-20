package com.android.biblio.biblio.adapters;

import android.content.Context;
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

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.fragments.bibliotecario.DetalharTituloFragment;
import com.android.biblio.biblio.fragments.user.RegistrarEmprestimoFragment;
import com.android.biblio.biblio.models.Titulo;

import java.util.List;

public class AdapterTituloBiblio extends RecyclerView.Adapter<AdapterTituloBiblio.ViewHolder> {

    private final Context context;
    private final List<Titulo> titulos;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView descricaoTitulo;
        protected TextView nomeTitulo;
        protected TextView anoLancamento;
        protected Button detalharTitulo;

        public ViewHolder(View view) {
            super(view);
            descricaoTitulo = view.findViewById(R.id.descricao_titulo_id);
            nomeTitulo = view.findViewById(R.id.nome_titulo_id);
            anoLancamento = view.findViewById(R.id.ano_lancamento_id);
            detalharTitulo = view.findViewById(R.id.detalhar_titulo_id);
        }
    }

    public AdapterTituloBiblio(Context context, List<Titulo> titulos) {
        this.context = context;
        this.titulos = titulos;
    }

    @NonNull
    @Override
    public AdapterTituloBiblio.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_titulos_biblio, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTituloBiblio.ViewHolder holder, final int position) {

//        holder.precoTitulo.setText(titulos.get(position).getPrecoAluguel());
        holder.descricaoTitulo.setText(titulos.get(position).getDescricao());
        holder.nomeTitulo.setText(titulos.get(position).getNome());
        holder.anoLancamento.setText(titulos.get(position).getAno());
        holder.detalharTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putLong("titulo_id", titulos.get(position).getId());

                DetalharTituloFragment detalharTituloFragment = new DetalharTituloFragment();
                detalharTituloFragment.setArguments(bundle);

                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_biblio, detalharTituloFragment).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return titulos.size();
    }
}

