package com.example.bridginghealthcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appandroid.R;
import com.example.bridginghealthcare.controller.DatabaseHelper;
import com.example.bridginghealthcare.controller.UsuarioDAO;

public class CadastroActivity extends AppCompatActivity {

    private Button btnCriarConta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro);
        }

        btnCriarConta = findViewById(R.id.btnCriarConta);
        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nome = findViewById(R.id.txtNomeCadastro);
                EditText sobrenome = findViewById(R.id.txtSobreNomeCadastro);
                EditText email = findViewById(R.id.txtEmailCadastro);
                EditText datanascimento = findViewById(R.id.txtDataNascCadastro);
                EditText senha = findViewById(R.id.txtSenhaCadastro);
                EditText confsenha = findViewById(R.id.txtConfSenhaCadastro);

                if (senha.getText().toString().equals((confsenha.getText().toString()))) {
                    final ContentValues obj = new ContentValues();

                    obj.put("nome", nome.getText().toString());
                    obj.put("sobrenome", sobrenome.getText().toString());
                    obj.put("email", email.getText().toString());
                    obj.put("datanascimento", datanascimento.getText().toString());
                    obj.put("senha",senha.getText().toString());





                    AlertDialog.Builder dlg = new AlertDialog.Builder(v.getContext());
                    dlg.setTitle("Bridging Healthcare");
                    dlg.setCancelable(false);
                    dlg.setMessage("Finalizar o cadastro?");
                    dlg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            DatabaseHelper dh = new DatabaseHelper(getApplicationContext());
                            long id = new UsuarioDAO(dh).inserir(obj);

                            Log.e("ID", ""+id);
                            if (id > 0) {

                                Intent it = new Intent(
                                        getApplicationContext(),
                                        MainActivity.class
                                );
                                criarNotificacao(
                                        "Bridging Healthcare",
                                        "Nova conta foi criada."
                                );

                                Toast.makeText(getApplicationContext(),
                                        "Conta criada com sucesso",
                                        Toast.LENGTH_LONG).show();

                                startActivity(it);
                            }else{
                                Toast.makeText(getApplicationContext(),
                                        "Ocorreu um erro na criação da conta.",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                    dlg.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dlg.show();
                } else{
                    Toast.makeText(getApplicationContext(), "As senhas digitadas são diferentes.", Toast.LENGTH_LONG).show();


            }
        }
        });
    }


    private void criarNotificacao(String titulo, String texto){

        // 01. Definir as propriedades da Notificação
        final int NOTIFICATION_ID = 123;
        final String CHANNEL_ID = "Notificação";

        // 02. Instanciar o gerenciador de notificações
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) this.getSystemService(android.content.Context.NOTIFICATION_SERVICE);


        // 03. Definir um Canal de Notificação para API >= 28
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = android.app.NotificationManager.IMPORTANCE_HIGH;
            android.app.NotificationChannel canal = new android.app.NotificationChannel(CHANNEL_ID, "canal", importance);
            canal.setDescription("Canal de Notificação");
            canal.enableLights(true);
            canal.setLightColor(android.graphics.Color.RED);
            canal.enableVibration(true);
            canal.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            canal.setShowBadge(true);
            notificationManager.createNotificationChannel(canal);
        }

        // 04. Especificar o ícone, o título e a mensagem da notificação
        androidx.core.app.NotificationCompat.Builder builder = new androidx.core.app.NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.logo02)
                .setContentTitle(titulo)
                .setContentText(texto);

        // 05. Definir qual Atividade será chamada quando o usuário clicar na notificação
        androidx.core.app.TaskStackBuilder stackBuilder = androidx.core.app.TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(new Intent(this, MainActivity.class));
        android.app.PendingIntent it = stackBuilder.getPendingIntent(0, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(it);

        // 06. Exibir a notificação
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
