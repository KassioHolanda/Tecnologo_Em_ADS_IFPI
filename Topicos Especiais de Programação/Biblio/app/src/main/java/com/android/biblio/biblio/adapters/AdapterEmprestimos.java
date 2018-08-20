package com.android.biblio.biblio.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.biblio.biblio.R;
import com.android.biblio.biblio.models.Emprestimo;
import com.android.biblio.biblio.models.Titulo;

import java.util.List;

public class AdapterEmprestimos extends RecyclerView.Adapter<AdapterEmprestimos.ViewHolder> {
    private final Context context;
    private final List<Emprestimo> emprestimos;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView usuarioEmprestimo;
        protected TextView tituloEmprestimo;
        protected TextView dataEmprestimo;
        protected TextView dataDevolucao;

        public ViewHolder(View view) {
            super(view);
            usuarioEmprestimo = view.findViewById(R.id.usuario_emprestimo_id);
            tituloEmprestimo = view.findViewById(R.id.titulo_emprestimo_id);
            dataEmprestimo = view.findViewById(R.id.id_data_emprestimo);
            dataDevolucao = view.findViewById(R.id.id_data_devolucao);
        }
    }

    public AdapterEmprestimos(Context context, List<Emprestimo> emprestimos) {
        this.context = context;
        this.emprestimos = emprestimos;
    }

    @NonNull
    @Override
    public AdapterEmprestimos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_emprestimos, parent, false);
        AdapterEmprestimos.ViewHolder viewHolder = new AdapterEmprestimos.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEmprestimos.ViewHolder holder, int position) {

//        holder.usuarioEmprestimo.setText(emprestimos.get(position).getUsuario().getNome());
//        holder.tituloEmprestimo.setText(emprestimos.get(position).getLivro().getTitulo().getNome());
        holder.dataEmprestimo.setText("" + emprestimos.get(position).getDataEmprestimo());
        if (emprestimos.get(position).getDataDevolucao() != null) {
            holder.dataDevolucao.setText("" + emprestimos.get(position).getDataDevolucao());
        } else {
            holder.dataDevolucao.setText("Sem data");
        }

    }

    @Override
    public int getItemCount() {
        return emprestimos.size();
    }
}
