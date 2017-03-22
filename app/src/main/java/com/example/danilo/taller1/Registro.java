package com.example.danilo.taller1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Registro extends AppCompatActivity {

    private TextView txtMensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtMensaje = (TextView)findViewById(R.id.txtMensaje);

        Bundle bundle = this.getIntent().getExtras();

        txtMensaje.setText("Hola"+ bundle.getString("Primer_Nombre") + " "+bundle.getString("Segundo_Nombre")
                +" "+bundle.getString("Primer_Apellido")+" "+bundle.getString("Segundo_Apellido")
                +"Tu edad es "+bundle.getString("Edad")+" años y tu sexo es "+bundle.getString("Sexo"));


    }
}
