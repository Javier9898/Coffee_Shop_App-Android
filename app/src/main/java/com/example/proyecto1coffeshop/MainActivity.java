package com.example.proyecto1coffeshop;

// Pantalla de Login
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
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
                    if( (!user.equals("Javier")) || (!password.equals("asd123")) ){
                        Context context = getApplicationContext();
                        CharSequence text = "Autenticación incorrecta";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }else{
                        openActivity3();
                    }

                }
            });

            SpannableString spannableString=new SpannableString("Registrarse Aquí");
            ClickableSpan span= new ClickableSpan() {
                @Override
                public void onClick(@NonNull View widget) {
                    openActivity2();
                }

            };
            spannableString.setSpan(span, 0, 16, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
            spannableString.setSpan(new ForegroundColorSpan(Color.rgb(79,66,66)), 0, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv1.setText(spannableString);
            tv1.setMovementMethod(LinkMovementMethod.getInstance());
        }

        public void openActivity2(){
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);
        }

        public void openActivity3(){
            Intent intent = new Intent(this, Activity3.class);
            startActivity(intent);
        }



}