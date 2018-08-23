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

import java.util.List;

public class AdapterEmprestimosUsuario extends RecyclerView.Adapter<AdapterEmprestimosUsuario.ViewHolder> {
    private final Context context;
    private final List<Emprestimo> emprestimos;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView valorEmprestiom;
        protected TextView dataEmprestimo;
        protected TextView quantidadeDias;
        protected TextView tituloEmprestimo;

        public ViewHolder(View view) {
            super(view);
            tituloEmprestimo = view.findViewById(R.id.titulo_emprestimo_usuario_id);
            valorEmprestiom = view.findViewById(R.id.valor_emprestimo_usuario_id);
            quantidadeDias = view.findViewById(R.id.quantidade_dias_emprestimo_usuario_id);
            dataEmprestimo = view.findViewById(R.id.data_emprestimo_usuario_id);

        }
    }

    public AdapterEmprestimosUsuario(Context context, List<Emprestimo> emprestimos) {
        this.context = context;
        this.emprestimos = emprestimos;
    }

    @NonNull
    @Override
    public AdapterEmprestimosUsuario.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_emprestimo_user, parent, false);
        AdapterEmprestimosUsuario.ViewHolder viewHolder = new AdapterEmprestimosUsuario.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEmprestimosUsuario.ViewHolder holder, int position) {
//        holder.tituloEmprestimo.setText(emprestimos.get(position).getLivro().getTitulo().getNome());
        holder.quantidadeDias.setText(""+emprestimos.get(position).getQuantidadeDias());
        holder.dataEmprestimo.setText("" + emprestimos.get(position).getDataEmprestimo());
//        holder.valorEmprestiom.setText("" + emprestimos.get(position).getLivro().getTitulo().getPrecoAluguel());
    }

    @Override
    public int getItemCount() {
        return emprestimos.size();
    }
}
