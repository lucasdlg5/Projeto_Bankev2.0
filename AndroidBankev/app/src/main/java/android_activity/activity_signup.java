package android_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import sjc.fatec.sp.br.bankev20.R;

public class activity_signup extends AppCompatActivity {

    Intent nextWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void openLoginPage(View v){
        nextWindow = new Intent(v.getContext(), MainActivity.class);
        startActivity(nextWindow);
    }
}
