package android_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hello.Conexao;
import sjc.fatec.sp.br.bankev20.R;

public class activity_home_saldos_bancos extends AppCompatActivity {

    private Conexao c = new Conexao();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_saldos_bancos);
    }
}
