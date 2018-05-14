package hemocentros.com.example.kassio.hemocentros.hemocentros.activitys;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.orm.SugarRecord;

import java.util.Collections;
import java.util.List;

import hemocentros.com.example.kassio.hemocentros.Adapters.AdapterListaDoacoes;
import hemocentros.com.example.kassio.hemocentros.Adapters.AdapterRankingDoadores;
import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Doacao;

public class RankingDoadoresActivity extends AppCompatActivity {

    private RecyclerView recicleViewRankingId;
    private List<Doacao> doacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_doadores);

        recicleViewRankingId = (RecyclerView) findViewById(R.id.recicle_view_ranking_id);;

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));
    }

    public void atualizaLista(){

        Collections.sort(doacao);

        AdapterRankingDoadores adapter = new AdapterRankingDoadores(this, doacao);
        recicleViewRankingId.setAdapter(adapter);
        recicleViewRankingId.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getListaDoacao(){
        doacao = SugarRecord.listAll(Doacao.class);


    }

    @Override
    protected void onResume() {
        super.onResume();
        getListaDoacao();
        atualizaLista();
    }
}
