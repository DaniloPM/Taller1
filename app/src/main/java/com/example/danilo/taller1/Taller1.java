package com.example.danilo.taller1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Taller1 extends AppCompatActivity {

private EditText txtPNombre;
    private EditText txtSNombre;
    private EditText txtPApellido;
    private EditText txtSApellido;
    private EditText txtEdad;
    private EditText txtSexo;
    private Button btnMostrar;
    private Button btnBorrar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taller1);

        //Obtenemos una referencia a los controles de interfaz
        txtPNombre = (EditText) findViewById(R.id.txtPNombre);
        txtSNombre = (EditText) findViewById(R.id.txtSNombre);
        txtPApellido = (EditText) findViewById(R.id.txtPApellido);
        txtSApellido = (EditText) findViewById(R.id.txtSApellido);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        txtSexo = (EditText) findViewById(R.id.txtSexo);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);

        //validacion para que edad solo permita numeros
        txtEdad.setInputType(InputType.TYPE_CLASS_PHONE);

        KeyListener keyListener = DigitsKeyListener.getInstance("1234567890");
        txtEdad.setKeyListener(keyListener);

        //Implementamos el evento click del botón Mostrar
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtSexo.length() == 0 ||txtPNombre.length() == 0 ||txtSNombre.length() == 0 || txtPApellido.length() == 0 ||
                        txtSApellido.length() == 0 ||txtEdad.length() == 0){
                    Toast.makeText(Taller1.this, "hay campos vacios ",
                            Toast.LENGTH_LONG).show();
                }else{

                    //Creamos el Intent
                    Intent intent = new Intent(Taller1.this, Registro.class);

                    //Creamos la información a pasar entre actividades
                    Bundle b = new Bundle();
                    b.putString("Primer_Nombre", txtPNombre.getText().toString());
                    b.putString("Segundo_Nombre", txtSNombre.getText().toString());
                    b.putString("Primer_Apellido", txtPApellido.getText().toString());
                    b.putString("Segundo_Apellido", txtSApellido.getText().toString());
                    b.putString("Edad", txtEdad.getText().toString());
                    b.putString("Sexo", txtSexo.getText().toString());

                    //Añadimos la información al intent
                    intent.putExtras(b);




                    startActivity(intent);
                }
            }
        });

        //evento boton borrar
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                txtEdad.setText(" ");
                txtSexo.setText(" ");
                txtSNombre.setText(" ");
                txtPNombre.setText(" ");
                txtPNombre.requestFocus();
                txtPApellido.setText(" ");
                txtSApellido.setText(" ");
            }
        });

    }
}


