package com.android.biblio.biblio.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.models.Titulo;
import com.android.biblio.biblio.service.ListaTitulosAPIModel;

import java.util.List;

public class AdapterTitulo extends RecyclerView.Adapter<AdapterTitulo.ViewHolder> {

    private final Context context;
    private final List<Titulo> titulos;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView descricaoTitulo;
        protected TextView nomeTitulo;
        protected TextView anoLancamento;

        public ViewHolder(View view) {
            super(view);
            descricaoTitulo = view.findViewById(R.id.descricao_titulo_id);
            nomeTitulo = view.findViewById(R.id.nome_titulo_id);
            anoLancamento = view.findViewById(R.id.ano_lancamento_id);
        }
    }

    public AdapterTitulo(Context context, List<Titulo> titulos) {
        this.context = context;
        this.titulos = titulos;
    }

    @NonNull
    @Override
    public AdapterTitulo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_titulos, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTitulo.ViewHolder holder, int position) {

//        holder.precoTitulo.setText(titulos.get(position).getPrecoAluguel());
        holder.descricaoTitulo.setText(titulos.get(position).getDescricao());
        holder.nomeTitulo.setText(titulos.get(position).getNome());
        holder.anoLancamento.setText(titulos.get(position).getAno());

    }

    @Override
    public int getItemCount() {
        return titulos.size();
    }
}
