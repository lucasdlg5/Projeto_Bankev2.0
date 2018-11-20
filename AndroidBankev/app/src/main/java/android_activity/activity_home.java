package android_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import sjc.fatec.sp.br.bankev20.R;

public class activity_home extends AppCompatActivity {


    Intent nextWindow;
    final Button button = findViewById(R.id.button2);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nextWindow = new Intent(v.getContext(), activity_administracao.class);
                startActivity(nextWindow);
            }
        });
    }
}
