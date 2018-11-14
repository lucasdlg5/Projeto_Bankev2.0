package android_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.NoSuchElementException;

import hello.CadastroUsuarioActivity;
import hello.Conexao;
import sjc.fatec.sp.br.bankev20.R;

public class MainActivity extends AppCompatActivity {

    Intent nextWindow;

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
        boolean doLogin = cnn.sendPostLogin(login, senha);
        //List<Usuario> teste = cnn.sendGetRecuperaUsuario(login);
        if(doLogin){
            //lblResultado.setText(String.valueOf(teste.size()));
            //lblResultado.setText("Seja bem vindo!");
            nextWindow = new Intent(MainActivity.this, activity_home.class);
            startActivity(nextWindow);

        }else
        {
            //nao entrou, aparecer mensagem
            lblResultado.setText("Vefique a Ortografia, ou tente novamente, a aplicação está alocada no Heroku, isso pode causar incosistências.");
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
