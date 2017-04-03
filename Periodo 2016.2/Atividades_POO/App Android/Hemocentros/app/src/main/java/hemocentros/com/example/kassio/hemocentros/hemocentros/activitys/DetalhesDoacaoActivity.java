package hemocentros.com.example.kassio.hemocentros.hemocentros.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarRecord;

import java.util.List;

import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Doacao;
import hemocentros.com.example.kassio.hemocentros.model.Doadores;

public class DetalhesDoacaoActivity extends AppCompatActivity {

    private TextView textViewNomeDetalheDoacaoId;
    private TextView textViewCampanhaDetalheDoacaoId;
    private TextView textViewTipoSangueDetalheDoacaoId;
    private TextView textViewNumeroDeDoacoesId;
    private TextView textViewDataDoacaoId;

    private List<Doacao> doacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destalhes_doacao);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));

        Intent intent = getIntent();

        int Id = Integer.valueOf(intent.getStringExtra("doacao"));

        doacao = SugarRecord.listAll(Doacao.class);

        textViewNomeDetalheDoacaoId = (TextView) findViewById(R.id.text_view_nome_detalhe_doacao_id);
        textViewCampanhaDetalheDoacaoId = (TextView) findViewById(R.id.text_view_campanha_detalhe_doacao_id);
        textViewTipoSangueDetalheDoacaoId = (TextView) findViewById(R.id.text_view_tipo_sangue_detalhe_doacao_id);
        textViewNumeroDeDoacoesId = (TextView) findViewById(R.id.text_view_numero_de_doacoes_id);
        textViewDataDoacaoId = (TextView) findViewById(R.id.text_view_data_doacao_id);

    }
}