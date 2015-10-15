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
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class act5 extends AppCompatActivity {

	private EditText nombre;
	private RadioButton masculino, femenino;
	private CheckBox daga, maza, baston, ballesta, espada, hacha, alabarda, martillo, arco;
	private Switch avanzado;
	private ToggleButton alineamiento;
	private SeekBar fuerza, destreza, constitucion, mente;
	private TextView val_fuerza, val_destreza, val_constitucion, val_mente;
    private Spinner razas, clases;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act5);
		
		nombre = (EditText)findViewById(R.id.nombre);
		
		masculino = (RadioButton)findViewById(R.id.masculino);
        femenino = (RadioButton)findViewById(R.id.femenino);
		
		daga = (CheckBox)findViewById(R.id.daga);
        maza = (CheckBox)findViewById(R.id.maza);
        baston = (CheckBox)findViewById(R.id.baston);
        ballesta = (CheckBox)findViewById(R.id.ballesta);
		espada = (CheckBox)findViewById(R.id.espada);
        hacha = (CheckBox)findViewById(R.id.hacha);
        alabarda = (CheckBox)findViewById(R.id.alabarda);
        martillo = (CheckBox)findViewById(R.id.martillo);
		arco = (CheckBox)findViewById(R.id.arco);
        
		avanzado = (Switch)findViewById(R.id.avanzado);
		alineamiento = (ToggleButton) findViewById(R.id.alineamiento);
		
		fuerza = (SeekBar)findViewById(R.id.fuerza);
		destreza = (SeekBar)findViewById(R.id.destreza);
		constitucion = (SeekBar)findViewById(R.id.constitucion);
		mente = (SeekBar)findViewById(R.id.mente);
		
        val_fuerza = (TextView)findViewById(R.id.val_fuerza);
		val_destreza = (TextView)findViewById(R.id.val_destreza);
		val_constitucion = (TextView)findViewById(R.id.val_constitucion);
		val_mente = (TextView)findViewById(R.id.val_mente);

        razas = (Spinner)findViewById(R.id.raza);
        ArrayAdapter adaptador_razas = ArrayAdapter.createFromResource(this, R.array.razas, R.layout.support_simple_spinner_dropdown_item);
        razas.setAdapter(adaptador_razas);

        clases = (Spinner)findViewById(R.id.clase);
        ArrayAdapter adaptador_clases = ArrayAdapter.createFromResource(this, R.array.clases, R.layout.support_simple_spinner_dropdown_item);
        clases.setAdapter(adaptador_clases);
		
		fuerza.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                val_fuerza.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
		
		destreza.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                val_destreza.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
		
		constitucion.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                val_constitucion.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
		
		mente.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                val_mente.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act5, menu);
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
            errores += "Debe escribir un nombre.\n";
        }
		
		if(!masculino.isChecked() && !femenino.isChecked()){
            errores += "Debe especificar un género.\n";
        }
		
		ArrayList<String> especializaciones = new ArrayList<String>();

        if(daga.isChecked()){
            especializaciones.add(daga.getText().toString());
        }
		
		if(maza.isChecked()){
            especializaciones.add(maza.getText().toString());
        }
		
		if(baston.isChecked()){
            especializaciones.add(baston.getText().toString());
        }
		
		if(ballesta.isChecked()){
            especializaciones.add(ballesta.getText().toString());
        }
		
		if(espada.isChecked()){
            especializaciones.add(espada.getText().toString());
        }
		
		if(hacha.isChecked()){
            especializaciones.add(hacha.getText().toString());
        }
		
		if(alabarda.isChecked()){
            especializaciones.add(alabarda.getText().toString());
        }
		
		if(martillo.isChecked()){
            especializaciones.add(martillo.getText().toString());
        }
		
		if(arco.isChecked()){
            especializaciones.add(arco.getText().toString());
        }
		
		if(especializaciones.size() != 4){
			errores += "Debe seleccionar 4 especializaciones.\n";
		}
		
		if((Integer.parseInt(val_fuerza.getText().toString()) + Integer.parseInt(val_destreza.getText().toString()) + Integer.parseInt(val_constitucion.getText().toString()) + Integer.parseInt(val_mente.getText().toString()) != 50)){
			errores += "Los valores de las características deben sumar 50.\n";
		}
		
		if(errores.equals("")){
			Intent intent = new Intent(act5.this, act5_2.class);
			
			intent.putExtra("nombre", nombre.getText().toString());
			
			if(masculino.isChecked()){
                intent.putExtra("genero", masculino.getText().toString());
            }else{
                intent.putExtra("genero", femenino.getText().toString());
            }
			
			intent.putExtra("especializaciones", especializaciones);
			
			if(avanzado.isChecked()){
				intent.putExtra("modo", "Avanzado");
			}else{
				intent.putExtra("modo", "Normal");
			}
			
			if(alineamiento.isChecked()){
				intent.putExtra("alineamiento", "Maligno");
			}else{
				intent.putExtra("alineamiento", "Bueno");
			}
			
			intent.putExtra("raza", razas.getSelectedItem().toString());
			
			intent.putExtra("clase", clases.getSelectedItem().toString());
			
			intent.putExtra("fuerza", val_fuerza.getText().toString());
			intent.putExtra("destreza", val_destreza.getText().toString());
			intent.putExtra("constitucion", val_constitucion.getText().toString());
			intent.putExtra("mente", val_mente.getText().toString());

			startActivity(intent);
		}else{
            Toast toast = Toast.makeText(this.getApplicationContext(), errores, Toast.LENGTH_SHORT);
            toast.show();
        }
	}
}
