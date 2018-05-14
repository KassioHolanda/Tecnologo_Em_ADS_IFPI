package hemocentros.com.example.kassio.hemocentros.hemocentros.activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.orm.SugarRecord;

import java.util.List;

import hemocentros.com.example.kassio.hemocentros.Adapters.AdapterListaDoacoes;
import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Doacao;
import hemocentros.com.example.kassio.hemocentros.model.Hospital;

public class EstoqueActivity extends AppCompatActivity {

    private TextView numeroDeBolsasId;
    private List<Doacao> doacao;
    private Spinner spinnerSelecaoDeDestinoId;
    private int totalDeBolsas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estoque);

        numeroDeBolsasId = (TextView) findViewById(R.id.numero_de_bolsas_id);
        numeroDeBolsasId.setText(String.valueOf(totalDeBolsas));
    }

    public void getListaDoacao() {
        doacao = SugarRecord.listAll(Doacao.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu_retirada_sangue, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LayoutInflater inflater = getLayoutInflater();
        final View viewDialog = inflater.inflate(R.layout.layout_retirada_bolsas_sangue, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        spinnerSelecaoDeDestinoId = (Spinner) findViewById(R.id.spinner_selecao_de_destino_id);

        builder.setView(viewDialog).setTitle("Realizar Retirada de Bolsas");
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                atualizarSpinner();
            }

        }).setNegativeButton("Cancelar", null).show();

        return super.onOptionsItemSelected(item);
    }

    public void atualizarSpinner() {
        ArrayAdapter<Hospital> arrayAdapter = new ArrayAdapter<Hospital>(this, android.R.layout.simple_spinner_dropdown_item, getListaHospital());
        ArrayAdapter<Hospital> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerSelecaoDeDestinoId.setAdapter(spinnerArrayAdapter);
    }


    public List<Hospital> getListaHospital() {
        List<Hospital> hospitais = SugarRecord.listAll(Hospital.class);
        return hospitais;
    }
}

