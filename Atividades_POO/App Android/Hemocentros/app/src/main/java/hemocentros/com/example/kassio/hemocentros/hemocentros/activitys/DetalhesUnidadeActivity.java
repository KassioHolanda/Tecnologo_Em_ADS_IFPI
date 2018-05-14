package hemocentros.com.example.kassio.hemocentros.hemocentros.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import hemocentros.com.example.kassio.hemocentros.R;

public class DetalhesUnidadeActivity extends AppCompatActivity {

    private TextView textViewUnidadeDetalheDoadoresId;
    private TextView textViewTelefoneDetalheDoadoresId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_hospital);

        textViewUnidadeDetalheDoadoresId = (TextView) findViewById(R.id.text_view_unidade_detalhe_doadores_id);
        textViewTelefoneDetalheDoadoresId = (TextView) findViewById(R.id.text_view_telefone_detalhe_doadores_id);

        Intent intent = getIntent();
        textViewUnidadeDetalheDoadoresId.setText(intent.getStringExtra("nome"));
        textViewTelefoneDetalheDoadoresId.setText(intent.getStringExtra("contato"));


        //Alterar a Cor da ActionBar
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));

    }
}
