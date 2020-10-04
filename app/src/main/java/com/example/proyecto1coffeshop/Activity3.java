package com.example.proyecto1coffeshop;

//Pantalla en la cual se mostraran dos radiobuttons los cuales permitiran elegir entre
//combo o selección de un item individual
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;


public class Activity3 extends AppCompatActivity {
    CheckBox ck1,ck2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        ck1=(CheckBox)findViewById(R.id.ck1);
        ck2=(CheckBox)findViewById(R.id.ck2);

        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //creo que este es el codigo para hacer que al darle click al checkbox,
                //este haga algo.
                //Aquí se pone los eventos que hará el ck1.(ir a una pantalla diferente)
                openComboMenu();
            }
        });
        ck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Aquí se pone los eventos que hará el ck2.(ir a una pantalla diferente)
            }
        });

    }
    public void openComboMenu(){
        Intent intent = new Intent(this, ComboMenu.class);
        startActivity(intent);
    }

}
