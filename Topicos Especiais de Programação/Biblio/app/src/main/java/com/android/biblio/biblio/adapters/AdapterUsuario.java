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
import com.android.biblio.biblio.models.Usuario;

import java.util.List;

public class AdapterUsuario extends RecyclerView.Adapter<AdapterUsuario.ViewHolder> {

    private final Context context;
    private final List<Usuario> usuarios;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView nomeUsuario;

        public ViewHolder(View view) {
            super(view);
            nomeUsuario = view.findViewById(R.id.nome_usuario_id);
        }
    }

    public AdapterUsuario(Context context, List<Usuario> usuarios) {
        this.context = context;
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public AdapterUsuario.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_usuarios, parent, false);
        AdapterUsuario.ViewHolder viewHolder = new AdapterUsuario.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUsuario.ViewHolder holder, int position) {
        holder.nomeUsuario.setText(usuarios.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

}
