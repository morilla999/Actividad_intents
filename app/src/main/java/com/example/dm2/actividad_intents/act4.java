package com.example.dm2.actividad_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class act4 extends AppCompatActivity {

    private EditText nombre, apellidos;
    private RadioButton masculino, femenino;
    private CheckBox musica, lectura, deportes, viajar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act4);

        nombre = (EditText)findViewById(R.id.lab_nombre);
        apellidos = (EditText)findViewById(R.id.apellidos);

        masculino = (RadioButton)findViewById(R.id.masculino);
        femenino = (RadioButton)findViewById(R.id.femenino);

        musica = (CheckBox)findViewById(R.id.musica);
        lectura = (CheckBox)findViewById(R.id.lectura);
        deportes = (CheckBox)findViewById(R.id.deportes);
        viajar = (CheckBox)findViewById(R.id.viajar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void enviar(View v){
        //comprobamos que los valores sean correctos
        String errores = "";

        if(nombre.getText().length() < 1){
            errores += "Debe escribir su nombre.\n";
        }

        if(apellidos.getText().length() < 1){
            errores += "Debe escribir sus apellidos.\n";
        }

        if(!masculino.isChecked() && !femenino.isChecked()){
            errores += "Debe especificar su sexo.";
        }

        if(errores.equals("")){
            Intent intent = new Intent(act4.this, act4_2.class);

            intent.putExtra("nombre", nombre.getText().toString());
            intent.putExtra("apellidos", apellidos.getText().toString());

            if(masculino.isChecked()){
                intent.putExtra("sexo", masculino.getText().toString());
            }else{
                intent.putExtra("sexo", femenino.getText().toString());
            }

            ArrayList<String> aficiones = new ArrayList<String>();

            if(musica.isChecked()){
                aficiones.add(musica.getText().toString());
            }

            if(lectura.isChecked()){
                aficiones.add(lectura.getText().toString());
            }

            if(deportes.isChecked()){
                aficiones.add(deportes.getText().toString());
            }

            if(viajar.isChecked()){
                aficiones.add(viajar.getText().toString());
            }

            intent.putExtra("aficiones" ,aficiones);

            //en este caso no esperamos respuesta
            startActivity(intent);
        }else{
            Toast toast = Toast.makeText(this.getApplicationContext(), errores, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
