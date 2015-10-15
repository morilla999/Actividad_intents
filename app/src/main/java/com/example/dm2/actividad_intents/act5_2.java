package com.example.dm2.actividad_intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class act5_2 extends AppCompatActivity {

    TextView nombre, genero, raza, clase, modo, alineamiento, especializaciones, val_fuerza, val_destreza, val_constitucion, val_mente;

    ArrayList<String> especis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act5_2);

        nombre = (TextView)findViewById(R.id.nombre);
        genero = (TextView)findViewById(R.id.genero);
		raza = (TextView)findViewById(R.id.raza);
		clase = (TextView)findViewById(R.id.clase);
		modo = (TextView)findViewById(R.id.modo);
		alineamiento = (TextView)findViewById(R.id.alineamiento);
        especializaciones = (TextView)findViewById(R.id.especializaciones);
		val_fuerza = (TextView)findViewById(R.id.val_fuerza);
        val_destreza = (TextView)findViewById(R.id.val_destreza);
        val_constitucion = (TextView)findViewById(R.id.val_constitucion);
        val_mente = (TextView)findViewById(R.id.val_mente);

        Bundle extras = getIntent().getExtras();
        nombre.setText(extras.getString("nombre"));
        genero.setText(extras.getString("genero"));
		raza.setText(extras.getString("raza"));
        clase.setText(extras.getString("clase"));
		modo.setText(extras.getString("modo"));
        alineamiento.setText(extras.getString("alineamiento"));

        especis = extras.getStringArrayList("especializaciones");

        String cadena = "";

        for(int i = 0; i < especis.size(); i++){
            cadena += especis.get(i) + '\n';
        }
		
        especializaciones.setText(cadena);

        val_fuerza.setText(extras.getString("fuerza"));
        val_destreza.setText(extras.getString("destreza"));
        val_constitucion.setText(extras.getString("constitucion"));
        val_mente.setText(extras.getString("mente"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act5_2, menu);
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
