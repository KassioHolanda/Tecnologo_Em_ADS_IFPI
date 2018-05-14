package hemocentros.com.example.kassio.hemocentros.hemocentros.activitys;

import android.app.DatePickerDialog;
import android.app.Dialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Campanhas;
import hemocentros.com.example.kassio.hemocentros.model.Hospital;

public class AdicionarCampanhasActivity extends AppCompatActivity {

    private Spinner spinnerTipoSanquineoCampanhaId;
    private EditText editTextDescricaoCampanha_id;

    private EditText textViewDiaId;
    private EditText texViewMesId;
    private EditText textViewAnoId;

    private int dia, mes, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_campanhas);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));

        spinnerTipoSanquineoCampanhaId = (Spinner) findViewById(R.id.spinner_tipo_sanquineo_campanha_id);
        editTextDescricaoCampanha_id = (EditText) findViewById(R.id.edit_text_descricao_campanha_id);

        textViewDiaId = (EditText) findViewById(R.id.text_view_dia_id);
        texViewMesId = (EditText) findViewById(R.id.tex_view_mes_id);
        textViewAnoId = (EditText) findViewById(R.id.text_view_ano_id);

        ArrayAdapter<CharSequence> adapterNumeroDeBolsas = ArrayAdapter.createFromResource(this, R.array.spinner_tipo_sanguineo, android.R.layout.simple_spinner_item);
        adapterNumeroDeBolsas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoSanquineoCampanhaId.setAdapter(adapterNumeroDeBolsas);

    }

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

                String descCampanha = editTextDescricaoCampanha_id.getText().toString();
                String tipoSanguineo = spinnerTipoSanquineoCampanhaId.getSelectedItem().toString();

                dia = Integer.valueOf(textViewDiaId.getText().toString());
                mes = Integer.valueOf(texViewMesId.getText().toString());
                ano = Integer.valueOf(textViewAnoId.getText().toString());

                Campanhas novaCampanha = new Campanhas(descCampanha, tipoSanguineo,dia, mes, ano);
                novaCampanha.save();
                finish();
            case R.id.botaoCancelarId:
                finish();

        }
        return super.onOptionsItemSelected(item);
    }

}
