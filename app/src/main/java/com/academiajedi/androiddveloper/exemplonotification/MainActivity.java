package com.academiajedi.androiddveloper.exemplonotification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCriarNotificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCriarNotificacao = (Button) findViewById(R.id.btnCriarNotificacao);
        btnCriarNotificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarNotificacao();
            }
        });
    }

    public void criarNotificacao(){

        PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuider = new NotificationCompat.Builder(this);
        mBuider.setDefaults(Notification.DEFAULT_ALL);
        mBuider.setSmallIcon(R.mipmap.ic_launcher);
        mBuider.setContentTitle("Minha notificação");
        mBuider.setContentText("descrição da minha notificação");
        mBuider.setContentIntent(p);
        mBuider.setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, mBuider.build());

    }
}
