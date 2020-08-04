package com.example.bridginghealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.appandroid.R;

public class OpenSourceActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_source);
        Window w = getWindow();
        w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OpenSourceActivity.this, SobreActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }
}
