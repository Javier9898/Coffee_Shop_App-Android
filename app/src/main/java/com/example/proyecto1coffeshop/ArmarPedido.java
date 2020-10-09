package com.example.proyecto1coffeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArmarPedido extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgCafe, imgGalletas, imgPan, imgCupcake;
    private TextView txtCafe, txtGalletas, txtPan, txtCupcakes, txtPriceCafe, txtPriceGalletas,
            txtPricePan, txtPriceCupcake, txtTotal;
    private Button btnAddCafe, btnAddGalletas, btnAddPan, btnAddCupcake, btnVolver, btnConfirmar1;
    private Double precioCafe, precioGalletas, precioPan, precioCupcake;
    private Double totalArmar = 0.0;
    private ListView lvDatosPedido;
    private int cantCafe, cantGalletas, cantPan, cantCupcake;
    DecimalFormat df = new DecimalFormat("#.00");

    private List<String> listaPedido = new ArrayList<>();
    private ArrayAdapter<String> adaptadorPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armar_pedido);

        lvDatosPedido = (ListView)findViewById(R.id.lvCombos);

        imgCafe = findViewById(R.id.imgCafe);
        imgGalletas = findViewById(R.id.imgGalletas);
        imgPan = findViewById(R.id.imgPan);
        imgCupcake= findViewById(R.id.imgCupcake);

        txtCafe = findViewById(R.id.txtCafe);
        txtPan = findViewById(R.id.txtPan);
        txtGalletas = findViewById(R.id.txtGalletas);
        txtCupcakes = findViewById(R.id.txtCupcakes);
        txtPriceGalletas = findViewById(R.id.txtPriceGalletas);
        txtPriceCupcake = findViewById(R.id.txtPriceCupcake);
        txtPricePan = findViewById(R.id.txtPricePan);
        txtPriceCafe = findViewById(R.id.txtPriceCafe);
        txtTotal = findViewById(R.id.txtTotal);

        btnAddCafe = findViewById(R.id.btnAddCafe);
        btnAddCupcake = findViewById(R.id.btnAddCupcake);
        btnAddGalletas = findViewById(R.id.btnAddGalletas);
        btnAddPan = findViewById(R.id.btnAddPan);
        btnVolver = findViewById(R.id.btnVolver);
        btnConfirmar1 = findViewById(R.id.btnConfirmar1);

        btnAddCafe.setOnClickListener(this);
        btnAddCupcake.setOnClickListener(this);
        btnAddGalletas.setOnClickListener(this);
        btnAddPan.setOnClickListener(this);
        btnVolver.setOnClickListener(this);
        btnConfirmar1.setOnClickListener(this);

        //Parseo los precios

        precioCafe = Double.parseDouble((txtPriceCafe.getText().toString()));
        precioGalletas = Double.parseDouble((txtPriceGalletas.getText().toString()));
        precioCupcake = Double.parseDouble((txtPriceCupcake.getText().toString()));
        precioPan = Double.parseDouble((txtPricePan.getText().toString()));
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnAddCafe:

                //Contabilizar el total a pagar
                totalArmar= totalArmar + precioCafe;
                cantCafe++;

                //Toast de notificacion que se agrego
                Toast.makeText(this, "Se añadio " + txtCafe.getText().toString(), Toast.LENGTH_SHORT).show();
                String item = ItemLista(txtCafe.getText().toString(), precioCafe, cantCafe);

                //Agrego al Array y creo el adaptador
                listaPedido.add(item);
                adaptadorPedido = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaPedido);
                lvDatosPedido.setAdapter(adaptadorPedido);

                txtTotal.setText("Total: "+ df.format(totalArmar)+"$");
                break;

            case R.id.btnAddGalletas:
                totalArmar= totalArmar + precioGalletas;
                cantGalletas++;

                Toast.makeText(this, "Se añadio " + txtGalletas.getText().toString(), Toast.LENGTH_SHORT).show();
                String item2 = ItemLista(txtGalletas.getText().toString(), precioGalletas, cantGalletas);

                //Agrego al Array y creo el adaptador
                listaPedido.add(item2);
                adaptadorPedido = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaPedido);
                lvDatosPedido.setAdapter(adaptadorPedido);
                txtTotal.setText("Total: "+ df.format(totalArmar)+"$");

                break;

            case R.id.btnAddPan:
                totalArmar= totalArmar + precioPan;
                cantPan++;

                Toast.makeText(this, "Se añadio " + txtPan.getText().toString(), Toast.LENGTH_SHORT).show();
                String item3 = ItemLista(txtPan.getText().toString(), precioPan, cantPan);

                //Agrego al Array y creo el adaptador
                listaPedido.add(item3);
                adaptadorPedido = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaPedido);
                lvDatosPedido.setAdapter(adaptadorPedido);
                txtTotal.setText("Total: "+ df.format(totalArmar)+"$");

                break;

            case R.id.btnAddCupcake:
                totalArmar= totalArmar + precioCupcake;
                cantCupcake++;

                Toast.makeText(this, "Se añadio " + txtCupcakes.getText().toString(), Toast.LENGTH_SHORT).show();
                String item4 = ItemLista(txtCupcakes.getText().toString(), precioCupcake, cantCupcake);

                //Agrego al Array y creo el adaptador
                listaPedido.add(item4);
                adaptadorPedido = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaPedido);
                lvDatosPedido.setAdapter(adaptadorPedido);
                txtTotal.setText("Total: "+ df.format(totalArmar)+"$");
                break;

            case R.id.btnVolver:
                finish();
                break;

            case R.id.btnConfirmar1:
                openConfirmado();
                break;
        }
    }

    public void openConfirmado(){
        Intent intent = new Intent(this, Confirmado.class);
        startActivity(intent);
    }

    public String ItemLista(String platillo, Double precio, int cantidad){
        String resultado = platillo+"  " +"  " + precio.toString()+"$ " + " ("+cantidad +")";
        return resultado;
    }
 }