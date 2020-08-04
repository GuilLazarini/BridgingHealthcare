package com.example.bridginghealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.appandroid.R;

public class SobreActivity extends AppCompatActivity {

    private Button btnOpensource;
    private Button btnPrivacidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window w = getWindow();
        w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        btnOpensource = findViewById(R.id.btnOpen);
        btnOpensource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SobreActivity.this, OpenSourceActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        btnPrivacidade = findViewById(R.id.btnPrivacidade);
        btnPrivacidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SobreActivity.this, PrivacidadeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SobreActivity.this, MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }





}