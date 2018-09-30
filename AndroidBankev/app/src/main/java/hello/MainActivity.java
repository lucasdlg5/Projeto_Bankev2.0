package hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import sjc.fatec.sp.br.bankev20.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickSearch(View view){
        TextView txtLogin = findViewById(R.id.txtLogin);
        TextView txtSenha = findViewById(R.id.txtSenha);
        TextView lblResultado = findViewById(R.id.lblResultado);

        String login = String.valueOf(txtLogin.getText());
        String senha = String.valueOf(txtSenha.getText());
        try{
        Conexao cnn = new Conexao();
        boolean testeLogin = cnn.sendPostLogin(login, senha);
        //List<Usuario> teste = cnn.sendGetRecuperaUsuario(login);
        if(testeLogin){
            //lblResultado.setText(String.valueOf(teste.size()));
            lblResultado.setText("Seja bem vindo!");
        }else
        {
            //nao entrou, aparecer mensagem
            lblResultado.setText("Vefique a Ortografia");
        }
        }catch(Exception e){
            lblResultado.setText(e.toString());
        }

    }

    public void openCadastroBanco(View v){
        Intent intent = new Intent(this, CadastroUsuarioActivity.class);
        startActivity(intent);
    }
}
