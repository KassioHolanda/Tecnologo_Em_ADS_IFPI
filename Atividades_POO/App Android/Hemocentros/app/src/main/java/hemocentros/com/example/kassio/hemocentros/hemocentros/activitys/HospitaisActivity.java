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
import hemocentros.com.example.kassio.hemocentros.model.Hospital;

public class HospitaisActivity extends AppCompatActivity {

    private ListView listViewListaDeUnidadeId;
    private Hospital hospitalSelecionada;
    private Button buttonAdicionarNovosHospitais;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_hospital);

        listViewListaDeUnidadeId = (ListView) findViewById(R.id.listViewListaDeHospitaisId);
        buttonAdicionarNovosHospitais = (Button) findViewById(R.id.button_adicionar_novos_hospitais);

        atualizaLista();

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));

        listViewListaDeUnidadeId.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                hospitalSelecionada = (Hospital) parent.getItemAtPosition(position);
                startActivity(new Intent(getApplicationContext(), DetalhesUnidadeActivity.class)
                        .putExtra("nome", hospitalSelecionada.getNome())
                        .putExtra("contato", hospitalSelecionada.getContatos()));
            }
        });


        listViewListaDeUnidadeId.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                hospitalSelecionada = (Hospital) parent.getItemAtPosition(position);

                return false;
            }
        });

        buttonAdicionarNovosHospitais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AdicionarHospitalActivity.class));

            }
        });

        registerForContextMenu(listViewListaDeUnidadeId);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuItem remover = menu.add("Remover Dados");

        remover.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HospitaisActivity.this);
                builder.setTitle("Remoção").setMessage("Deseja remover os dados de " + hospitalSelecionada.getNome()).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        hospitalSelecionada.delete();
                        atualizaLista();
                    }
                }).setNegativeButton("Nao", null).show();
                return false;
            }
        });

    }

    public void atualizaLista(){
        ArrayAdapter<Hospital> doadores = new ArrayAdapter<Hospital>(getApplicationContext(), android.R.layout.simple_list_item_1, getListaUnidade()){
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ((TextView) view).setTextColor(Color.parseColor("#9C27B0"));
                return view;
            };
        };
        listViewListaDeUnidadeId.setAdapter(doadores);
    }

    public List<Hospital> getListaUnidade() {
        List<Hospital> listaHospitals = SugarRecord.listAll(Hospital.class);
        return listaHospitals;
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaLista();
    }
}


