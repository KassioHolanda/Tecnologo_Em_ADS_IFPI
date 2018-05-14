package hemocentros.com.example.kassio.hemocentros.hemocentros.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.orm.SugarRecord;

import java.util.List;

import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Campanhas;
import hemocentros.com.example.kassio.hemocentros.model.Doacao;
import hemocentros.com.example.kassio.hemocentros.model.Doadores;
import hemocentros.com.example.kassio.hemocentros.model.Hospital;

public class AdicionarDoacaoActivity extends AppCompatActivity {

    private Spinner spinnerEscolherUnidadeDoacaoId;
    private Spinner spinnerNumeroDeBolsasId;
    private EditText editTextDestinoDoacaoId;
    private ToggleButton tooggleButtonDirecionarDoacaoId;
    private TextView textViewNomeDoadorId;
    private TextView textViewSelecionarHospitaisId;
    private TextView textViewCamapnhaId;
    private TextView textViewTipoSagueCampanha_id;
    private TextView textViewTextoCampanha;

    private TextView textViewTipoDeSangueId;
    private TextView textViewTipoSangueId;

    private List<Hospital> listaHospitals;
    private List<Campanhas> listaCampanhas;

    private Campanhas campanhaSelecionada;

    private Doadores doadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_doacao);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));


        Intent intentDoadores = getIntent();
        doadores = getListaDoadores().get(Integer.valueOf(intentDoadores.getStringExtra("doadores")));

        textViewSelecionarHospitaisId = (TextView) findViewById(R.id.text_view_selecionar_hospitais_id);
        textViewCamapnhaId = (TextView) findViewById(R.id.text_view_camapnha__id);
        textViewNomeDoadorId = (TextView) findViewById(R.id.text_view_nome_doador_id);
        textViewTipoSagueCampanha_id = (TextView) findViewById(R.id.tex_view_tipo_sague_campanha_id);

        textViewTipoDeSangueId = (TextView) findViewById(R.id.text_view_tipo_de_sangue_id);
        textViewTipoSangueId = (TextView) findViewById(R.id.text_view_tipo_sangue_id);

        spinnerEscolherUnidadeDoacaoId = (Spinner) findViewById(R.id.spinner_escolher_unidade_doacao_id);
        spinnerNumeroDeBolsasId = (Spinner) findViewById(R.id.spinner_numero_de_bolsas_id);
        tooggleButtonDirecionarDoacaoId = (ToggleButton) findViewById(R.id.tooggle_button_direcionar_doacao_id);
        editTextDestinoDoacaoId = (EditText) findViewById(R.id.edit_text_destino_doacao_id);
        textViewTextoCampanha = (TextView) findViewById(R.id.text_view_texto_campanha);

        Intent intentCampanha = getIntent();

        if (intentCampanha.getStringExtra("campanha") != null) {
            int id = Integer.valueOf(intentCampanha.getStringExtra("campanha"));
            Toast.makeText(getApplicationContext(), "Campanha Selecionada", Toast.LENGTH_SHORT).show();

            campanhaSelecionada = getListaCampanha().get(id);

            textViewTipoSagueCampanha_id.setText(getListaCampanha().get(id).getTipoSangue());
            textViewCamapnhaId.setText(getListaCampanha().get(id).getDescricao());
;

            textViewCamapnhaId.setText(getListaCampanha().get(id).getDescricao());
            textViewTipoDeSangueId.setText(getListaCampanha().get(id).getTipoSangue());
        }

        textViewNomeDoadorId.setText(doadores.getNome());

        atualizaLista();

        ArrayAdapter<CharSequence> adapterNumeroDeBolsas = ArrayAdapter.createFromResource(this, R.array.spinner_bolsas_sangue, android.R.layout.simple_spinner_item);
        adapterNumeroDeBolsas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumeroDeBolsasId.setAdapter(adapterNumeroDeBolsas);

        tooggleButtonDirecionarDoacaoId.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editTextDestinoDoacaoId.setVisibility(editTextDestinoDoacaoId.VISIBLE);
                    textViewSelecionarHospitaisId.setVisibility(textViewSelecionarHospitaisId.VISIBLE);
                    spinnerEscolherUnidadeDoacaoId.setVisibility(spinnerEscolherUnidadeDoacaoId.VISIBLE);
                } else {
                    editTextDestinoDoacaoId.setVisibility(editTextDestinoDoacaoId.INVISIBLE);
                    textViewSelecionarHospitaisId.setVisibility(textViewSelecionarHospitaisId.INVISIBLE);
                    spinnerEscolherUnidadeDoacaoId.setVisibility(spinnerEscolherUnidadeDoacaoId.INVISIBLE);
                }
            }
        });
    }

    private void atualizaLista() {

        ArrayAdapter<Hospital> arrayAdapter = new ArrayAdapter<Hospital>(this, android.R.layout.simple_spinner_dropdown_item, getListaUnidade());
        ArrayAdapter<Hospital> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerEscolherUnidadeDoacaoId.setAdapter(spinnerArrayAdapter);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_salvar, menu);
        inflater.inflate(R.menu.menu_cancelar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.botaoSalvarId:

                int numeroDeBolsas = Integer.valueOf(spinnerNumeroDeBolsasId.getSelectedItem().toString());
                String unidadeSelecionada = "Não foi Especificado";

                if (!tooggleButtonDirecionarDoacaoId.isChecked()) {

                    unidadeSelecionada = "Não foi Especificado";
                } else {
                    try {
                        Toast.makeText(getApplicationContext(), "Doação Direcionada a um Paciente", Toast.LENGTH_LONG).show();
                        unidadeSelecionada = String.valueOf(spinnerEscolherUnidadeDoacaoId.getSelectedItem().toString());
                    } catch (NullPointerException o) {
                        Toast.makeText(getApplicationContext(), "Hospital não foi Mencionado", Toast.LENGTH_SHORT).show();
                    }
                }

                Doacao novaDoacao = new Doacao(numeroDeBolsas, doadores, unidadeSelecionada, campanhaSelecionada);

                if (!tooggleButtonDirecionarDoacaoId.isChecked()) {
                    adicionarBancoDeSangue(novaDoacao.getDoador().getTipoDeSangue(), novaDoacao);
                }

                if (consultarDoacao(novaDoacao.getDoador().getNome())) {
                    novaDoacao.save();
                    Toast.makeText(getApplicationContext(), "Doação realizada", Toast.LENGTH_SHORT).show();
                    if (!tooggleButtonDirecionarDoacaoId.isChecked()) {
                        Toast.makeText(getApplicationContext(), "Doação Livre", Toast.LENGTH_SHORT).show();
                    } else {

                    }

                    startActivity(new Intent(getApplicationContext(), DoacoesActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Doador nao pode Realizar outra Doação no Momento", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), DoacoesActivity.class));
                }


            case R.id.botaoCancelarId:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public List<Hospital> getListaUnidade() {
        listaHospitals = SugarRecord.listAll(Hospital.class);
        return listaHospitals;
    }


    //Adicionar bolsas doadas ao estoque de sangue
    public void adicionarBancoDeSangue(String tipoDeSangue, Doacao doacao) {
        if (tipoDeSangue.equals("A+")) {
            doacao.setQntSangueAP(doacao.getQuantidadeBolsas());
            Toast.makeText(getApplicationContext(), "Bolsa Adicionada Ao Estoque", Toast.LENGTH_SHORT).show();
        }
        if (tipoDeSangue.equals("A-")) {
            doacao.setQntSangueAN(doacao.getQuantidadeBolsas());
            Toast.makeText(getApplicationContext(), "Bolsa Adicionada Ao Estoque", Toast.LENGTH_SHORT).show();
        }
        if (tipoDeSangue.equals("B+")) {
            doacao.setQntSangueBP(doacao.getQuantidadeBolsas());
            Toast.makeText(getApplicationContext(), "Bolsa Adicionada Ao Estoque", Toast.LENGTH_SHORT).show();
        }
        if (tipoDeSangue.equals("B-")) {
            doacao.setQntSangueBN(doacao.getQuantidadeBolsas());
            Toast.makeText(getApplicationContext(), "Bolsa Adicionada Ao Estoque", Toast.LENGTH_SHORT).show();
        }
        if (tipoDeSangue.equals("AB+")) {
            doacao.setQntSangueABP(doacao.getQuantidadeBolsas());
            Toast.makeText(getApplicationContext(), "Bolsa Adicionada Ao Estoque", Toast.LENGTH_SHORT).show();
        }
        if (tipoDeSangue.equals("AB-")) {
            doacao.setQntSangueABN(doacao.getQuantidadeBolsas());
            Toast.makeText(getApplicationContext(), "Bolsa Adicionada Ao Estoque", Toast.LENGTH_SHORT).show();
        }
        if (tipoDeSangue.equals("O+")) {
            doacao.setQntSangueOP(doacao.getQuantidadeBolsas());
            Toast.makeText(getApplicationContext(), "Bolsa Adicionada Ao Estoque", Toast.LENGTH_SHORT).show();
        }
        if (tipoDeSangue.equals("O-")) {
            doacao.setQntSangueON(doacao.getQuantidadeBolsas());
            Toast.makeText(getApplicationContext(), "Bolsa Adicionada Ao Estoque", Toast.LENGTH_SHORT).show();
        }
    }

    public List<Campanhas> getListaCampanha() {
        listaCampanhas = SugarRecord.listAll(Campanhas.class);
        return listaCampanhas;
    }

    public List<Doadores> getListaDoadores() {
        List<Doadores> doadores = SugarRecord.listAll(Doadores.class);
        return doadores;
    }

    public List<Doacao> getListaDoacao(){
        List<Doacao> doacoes = SugarRecord.listAll(Doacao.class);
        return doacoes;
    }

    public boolean consultarDoacao(String nome) {

        for(int i = 0; i < getListaDoacao().size(); i++){
            if(nome.equals(getListaDoacao().get(i).getDoador().getNome())){
                return false;
            }
        }
        return true;
    }

}