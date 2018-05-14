package hemocentros.com.example.kassio.hemocentros.hemocentros.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.orm.SugarRecord;

import java.util.List;

import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Campanhas;
import hemocentros.com.example.kassio.hemocentros.model.Doadores;

public class DoadoresParaDoacaoActivity extends AppCompatActivity {

    private ListView listViewListaUsuarioDoacaoId;
    private Doadores selecionarDoador;
    private List<Campanhas> campanhasSelecionadas;

    private List<Doadores> listaDoadores;
    private String doadoresEspecificos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doadores_para_doacao);

        listViewListaUsuarioDoacaoId = (ListView) findViewById(R.id.list_view_lista_usuario_doacao_id);
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));


        final Intent intentCampanha = getIntent();

        if(intentCampanha.getStringExtra("campanha")!= null){
            int id = Integer.valueOf(intentCampanha.getStringExtra("campanha"));

        } else {
            atualizarLista();
        }

        listViewListaUsuarioDoacaoId.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selecionarDoador = (Doadores) parent.getItemAtPosition(position);
                startActivity(new Intent(getApplicationContext(), AdicionarDoacaoActivity.class)
                        .putExtra("doadores", String.valueOf(selecionarDoador.getId()-1))
                        .putExtra("campanha", intentCampanha.getStringExtra("campanha")));
            }
        });
    }

    public List<Doadores> getListaDoadores(){
        listaDoadores = SugarRecord.listAll(Doadores.class);
        return listaDoadores;
    }

    public void atualizarLista(){
        ArrayAdapter<Doadores> adpter = new ArrayAdapter<Doadores>(getApplicationContext(), android.R.layout.simple_list_item_1, getListaDoadores()) {
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ((TextView) view).setTextColor(Color.parseColor("#9C27B0"));
                return view;
            }
        };
        listViewListaUsuarioDoacaoId.setAdapter(adpter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
    }
}
