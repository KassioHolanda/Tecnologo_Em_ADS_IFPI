package hemocentros.com.example.kassio.hemocentros.hemocentros.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.orm.SugarRecord;

import java.util.List;

import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Doadores;

public class AdicionarDoadoresActivity extends AppCompatActivity {

    private Spinner spinnerTipoSanguineo;
    private Spinner spinnerSexo;
    private EditText nome;
    private EditText telefone;


    private List<Doadores> listaDeDoadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_doadores);

        nome = (EditText) findViewById(R.id.ediTextNomeDoadorId);
        telefone = (EditText) findViewById(R.id.editTextTelefoneId);
        spinnerSexo = (Spinner) findViewById(R.id.spinner_sexo);
        spinnerTipoSanguineo = (Spinner) findViewById(R.id.spinner_tipo_sanquineo);


        ArrayAdapter<CharSequence> adapterTipoSanguineo = ArrayAdapter.createFromResource(this, R.array.spinner_tipo_sanguineo, android.R.layout.simple_spinner_item);
        adapterTipoSanguineo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoSanguineo.setAdapter(adapterTipoSanguineo);

        ArrayAdapter<CharSequence> adpterSexo = ArrayAdapter.createFromResource(this, R.array.spinner_sexo, android.R.layout.simple_spinner_item);
        adpterSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSexo.setAdapter(adpterSexo);


        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_salvar, menu);
        inflater.inflate(R.menu.menu_cancelar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.botaoSalvarId:
                String nomeDoador = nome.getText().toString();
                String sexoDoador = spinnerSexo.getSelectedItem().toString();
                String tipoDeSangueDoador = spinnerTipoSanguineo.getSelectedItem().toString();
                String telefoneDoador = telefone.getText().toString();

                if(nomeDoador == null || nomeDoador.equals("")){
                    Toast.makeText(getApplicationContext(), "Nome obrigatorio", Toast.LENGTH_SHORT).show();
                } else {
                    Doadores novoDoador = new Doadores(nomeDoador, sexoDoador, tipoDeSangueDoador, telefoneDoador);

                    if(consultarDoador(novoDoador.getNome())){
                        novoDoador.save();
                        Toast.makeText(getApplicationContext(), "Doador Cadastrado com Sucesso", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Doador Ja esta Cadastrado", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

                break;
            case R.id.botaoCancelarId:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean consultarDoador(String nome){
        List<Doadores> doadores = Doadores.findWithQuery(Doadores.class, "Select * from Doadores where nome = ?", nome);
        if (doadores.size() != 0){
            return false;
        } else {
            return true;
        }
    }
}
