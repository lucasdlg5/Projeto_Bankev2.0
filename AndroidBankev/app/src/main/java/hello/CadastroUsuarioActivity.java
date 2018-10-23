package hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;

import sjc.fatec.sp.br.bankev20.R;

public class CadastroUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
    }

    public void onClickSearch(View view){
        TextView txtNomeCompleto = findViewById(R.id.txtNomeCompleto);
        TextView txtCPF = findViewById(R.id.txtCPF);
        TextView txtEmail = findViewById(R.id.txtEmail);
        TextView txtLogin = findViewById(R.id.txtLogin);
        TextView txtSenha = findViewById(R.id.txtSenha);
        TextView txtConta = findViewById(R.id.txtConta);
        TextView lblCadResultado = findViewById(R.id.lblCadResultado);

        String nome = String.valueOf(txtNomeCompleto.getText());
        String cpf = String.valueOf(txtCPF.getText());
        String email = String.valueOf(txtEmail.getText());
        String login = String.valueOf(txtLogin.getText());
        String senha = String.valueOf(txtSenha.getText());
        String conta = String.valueOf(txtConta.getText());

        Conexao cnn = new Conexao();
        try {
            if(cnn.SendGetCadUsuario(nome, cpf, email, login, senha, conta)){
                lblCadResultado.setText("Usuario Cadastrado com Sucesso");
                /*todo ir para tela de perfil*/
            }
            else{
                lblCadResultado.setText("Falha ao cadastrar, tente novamente em breve");
            }

        } catch (IOException e) {
            lblCadResultado.setText(e.getMessage());
        } catch (JSONException e) {
            lblCadResultado.setText(e.getMessage());
        }
    }
}
