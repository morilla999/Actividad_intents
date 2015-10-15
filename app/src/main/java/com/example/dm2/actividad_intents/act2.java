package com.example.dm2.actividad_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class act2 extends AppCompatActivity {

    private EditText usuario, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        usuario = (EditText)findViewById(R.id.usu);
        password = (EditText)findViewById(R.id.pass);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act2, menu);
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

        if(!usuario.getText().toString().equals("") && !password.getText().toString().equals("")){
            Intent intent = new Intent(act2.this, act2_2.class);

            intent.putExtra("usu",usuario.getText().toString());
            intent.putExtra("pass",Integer.parseInt(password.getText().toString()));

            //en este caso no esperamos respuesta
            startActivity(intent);
        }else{
            Toast toast = Toast.makeText(this.getApplicationContext(), "Debe rellenar los dos campos", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
