package com.example.proyecto1coffeshop;

//Pantalla de registro
//Idea: Utilizar unlistArray en el que se guarden los valores. En la pantalla principal,
// recorrer el array y verificar si se encuentran ambos
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Activity2 extends AppCompatActivity {
    Button btnRegistro;
    EditText etuser2, etpass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        btnRegistro =findViewById(R.id.btnRegistro);
        etuser2 = findViewById(R.id.etuser2);
        etpass2 = findViewById(R.id.etpass2);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
    }
    public void openMainActivity(){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}
