package com.example.dm2.actividad_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class act3 extends AppCompatActivity {

    private TextView num1, num2, num_correctas, num_incorrectas;
    private EditText resul;
    private int cont_correctas = 0, cont_incorrectas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);

        num1 = (TextView)findViewById(R.id.num1);
        num2 = (TextView)findViewById(R.id.num2);

        resul = (EditText)findViewById(R.id.resul);

        num_correctas = (TextView)findViewById(R.id.num_correctas);
        num_incorrectas = (TextView)findViewById(R.id.num_incorrectas);

        num_correctas.setText(String.valueOf(cont_correctas));
        num_incorrectas.setText(String.valueOf(cont_incorrectas));

        generar_numero(num1);
        generar_numero(num2);
    }

    public void generar_numero(TextView num){
        //generamos un numero aleatorio y los mostramo en las caja de texto pasada como parámetro
        int ale1 = (int)(Math.random()*9);

        num.setText(String.valueOf(ale1));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act3, menu);
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

    public void calcular(View v){
        Intent intent = new Intent(act3.this, act3_2.class);
        intent.putExtra("num1", Integer.parseInt(num1.getText().toString()));
        intent.putExtra("num2", Integer.parseInt(num2.getText().toString()));
        intent.putExtra("resul", Integer.parseInt(resul.getText().toString()));

        //esperamos que la otra actividad nos mande una respuesta
        startActivityForResult(intent, 1234);
    }

    protected void onActivityResult (int requestCode,int resultCode, Intent data) {

        //si recibimos uns respuesta correcta con el codigo indicado mostramos lo que recibimos
        if (requestCode==1234 && resultCode==RESULT_OK){
            boolean r = data.getExtras().getBoolean("resultado");

            if(r){
                cont_correctas++;
            }else{
                cont_incorrectas++;
            }

            num_correctas.setText(String.valueOf(cont_correctas));
            num_incorrectas.setText(String.valueOf(cont_incorrectas));

            //volvemos a generar dos numeros aleatorios
            generar_numero(num1);
            generar_numero(num2);
        }
    }
}
