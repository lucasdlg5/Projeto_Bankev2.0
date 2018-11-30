package android_activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

import hello.Conexao;
import sjc.fatec.sp.br.bankev20.R;

public class activity_signup extends AppCompatActivity {

    Intent nextWindow;


    private void toastShowMsg(String textMsg){

        Context context = getApplicationContext();
        CharSequence textToast = textMsg;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, textToast, duration);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void openLoginPage(View v){
        nextWindow = new Intent(v.getContext(), MainActivity.class);
        startActivity(nextWindow);
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
                toastShowMsg("Usuario Cadastrado com Sucesso");
                nextWindow = new Intent(view.getContext(), MainActivity.class);
                startActivity(nextWindow);
//                lblCadResultado.setText("Usuario Cadastrado com Sucesso");

            }
            else{
//                lblCadResultado.setText("Falha ao cadastrar, tente novamente em breve");
                toastShowMsg("Falha ao cadastrar, tente novamente em breve");

            }

        } catch (IOException e) {
            lblCadResultado.setText(e.getMessage());
            toastShowMsg(e.getMessage());
        } catch (JSONException e) {
            lblCadResultado.setText(e.getMessage());
            toastShowMsg(e.getMessage());
        }
    }
}
