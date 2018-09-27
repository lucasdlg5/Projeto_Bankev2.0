package hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import sjc.fatec.sp.br.bankev20.R;

public class CadastroBancoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_banco);
    }

    public void onClickSearch(View view){
        TextView txtNomeCompleto = findViewById(R.id.txtNomeCompleto);
        TextView txtCPF = findViewById(R.id.txtCPF);
        TextView txtEmail = findViewById(R.id.email);
        TextView txtLogin = findViewById(R.id.txtLogin);
        TextView txtSenha = findViewById(R.id.txtSenha);
        TextView txtConta = findViewById(R.id.txtConta);

        String nome = String.valueOf(txtNomeCompleto.getText());
        String cpf = String.valueOf(txtCPF.getText());
        String emai = String.valueOf(txtEmail.getText());
        String login = String.valueOf(txtLogin.getText());
        String senha = String.valueOf(txtSenha.getText());
        String conta = String.valueOf(txtConta.getText());

        try{
            Conexao cnn = new Conexao();

        }catch{

        }
    }
}
