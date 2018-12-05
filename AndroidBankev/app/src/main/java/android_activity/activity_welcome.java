package android_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android_activity.adapter.welcome_slideAdapter;
import sjc.fatec.sp.br.bankev20.R;


import android.support.v4.view.ViewPager;
import android.view.View;


public class activity_welcome extends AppCompatActivity {



    private ViewPager viewPager;
    private welcome_slideAdapter myadapter;

    Intent nextWindow;

    public void openMainPage(View v){
        nextWindow = new Intent(v.getContext(), MainActivity.class);
        startActivity(nextWindow);
    }

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new welcome_slideAdapter(this);
        viewPager.setAdapter(myadapter);

    }
}
