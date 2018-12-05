package android_activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import hello.Conexao;
import sjc.fatec.sp.br.bankev20.R;

public class MainActivity extends AppCompatActivity {

    Intent nextWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }




    private void toastShowMsg(String textMsg){

        Context context = getApplicationContext();
        CharSequence textToast = textMsg;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, textToast, duration);
        toast.show();
    }
    public void onClickSearch(View view){




        TextView txtLogin = findViewById(R.id.txtLogin);
        TextView txtSenha = findViewById(R.id.txtSenha);
        TextView lblResultado = findViewById(R.id.lblResultado);

//        String login = String.valueOf(txtLogin.getText());
//        String senha = String.valueOf(txtSenha.getText());

        String login = "lucasdlg";
        String senha = "123";
        try{
        Conexao cnn = new Conexao();
        boolean doLogin = cnn.sendPostLogin(login, senha);
        //List<Usuario> teste = cnn.sendGetRecuperaUsuario(login);
        if(doLogin){

            //lblResultado.setText(String.valueOf(teste.size()));
//            lblResultado.setText("Seja bem vindo!");
            toastShowMsg("Seja bem vindo!!");
//
            nextWindow = new Intent(view.getContext(), activity_home.class);
            startActivity(nextWindow);

        }else
        {
            //nao entrou, aparecer mensagem
//            lblResultado.setText("Vefique a Ortografia, ou tente novamente, a aplicação está alocada no Heroku, isso pode causar incosistências.\n\nDados de tentativa de login:\nUsername: "+login+"\nSenha: "+senha);
            toastShowMsg("Vefique a Ortografia, ou tente novamente, a aplicação está alocada no Heroku, isso pode causar incosistências.\n\nDados de tentativa de login:\nUsername: "+login+"\nSenha: "+senha);

        }
        }catch(Exception e){
//            lblResultado.setText(e.toString());
            toastShowMsg(e.toString());
        }

    }

//    public void openCadastroBanco(View v){
//        Intent intent = new Intent(v.getContext(), CadastroUsuarioActivity.class);
//        startActivity(intent);
//    }

    public void openRegisterPage(View v){
        nextWindow = new Intent(v.getContext(), activity_signup.class);
        startActivity(nextWindow);
    }
}
