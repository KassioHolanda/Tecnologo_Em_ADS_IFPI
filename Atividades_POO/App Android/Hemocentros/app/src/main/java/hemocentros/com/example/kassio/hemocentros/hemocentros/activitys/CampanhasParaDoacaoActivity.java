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

public class CampanhasParaDoacaoActivity extends AppCompatActivity {

    private ListView listViewListaCampanhas_id;
    private List<Campanhas> campanhas;
    private Campanhas campanhasSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanhas_para_doacao);

        listViewListaCampanhas_id = (ListView) findViewById(R.id.list_view_lista_campanhas_id);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));

        ArrayAdapter<Campanhas> adapter = new ArrayAdapter<Campanhas>(getApplicationContext(), android.R.layout.simple_list_item_1, getListaCampanhas()){

            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ((TextView) view).setTextColor(Color.parseColor("#9C27B0"));
                return view;
            };
        };

        listViewListaCampanhas_id.setAdapter(adapter);

        listViewListaCampanhas_id.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                campanhasSelecionada = (Campanhas) parent.getItemAtPosition(position);

                startActivity(new Intent(getApplicationContext(), DoadoresParaDoacaoActivity.class)
                        .putExtra("campanha", String.valueOf(campanhasSelecionada.getId()-1)));
            }
        });
    }

    public List<Campanhas> getListaCampanhas(){
        campanhas = SugarRecord.listAll(Campanhas.class);
        return campanhas;
    }
}
