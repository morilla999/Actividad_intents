package com.example.dm2.actividad_intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class act2_2 extends AppCompatActivity {

    private TextView resul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2_2);

        resul = (TextView)findViewById(R.id.resul);

        //recibimos los datos y los comprobamos
        Bundle extras = getIntent().getExtras();
        String usu = extras.getString("usu").toString();
        int pass = extras.getInt("pass");

        if(!usu.equals("Manuel") || pass != 1234){
            resul.setText("Usuario y/o password incorrectos");
        }else{
            resul.setText("Usuario correcto");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act2_2, menu);
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

    public void volver(View v){
        //cerramos la actividad
        finish();
    }
}
