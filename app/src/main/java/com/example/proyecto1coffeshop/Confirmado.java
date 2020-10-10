package com.example.proyecto1coffeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Confirmado extends AppCompatActivity {
    TextView tvcodigo, tvhora;
    Button btnVolverAlmenu;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmado);
        tvcodigo=(TextView) findViewById(R.id.tvcodigo);
        tvhora=(TextView) findViewById(R.id.tvhora);
        btnVolverAlmenu=(Button) findViewById(R.id.btnVolverAlmenu);
        ratingBar = findViewById(R.id.ratingBar);

        Random rand = new Random();
        int upperbound = 999999;
        int codigo = rand.nextInt(upperbound);
        tvcodigo.setText("Código: "+ codigo);

        //Calendar calendar = Calendar.getInstance();
        //SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("hh:mm");
        //String dateTime = SimpleDateFormat.format(calendar.getTime());
        Date dateTime = Calendar.getInstance().getTime();
        String formattedtime = DateFormat.getDateTimeInstance().format(dateTime);
        tvhora.setText("Hora de pedido: "+ formattedtime);

        btnVolverAlmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Confirmado.this, "Gracias por calificar la APP ", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void openActivity3(){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
}
