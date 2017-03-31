package hemocentros.com.example.kassio.hemocentros.Adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarRecord;

import org.w3c.dom.Text;

import java.util.List;

import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Doacao;

/**
 * Created by kassio on 30/03/17.
 */

public class AdapterListaDoacoes extends RecyclerView.Adapter<AdapterListaDoacoes.ViewHolder>{

    private final Context context;
    private final List<Doacao> doacoes;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        protected TextView text_view_nome_doador_id;
        protected TextView text_view_tipo_sangue_doado_id;

        public ViewHolder(View itemView) {
            super(itemView);

            text_view_nome_doador_id = (TextView) itemView.findViewById(R.id.text_view_nome_doador_id);
            text_view_tipo_sangue_doado_id = (TextView) itemView.findViewById(R.id.text_view_tipo_sangue_doado_id);

        }
    }

    public AdapterListaDoacoes(Context context, List<Doacao> doacaos){

        this.context = context;
        this.doacoes = doacaos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.item_user_lista_de_doacoes, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AdapterListaDoacoes.ViewHolder holder, final int position) {

        final List<Doacao> doacao = SugarRecord.listAll(Doacao.class);

        holder.text_view_nome_doador_id.setText(doacao.get(position).getDoador().getNome());
        holder.text_view_tipo_sangue_doado_id.setText(doacao.get(position).getDoador().getTipoDeSangue());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(doacoes.get(position).getCampanha().getDescricao() != null) {
                        Snackbar.make(v, "Campanha " + doacoes.get(position).getCampanha().getDescricao(), Snackbar.LENGTH_LONG).show();
                    } else {
                        Snackbar.make(v, "Sem campanha", Snackbar.LENGTH_LONG).show();
                    }
                }catch (NullPointerException e){
                    Snackbar.make(v, "Sem campanha", Snackbar.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return doacoes.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
