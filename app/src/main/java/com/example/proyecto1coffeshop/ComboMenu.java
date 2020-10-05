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

public class ComboMenu extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgBurger, imgAlitas, imgTostadas, imgEmpanada;
    private TextView txtBurger, txtAlitas, txtTostadas, txtEmpanadas, txtTPriceBurger, txtPriceAlitas,
            txtPriceTostadas, txtPriceEmpanada, txtTotalPagar;
    private Button btnAddBurger, btnAddAlitas, btnAddTostadas, btnAddEmpanada, btnVolver, btnConfirmar;
    private Double precioAlitas, precioBurger, precioTostadas, precioEmpanadas;
    private Double totalCombo = 0.0;
    private ListView lvDatosCombo;
    private int cantBurger, cantTostadas, cantAlitas, cantEmpanada;
    DecimalFormat df = new DecimalFormat("#.00");

    private List<String> listaCombo = new ArrayList<>();
    private ArrayAdapter<String> adaptadorCombo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo_menu);

        lvDatosCombo = (ListView)findViewById(R.id.lvCombos);

        imgBurger = findViewById(R.id.imgBurger);
        imgAlitas = findViewById(R.id.imgAlitas);
        imgTostadas = findViewById(R.id.imgTostadas);
        imgEmpanada = findViewById(R.id.imgEmpanadas);

        txtBurger = findViewById(R.id.txtBurger);
        txtTostadas = findViewById(R.id.txtTostadas);
        txtAlitas = findViewById(R.id.txtAlitas);
        txtEmpanadas = findViewById(R.id.txtEmpanadas);
        txtPriceAlitas = findViewById(R.id.txtPriceAlitas);
        txtPriceEmpanada = findViewById(R.id.txtPriceEmpanadas);
        txtPriceTostadas = findViewById(R.id.txtPriceTostadas);
        txtTPriceBurger = findViewById(R.id.txtPriceBurger);
        txtTotalPagar = findViewById(R.id.txtTotalPagar);

        btnAddBurger = findViewById(R.id.btnAddBurger);
        btnAddEmpanada = findViewById(R.id.btnAddEmpanadas);
        btnAddAlitas = findViewById(R.id.btnAddAlitas);
        btnAddTostadas = findViewById(R.id.btnAddTostadas);
        btnVolver = findViewById(R.id.btnVolver);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnAddBurger.setOnClickListener(this);
        btnAddEmpanada.setOnClickListener(this);
        btnAddAlitas.setOnClickListener(this);
        btnAddTostadas.setOnClickListener(this);
        btnVolver.setOnClickListener(this);
        btnConfirmar.setOnClickListener(this);

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

                //Contabilizar el total a pagar
               totalCombo= totalCombo + precioBurger;
               cantBurger++;

                //Toast de notificacion que se agrego
                Toast.makeText(this, "Se añadio " + txtBurger.getText().toString(), Toast.LENGTH_SHORT).show();
                String item = ItemLista(txtBurger.getText().toString(), precioBurger, cantBurger);

                //Agrego al Array y creo el adaptador
                listaCombo.add(item);
                adaptadorCombo = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaCombo);
                lvDatosCombo.setAdapter(adaptadorCombo);

                txtTotalPagar.setText("Total: "+ df.format(totalCombo)+"$");
                break;

            case R.id.btnAddAlitas:
                totalCombo= totalCombo + precioAlitas;
                cantAlitas++;

                Toast.makeText(this, "Se añadio " + txtAlitas.getText().toString(), Toast.LENGTH_SHORT).show();
                String item2 = ItemLista(txtAlitas.getText().toString(), precioAlitas, cantAlitas);

                //Agrego al Array y creo el adaptador
                listaCombo.add(item2);
                adaptadorCombo = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaCombo);
                lvDatosCombo.setAdapter(adaptadorCombo);
                txtTotalPagar.setText("Total: "+ df.format(totalCombo)+"$");

                break;

            case R.id.btnAddTostadas:
                totalCombo= totalCombo + precioTostadas;
                cantTostadas++;

                Toast.makeText(this, "Se añadio " + txtTostadas.getText().toString(), Toast.LENGTH_SHORT).show();
                String item3 = ItemLista(txtTostadas.getText().toString(), precioTostadas, cantTostadas);

                //Agrego al Array y creo el adaptador
                listaCombo.add(item3);
                adaptadorCombo = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaCombo);
                lvDatosCombo.setAdapter(adaptadorCombo);
                txtTotalPagar.setText("Total: "+ df.format(totalCombo)+"$");

                break;

            case R.id.btnAddEmpanadas:
                totalCombo= totalCombo + precioEmpanadas;
                cantEmpanada++;

                Toast.makeText(this, "Se añadio " + txtEmpanadas.getText().toString(), Toast.LENGTH_SHORT).show();
                String item4 = ItemLista(txtEmpanadas.getText().toString(), precioEmpanadas, cantEmpanada);

                //Agrego al Array y creo el adaptador
                listaCombo.add(item4);
                adaptadorCombo = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaCombo);
                lvDatosCombo.setAdapter(adaptadorCombo);
                txtTotalPagar.setText("Total: "+ df.format(totalCombo)+"$");
                break;

            case R.id.btnVolver:
                finish();
                break;

            case R.id.btnConfirmar:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("Confirmación de pedido");
                builder.setMessage("Su pedido ha sido confirmado con éxito.");
                builder.setPositiveButton("Aceptar", null);

                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }
    }

    public void openComboMenu(){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    public String ItemLista(String platillo, Double precio, int cantidad){
        String resultado = platillo+"  " +"  " + precio.toString()+"$ " + " ("+cantidad +")";
        return resultado;
    }

}