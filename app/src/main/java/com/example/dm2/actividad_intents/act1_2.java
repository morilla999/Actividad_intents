package com.example.dm2.actividad_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class act1_2 extends AppCompatActivity {

    private TextView label_usu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1_2);

        label_usu = (TextView)findViewById(R.id.usu);

        //recogemos la variable usuario enviada desde act1
        Bundle extras = getIntent().getExtras();
        label_usu.setText(extras.getString("usuario"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act1_2, menu);
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

    public void respuesta(View v){
        Button opcion = (Button)v;
        String texto_opcion = opcion.getText().toString();

        Intent intent = new Intent(act1_2.this, act1.class);

        switch(texto_opcion){
            case "aceptar":
                intent.putExtra("resultado","Si");
                break;
            case "rechazar":
                intent.putExtra("resultado","No");
                break;
        }
        
        //indicamos que el resultado es correcto y finalizamos
        setResult(RESULT_OK, intent);

        finish();
    }
}
