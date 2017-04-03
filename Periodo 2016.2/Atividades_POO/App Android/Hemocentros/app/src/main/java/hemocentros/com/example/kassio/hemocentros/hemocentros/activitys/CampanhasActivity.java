package hemocentros.com.example.kassio.hemocentros.hemocentros.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.orm.SugarRecord;

import java.util.List;

import hemocentros.com.example.kassio.hemocentros.Adapters.AdpterListaCampanhas;
import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Campanhas;

public class CampanhasActivity extends AppCompatActivity {

    private Button buttonAdicionarNovasCampanhasId;
    private RecyclerView recycleViewListaCampanhas_id;
    private List<Campanhas> listaCampanhas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanhas);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));

        buttonAdicionarNovasCampanhasId = (Button) findViewById(R.id.button_adicionar_novas_campanhas_id);
        recycleViewListaCampanhas_id = (RecyclerView) findViewById(R.id.recycle_view_lista_campanhas_id);

        buttonAdicionarNovasCampanhasId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AdicionarCampanhasActivity.class));
            }
        });
    }


    public List<Campanhas> getListaCampanha(){
        listaCampanhas = SugarRecord.listAll(Campanhas.class);
        return listaCampanhas;
    }

    public void atualizarLista(){
        AdpterListaCampanhas adapter = new AdpterListaCampanhas(this, getListaCampanha());
        recycleViewListaCampanhas_id.setAdapter(adapter);
        recycleViewListaCampanhas_id.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onResume(){
        super.onResume();
        atualizarLista();
    }
}


