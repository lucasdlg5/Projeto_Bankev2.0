package hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import hello.Conexao;
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
        List<Usuario> teste = cnn.sendGetRecuperaUsuario(login);
        if(testeLogin){
            lblResultado.setText(String.valueOf(teste.size()));
            //entrou pasasar para outra tela
        }else
        {
            //nao entrou, aparecer mensagem
            lblResultado.setText("Vefique ortagrafia");
        }
        }catch(Exception e){
            lblResultado.setText(e.toString());
        }

    }
}
