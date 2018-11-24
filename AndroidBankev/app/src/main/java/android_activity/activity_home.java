package android_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import sjc.fatec.sp.br.bankev20.R;

public class activity_home extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final Button button = findViewById(R.id.button2);
        final Button btn_bancos_meu_cpf = findViewById(R.id.button3);
        final Button btn_contas_a_pagar = findViewById(R.id.button4);
        final Button btn_faturas_cartao = findViewById(R.id.button5);
        final Button btn_saldos_bancos = findViewById(R.id.button6);
        final Button btn_perfil = findViewById(R.id.button7);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextWindow = new Intent(v.getContext(), activity_home_administracao.class);
                startActivity(nextWindow);
            }
        });

        btn_bancos_meu_cpf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextWindow = new Intent(v.getContext(), activity_home_bancos_meu_cpf.class);
                startActivity(nextWindow);
            }
        });

        btn_contas_a_pagar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextWindow = new Intent(v.getContext(), activity_home_contas_a_pagar.class);
                startActivity(nextWindow);
            }
        });

        btn_faturas_cartao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextWindow = new Intent(v.getContext(), activity_home_faturas_cartao.class);
                startActivity(nextWindow);
            }
        });

        btn_saldos_bancos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextWindow = new Intent(v.getContext(), activity_home_saldos_bancos.class);
                startActivity(nextWindow);
            }
        });

        btn_perfil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nextWindow = new Intent(v.getContext(), activity_home_perfil.class);
                startActivity(nextWindow);
            }
        });
    }
}
