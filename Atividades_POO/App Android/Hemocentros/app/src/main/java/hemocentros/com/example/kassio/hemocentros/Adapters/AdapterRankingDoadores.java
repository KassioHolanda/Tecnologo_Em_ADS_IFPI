package hemocentros.com.example.kassio.hemocentros.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orm.SugarRecord;

import java.util.Collections;
import java.util.List;

import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.hemocentros.activitys.RankingDoadoresActivity;
import hemocentros.com.example.kassio.hemocentros.model.Doacao;

/**
 * Created by kassio on 3/27/2017.
 */

public class AdapterRankingDoadores extends RecyclerView.Adapter<AdapterRankingDoadores.ViewHolder> {

    private final Context context;
    private final List<Doacao> doacao;




    public static class ViewHolder extends RecyclerView.ViewHolder{

        protected TextView text_view_doadores_ranking_de_doadores_id;
        protected TextView text_view_numero_de_doacoes_id;

        public ViewHolder(View itemView) {
            super(itemView);

            text_view_doadores_ranking_de_doadores_id = (TextView) itemView.findViewById(R.id.text_view_doadores_ranking_de_doadores_id);
            text_view_numero_de_doacoes_id = (TextView) itemView.findViewById(R.id.text_view_numero_de_doacoes_id);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user_ranking_doadores, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterRankingDoadores.ViewHolder holder, int position) {
        List<Doacao> doacoes = SugarRecord.listAll(Doacao.class);

        holder.text_view_doadores_ranking_de_doadores_id.setText(doacoes.get(position).getDoador().getNome());
        holder.text_view_numero_de_doacoes_id.setText(String.valueOf(doacoes.get(position).getQuantidadeBolsas()));

    }

    @Override
    public int getItemCount() {
        return doacao.size();
    }

    public AdapterRankingDoadores(Context context, List<Doacao> doacao){
        this.context = context;
        this.doacao = doacao;

        Collections.sort(doacao);
    }



}