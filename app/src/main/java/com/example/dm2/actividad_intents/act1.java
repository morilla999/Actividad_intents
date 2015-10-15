package com.example.dm2.actividad_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class act1 extends AppCompatActivity {

    private EditText nombre, apellido;
    private TextView label_resul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);

        nombre = (EditText)findViewById(R.id.lab_nombre);
        apellido = (EditText)findViewById(R.id.apellido);
        label_resul = (TextView)findViewById(R.id.resul);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act1, menu);
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

    public void validar(View v){
        Intent intent = new Intent(act1.this, act1_2.class);
        intent.putExtra("usuario", nombre.getText() + " " + apellido.getText());

        //esperamos que la otra actividad nos mande una respuesta
        startActivityForResult(intent, 1234);
    }

    protected void onActivityResult (int requestCode,int resultCode, Intent data) {

        //si recibimos uns respuesta correcta con el codigo indicado mostramos lo que recibimos
        if (requestCode==1234 && resultCode==RESULT_OK){
            label_resul.setText(data.getExtras().getString("resultado"));
        }
    }
}
