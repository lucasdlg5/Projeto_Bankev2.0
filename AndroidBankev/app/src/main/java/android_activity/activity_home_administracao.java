package android_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import sjc.fatec.sp.br.bankev20.R;

public class activity_home_administracao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_administracao);

        final Button button = findViewById(R.id.button8);
        final Button btn_busca_usuarios = findViewById(R.id.button9);
        final Button btn_relatorio_saldos = findViewById(R.id.button10);
        final Button btn_genc_faturas = findViewById(R.id.button11);
        final Button btn_business_inteligence = findViewById(R.id.button12);
        final Button btn_banco_informacoes = findViewById(R.id.button13);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextWindow = new Intent(v.getContext(), activity_adm_listar_usuarios.class);
                startActivity(nextWindow);
            }
        });

        btn_busca_usuarios.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextWindow = new Intent(v.getContext(), activity_adm_busca_usuarios.class);
                startActivity(nextWindow);
            }
        });

        btn_relatorio_saldos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextWindow = new Intent(v.getContext(), activity_adm_relatorio_saldos.class);
                startActivity(nextWindow);
            }
        });

        btn_genc_faturas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextWindow = new Intent(v.getContext(), activity_adm_genc_faturas.class);
                startActivity(nextWindow);
            }
        });

        btn_business_inteligence.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextWindow = new Intent(v.getContext(), activity_adm_business_inteligence.class);
                startActivity(nextWindow);
            }
        });

        btn_banco_informacoes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextWindow = new Intent(v.getContext(), activity_adm_banco_informacoes.class);
                startActivity(nextWindow);
            }
        });
    }
}
