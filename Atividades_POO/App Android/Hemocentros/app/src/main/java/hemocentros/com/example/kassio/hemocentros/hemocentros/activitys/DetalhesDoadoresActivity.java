package hemocentros.com.example.kassio.hemocentros.hemocentros.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarRecord;

import java.util.List;

import hemocentros.com.example.kassio.hemocentros.R;
import hemocentros.com.example.kassio.hemocentros.model.Doacao;
import hemocentros.com.example.kassio.hemocentros.model.Doadores;

public class DetalhesDoadoresActivity extends AppCompatActivity {

    private TextView textViewNomeDetalheDoadoresId;
    private TextView textViewSexoDetalheDoadoresId;
    private TextView textViewSangueDetalheDoadoresId;
    private TextView textViewTelefoneDetalheDoadoresId;

    private List<Doadores> doador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_doadores);



        textViewNomeDetalheDoadoresId = (TextView) findViewById(R.id.text_view_nome_detalhe_doadores_id);
        textViewSexoDetalheDoadoresId = (TextView) findViewById(R.id.text_view_sexo_detalhe_doadores_id);
        textViewSangueDetalheDoadoresId = (TextView) findViewById(R.id.text_view_sangue_detalhe_doadores_id);
        textViewTelefoneDetalheDoadoresId = (TextView) findViewById(R.id.text_view_telefone_detalhe_doadores_id);


        Intent intent = getIntent();
        int Id = Integer.valueOf(intent.getStringExtra("doador"));

        doador = SugarRecord.listAll(Doadores.class);

        textViewNomeDetalheDoadoresId.setText(doador.get(Id-1).getNome());
        textViewSexoDetalheDoadoresId.setText(doador.get(Id-1).getSexo());
        textViewSangueDetalheDoadoresId.setText(doador.get(Id-1).getTipoDeSangue());
        textViewTelefoneDetalheDoadoresId.setText(doador.get(Id-1).getContatos());

        //Alterar cor da ActionBar
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));

    }
}
