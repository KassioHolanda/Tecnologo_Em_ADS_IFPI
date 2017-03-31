package hemocentros.com.example.kassio.hemocentros.hemocentros.activitys;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarRecord;

import java.util.List;
import java.util.Map;

import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Doacao;
import hemocentros.com.example.kassio.hemocentros.model.Hospital;

public class RetiradaDeBolsasActivity extends AppCompatActivity {

    private ListView listViewListaDeBolsasDisponiveisId;

    private SeekBar seekBarNumeroDeBolsasId;
    private Spinner spinnerSelecaoDeDestinoId;

    private Doacao doacao;
    private long Id;

    private String[] lista = new String[]{"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retirada_de_bolsas);

        listViewListaDeBolsasDisponiveisId = (ListView) findViewById(R.id.list_view_lista_de_bolsas_disponiveis_id);

        spinnerSelecaoDeDestinoId = (Spinner) findViewById(R.id.spinner_selecao_de_destino_id);
        seekBarNumeroDeBolsasId = (SeekBar) findViewById(R.id.seek_bar_numero_de_bolsas_id);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, lista) {
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ((TextView) view).setTextColor(Color.parseColor("#9C27B0"));
                return view;
            }
        };


        listViewListaDeBolsasDisponiveisId.setAdapter(adapter);

        listViewListaDeBolsasDisponiveisId.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSelecionado = (String) parent.getItemAtPosition(position);
                long Id = (Long) parent.getItemIdAtPosition(position);

                int numeroDeBolsas = getListaDoacoes().get((int) Id).getQntSangueAP();

                switch (itemSelecionado) {

                    case "A+":
                        if(numeroDeBolsas == 0){
                            Toast.makeText(getApplicationContext(), "Nao existem no Estoque Bolsas A+", Toast.LENGTH_SHORT).show();
                        } else {
                            realizarDoacao();
                            seekBarNumeroDeBolsasId.setMax(getListaDoacoes().get((int) Id).getQuantidadeBolsas());

                        }

                }
            }
        });
    }

    public void realizarDoacao(){

        LayoutInflater inflater = getLayoutInflater();
        final View viewDialog = inflater.inflate(R.layout.layout_retirada_bolsas_sangue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setView(viewDialog).setTitle("Realizar Retirada de Bolsas")
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        atualizarSpinner();

                    }
                }).setNegativeButton("Cancelar", null).show();
    }

    public void atualizarSpinner(){
        ArrayAdapter<Hospital> arrayAdapter = new ArrayAdapter<Hospital>(this, android.R.layout.simple_spinner_dropdown_item, getListaHospital());
        ArrayAdapter<Hospital> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerSelecaoDeDestinoId.setAdapter(spinnerArrayAdapter);
    }

    public List<Hospital> getListaHospital(){
        List<Hospital> hospitais = SugarRecord.listAll(Hospital.class);
        return hospitais;
    }

    public List<Doacao> getListaDoacoes(){
        List<Doacao> doacoes = SugarRecord.listAll(Doacao.class);
        return doacoes;
    }
}
