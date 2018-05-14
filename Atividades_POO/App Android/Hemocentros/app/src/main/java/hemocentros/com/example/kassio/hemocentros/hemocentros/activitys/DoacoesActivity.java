package hemocentros.com.example.kassio.hemocentros.hemocentros.activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.orm.SugarRecord;

import java.util.List;

import hemocentros.com.example.kassio.hemocentros.Adapters.AdapterListaDoacoes;
import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Doacao;

public class DoacoesActivity extends AppCompatActivity {

    private RecyclerView recycleViewListaDoacoesId;
    private Button buttonAdicionarNovasDoacoesId;
    private List<Doacao> doacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_doacoes);

        recycleViewListaDoacoesId = (RecyclerView) findViewById(R.id.recycle_view_lista_doacoes_id);
        buttonAdicionarNovasDoacoesId = (Button) findViewById(R.id.button_adicionar_novas_doacoes_id);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));


        buttonAdicionarNovasDoacoesId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DoacoesActivity.this);
                builder.setTitle("Participe de uma Campanha");
                builder.setMessage("Ajude a Nossa campanha e venha participar!");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), CampanhasParaDoacaoActivity.class));
                    }
                });
                builder.setNegativeButton("Nao", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), DoadoresParaDoacaoActivity.class));
                    }
                }).show();

            }
        });
    }


    public List<Doacao> getListaDoacao(){
        doacao = SugarRecord.listAll(Doacao.class);
        return doacao;
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tela_doacoes, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_area_doadores_id:
                startActivity(new Intent(getApplicationContext(), DoadoresActivity.class));
                break;
            case R.id.menu_area_dos_hospitais_id:
                startActivity(new Intent(getApplicationContext(), HospitaisActivity.class));
                break;
            case R.id.menu_nova_campanha_id:
                startActivity(new Intent(getApplicationContext(), CampanhasActivity.class));
                break;
            case R.id.menu_saida_bolsas_id:
                startActivity(new Intent(getApplicationContext(), RetiradaDeBolsasActivity.class));
                break;
            case R.id.menu_estoque_id:
                startActivity(new Intent(getApplicationContext(), EstoqueActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaLista();
    }

    public void atualizaLista(){
        AdapterListaDoacoes adapter = new AdapterListaDoacoes(this, getListaDoacao());
        recycleViewListaDoacoesId.setAdapter(adapter);
        recycleViewListaDoacoesId.setLayoutManager(new LinearLayoutManager(this));
    }
}

