package hemocentros.com.example.kassio.hemocentros.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Campanhas;

/**
 * Created by kassio on 30/03/17.
 */

public class AdpterListaCampanhas extends RecyclerView.Adapter<AdpterListaCampanhas.ViewHolder> {

    private final Context context;
    private final List<Campanhas> campanhas;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.item_lista_campanhas, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Campanhas campanhas = this.campanhas.get(position);
        
        holder.text_view_descricao_campanha_id.setText(campanhas.getDescricao());
        holder.text_view_tipo_sangue_id.setText(campanhas.getTipoSangue());
        holder.text_view_data_fim_campanha_id.setText(campanhas.getDia()+"/"+campanhas.getMes()+"/"+campanhas.getAno());

    }

    @Override
    public int getItemCount() {
        return campanhas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        protected TextView text_view_descricao_campanha_id;
        protected TextView text_view_tipo_sangue_id;
        protected TextView text_view_data_fim_campanha_id;


        public ViewHolder(View itemView) {
            super(itemView);

            text_view_descricao_campanha_id = (TextView) itemView.findViewById(R.id.text_view_descricao_campanha_id);
            text_view_tipo_sangue_id = (TextView) itemView.findViewById(R.id.text_view_tipo_sangue_id);
            text_view_data_fim_campanha_id = (TextView) itemView.findViewById(R.id.text_view_data_fim_campanha_id);

        }
    }

    public AdpterListaCampanhas(Context context, List<Campanhas> campanhas ){
        this.context = context;
        this.campanhas = campanhas;
        
    }

}
