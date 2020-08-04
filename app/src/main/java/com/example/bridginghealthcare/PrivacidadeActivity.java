package com.example.bridginghealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.appandroid.R;

public class PrivacidadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacidade);
        Window w = getWindow();
        w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

    }

    public void onBackPressed() {
        Intent intent = new Intent(PrivacidadeActivity.this, SobreActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }
}
