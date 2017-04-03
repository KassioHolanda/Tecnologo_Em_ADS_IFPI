package hemocentros.com.example.kassio.hemocentros.hemocentros.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.orm.SugarRecord;

import java.util.List;

import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Doadores;
import hemocentros.com.example.kassio.hemocentros.model.Hospital;

public class AdicionarHospitalActivity extends AppCompatActivity {

    private EditText editTextNovaUnidadeId;
    private EditText editTextNovoContatoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_hopital);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));

        editTextNovaUnidadeId = (EditText) findViewById(R.id.edit_text_nova_unidade_id);
        editTextNovoContatoId = (EditText) findViewById(R.id.edit_text_novo_contato_id);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_salvar, menu);
        inflater.inflate(R.menu.menu_cancelar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.botaoSalvarId:

                String nome = editTextNovaUnidadeId.getText().toString();
                String contato = editTextNovoContatoId.getText().toString();

                if(nome == null || nome.equals("")){
                    Toast.makeText(getApplicationContext(), "Nome obrigatorio", Toast.LENGTH_SHORT).show();
                } else {
                    Hospital hospital = new Hospital(nome.toUpperCase(), contato);

                    if(consultarHospital(hospital.getNome())){
                        hospital.save();
                        Toast.makeText(getApplicationContext(), "Hospital Cadastrado com Sucesso", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Hospital ja esta Cadastrado", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }

                break;
            case R.id.botaoCancelarId:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean consultarHospital(String nome){
        List<Hospital> hospital = Hospital.findWithQuery(Hospital.class, "select * from Hospital where nome = ?", nome);
        if (hospital.size() != 0){
            return false;
        } else {
            return true;
        }
    }
}
