package com.example.dm2.actividad_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void iniciar(View v){
        Button boton_pulsado = (Button)v;
        String actividad = boton_pulsado.getText().toString();

        Intent intent;

        switch(actividad){
            case "Actividad 1":
                intent = new Intent(MainActivity.this, act1.class);
                startActivity(intent);
                break;
            case "Actividad 2":
                intent = new Intent(MainActivity.this, act2.class);
                startActivity(intent);
                break;
            case "Actividad 3":
                intent = new Intent(MainActivity.this, act3.class);
                startActivity(intent);
                break;
            case "Actividad 4":
                intent = new Intent(MainActivity.this, act4.class);
                startActivity(intent);
                break;
            case "Actividad 5":
                intent = new Intent(MainActivity.this, act5.class);
                startActivity(intent);
                break;
        }
    }

    public void salir(View v){
        finish();
    }
}
