package com.example.bridginghealthcare;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appandroid.R;
import com.example.bridginghealthcare.controller.DatabaseHelper;
import com.example.bridginghealthcare.controller.UsuarioDAO;


public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextView lblCadastro;
    private TextView lblSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                openActivityMenu();
            }

            public void openActivityMenu(){
                //btnLogin.setEnabled(false);

                EditText edt1 = findViewById(R.id.txtUser);
                EditText edt2 = findViewById(R.id.txtSenha);

                ContentValues obj = new ContentValues();
                obj.put("email", edt1.getText().toString());
                obj.put("senha", edt2.getText().toString());

                DatabaseHelper dh = new DatabaseHelper(getApplicationContext());
                boolean resultado = new UsuarioDAO(dh).login(obj);

                if (resultado == true) {
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Usuário ou senha inválida.",Toast.LENGTH_LONG).show();
                }
            }
        });

        lblCadastro = findViewById(R.id.lblCadastrar);
        lblCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCadastro();
            }

            public void openActivityCadastro(){
              //  lblCadastro.setEnabled(false);
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }

        });

        lblSenha = findViewById(R.id.lblSenha);
        lblSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EsqueciSenhaActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

    }


}


