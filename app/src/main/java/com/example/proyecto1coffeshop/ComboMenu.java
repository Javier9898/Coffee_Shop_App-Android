package com.example.proyecto1coffeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ComboMenu extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgBurger, imgAlitas, imgTostadas, imgEmpanada;
    private TextView txtBurger, txtAlitas, txtTostadas, txtEmpanadas, txtTPriceBurger, txtPriceAlitas, txtPriceTostadas, txtPriceEmpanada;
    private Button btnAddBurger, btnAddAlitas, btnAddTostadas, btnAddEmpanada;
    private String textito;
    private Double precioAlitas, precioBurger, precioTostadas, precioEmpanadas;
    private ListView lvDatosCombo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo_menu);

        lvDatosCombo = (ListView)findViewById(R.id.lsdatoscombos);

        //Creo el arraylist.
        ArrayList<DatosCombo> listaCombo = new ArrayList<DatosCombo>();


        imgBurger = findViewById(R.id.imgBurger);
        imgAlitas = findViewById(R.id.imgAlitas);
        imgTostadas = findViewById(R.id.imgTostadas);
        imgEmpanada = findViewById(R.id.imgEmpanada);

        txtBurger = findViewById(R.id.txtBurger);
        txtTostadas = findViewById(R.id.txtTostadas);
        txtAlitas = findViewById(R.id.txtAlitas);
        txtEmpanadas = findViewById(R.id.txtEmpanada);
        txtPriceAlitas = findViewById(R.id.txtPriceAlitas);
        txtPriceEmpanada = findViewById(R.id.txtPriceEmpanada);
        txtPriceTostadas = findViewById(R.id.txtPriceTostadas);
        txtTPriceBurger = findViewById(R.id.txtTPriceBurger);

        btnAddBurger = findViewById(R.id.btnAddBurger);
        btnAddEmpanada = findViewById(R.id.btnAddEmpanada);
        btnAddAlitas = findViewById(R.id.btnAddAlitas);
        btnAddTostadas = findViewById(R.id.btnAddTostadas);

        btnAddBurger.setOnClickListener(this);
        btnAddEmpanada.setOnClickListener(this);
        btnAddAlitas.setOnClickListener(this);
        btnAddTostadas.setOnClickListener(this);

        //Parseo los precios

        precioAlitas = Double.parseDouble((txtPriceAlitas.getText().toString()));
        precioBurger = Double.parseDouble((txtTPriceBurger.getText().toString()));
        precioEmpanadas = Double.parseDouble((txtPriceEmpanada.getText().toString()));
        precioTostadas = Double.parseDouble((txtPriceTostadas.getText().toString()));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddBurger:

                Toast.makeText(this, "Se añadio " + txtBurger.getText().toString()+ precioBurger, Toast.LENGTH_SHORT).show();
             //   openComboMenu();
                break;

            case R.id.btnAddAlitas:
                Toast.makeText(this, "Se añadio " + txtAlitas.getText().toString() + precioAlitas, Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnAddTostadas:
                Toast.makeText(this, "Se añadio " + txtTostadas.getText().toString()+ precioTostadas, Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnAddEmpanada:
                Toast.makeText(this, "Se añadio " + txtEmpanadas.getText().toString() + precioEmpanadas, Toast.LENGTH_SHORT).show();
        }
    }

    public void openComboMenu(){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }


}