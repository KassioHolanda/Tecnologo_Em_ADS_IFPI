package hemocentros.com.example.kassio.hemocentros.hemocentros.activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.orm.SugarRecord;

import java.util.List;

import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Doadores;

public class DoadoresActivity extends AppCompatActivity {

    private ListView listaDeDoadores;
    private Doadores doadorSelecionado;
    private Button button_adicionar_novos_doadores_id;


    //ID dos spinners no layout de Edição

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doadores);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));

        listaDeDoadores = (ListView) findViewById(R.id.listViewListaDoadoresId);
        button_adicionar_novos_doadores_id = (Button) findViewById(R.id.button_adicionar_novos_doadores_id);

        atualizaLista();

        listaDeDoadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                doadorSelecionado = (Doadores) parent.getItemAtPosition(position);

                startActivity(new Intent(getApplicationContext(), DetalhesDoadoresActivity.class).putExtra("doador", String.valueOf(doadorSelecionado.getId())));
            }
        });

        listaDeDoadores.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                doadorSelecionado = (Doadores) parent.getItemAtPosition(position);
                return false;
            }
        });

        button_adicionar_novos_doadores_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AdicionarDoadoresActivity.class));
            }
        });


        registerForContextMenu(listaDeDoadores);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuItem remover = menu.add("Remover Dodos");

        remover.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DoadoresActivity.this);
                builder.setTitle("Remoção").setMessage("Deseja remover os dados de " + doadorSelecionado.getNome()).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        doadorSelecionado.delete();
                        atualizaLista();
                    }
                }).setNegativeButton("Nao", null).show();
                return false;
            }
        });
    }

    public void atualizaLista(){
    ArrayAdapter<Doadores> doadores = new ArrayAdapter<Doadores>(DoadoresActivity.this, android.R.layout.simple_list_item_1, getListaDeDoadores()){
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            ((TextView) view).setTextColor(Color.parseColor("#9C27B0"));
            return view;
        };
    };
    listaDeDoadores.setAdapter(doadores);
    }


    public List<Doadores> getListaDeDoadores(){
        List<Doadores> lista = SugarRecord.listAll(Doadores.class);
        return lista;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ranking_doadores, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(getApplicationContext(), RankingDoadoresActivity.class));
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaLista();
    }
}
