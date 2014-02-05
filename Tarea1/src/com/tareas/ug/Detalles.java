package com.tareas.ug;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class Detalles extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalles);
		
		
		String[] arreglo = getResources().getStringArray(R.array.Listado);
		
		//int id =  Integer.parseInt(getIntent().getStringExtra("ID").toString());
		Bundle extras = getIntent().getExtras(); 
		if (extras != null)
		{
			Log.d("DEBUG", getIntent().getIntExtra("ID", -1) + "");
			int id = getIntent().getIntExtra("ID", -1);
			String nombre = arreglo[id];
			
			TextView txt = (TextView)findViewById(R.id.nombre);
			txt.setText(nombre);

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalles, menu);
		return true;
	}

}
