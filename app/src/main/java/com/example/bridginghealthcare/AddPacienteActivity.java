package com.example.bridginghealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.appandroid.R;

public class AddPacienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_paciente);
        Window w = getWindow();
        w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddPacienteActivity.this, MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }
}
