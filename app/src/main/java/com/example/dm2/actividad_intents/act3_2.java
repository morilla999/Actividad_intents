package com.example.dm2.actividad_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class act3_2 extends AppCompatActivity {

    private TextView label_resul;

    private boolean resultado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3_2);

        label_resul = (TextView)findViewById(R.id.label_resul);

        //recibimos los valores y comprobamos si la operacion es correcta
        Bundle extras = getIntent().getExtras();

        int num1 = extras.getInt("num1");
        int num2 = extras.getInt("num2");
        int resul = extras.getInt("resul");

        if((num1+num2) == resul){
            resultado = true;

            label_resul.setText("Resultado correcto");
        }else{
            label_resul.setText("Resultado incorrecto");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act3_2, menu);
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

    public void terminar(View v){
        Intent intent = new Intent(act3_2.this, act3.class);

        intent.putExtra("resultado", resultado);

        setResult(RESULT_OK, intent);

        finish();
    }
}
