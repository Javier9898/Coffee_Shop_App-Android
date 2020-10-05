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
                ck1.toggle();
                openAlGusto();
            }


        });
        ck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ck2.toggle();
                openComboMenu();
            }
        });

    }
    public void openComboMenu(){
        Intent intent = new Intent(this, ComboMenu.class);
        startActivity(intent);
    }

    public void openAlGusto(){
        Intent intent = new Intent(this, ArmarPedido.class);
        startActivity(intent);
    }

}
