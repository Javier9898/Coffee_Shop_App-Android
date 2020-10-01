package com.example.proyecto1coffeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etuser, etpass;
    Button btnInicio;
    ImageView logo;
    TextView tv1;

    @Override protected void onCreate(Bundle savedInstanceState)
    { super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    etuser = findViewById(R.id.etuser);
    etpass = findViewById(R.id.etpass);
    logo = findViewById(R.id.logo);
    btnInicio =findViewById(R.id.btnInicio);
    tv1 = findViewById(R.id.tv1);

    btnInicio.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String user = etuser.getText().toString();
            String password = etpass.getText().toString();
            if( (!user.equals("Javier")) || (!password.equals("asdf")) ){
                Context context = getApplicationContext();
                CharSequence text = "Autenticación incorrecta";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        } }); } }