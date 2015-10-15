package com.example.dm2.actividad_intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class act4_2 extends AppCompatActivity {

    TextView nombre, apellidos, sexo, aficiones;

    ArrayList<String> aficis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act4_2);

        TextView nombre = (TextView)findViewById(R.id.lab_nombre);
        TextView apellidos = (TextView)findViewById(R.id.apellidos);
        TextView sexo = (TextView)findViewById(R.id.sexo);
        TextView aficiones = (TextView)findViewById(R.id.aficiones);

        Bundle extras = getIntent().getExtras();
        nombre.setText(extras.getString("nombre"));
        apellidos.setText(extras.getString("apellidos"));
        sexo.setText(extras.getString("sexo"));

        aficis = extras.getStringArrayList("aficiones");

        String cadena = "";

        for(int i = 0; i < aficis.size(); i++){
            cadena += aficis.get(i) + '\n';
        }

        if(cadena.equals("")){
            aficiones.setText("Otras");
        }else{
            aficiones.setText(cadena);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act4_2, menu);
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
}
