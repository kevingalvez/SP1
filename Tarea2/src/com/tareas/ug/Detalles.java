package com.tareas.ug;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
//import android.view.View;

public class Detalles extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalles);
		
		
		String[] nombre = getResources().getStringArray(R.array.Listado);
		String[] direccion = getResources().getStringArray(R.array.Direccion);
		String[] telefono = getResources().getStringArray(R.array.Telefonos);
		String[] horarios = getResources().getStringArray(R.array.Horarios);
		String[] website = getResources().getStringArray(R.array.Website);
		String[] email = getResources().getStringArray(R.array.Correos);
		
		//int id =  Integer.parseInt(getIntent().getStringExtra("ID").toString());
		Bundle extras = getIntent().getExtras(); 
		if (extras != null)
		{
			Log.d("DEBUG", getIntent().getIntExtra("ID", -1) + "");
			int id = getIntent().getIntExtra("ID", -1);
			
			TextView txt_nombre = (TextView)findViewById(R.id.nombre);
			TextView txt_direcion = (TextView)findViewById(R.id.direccion);
			TextView txt_telefono = (TextView)findViewById(R.id.telefono);
			TextView txt_horarios = (TextView)findViewById(R.id.horarios);
			TextView txt_website = (TextView)findViewById(R.id.website);
			TextView txt_correos = (TextView)findViewById(R.id.email);
			
			
			txt_nombre.setText(nombre[id]);
			txt_direcion.setText(direccion[id]);
			txt_telefono.setText(telefono[id]);
			txt_horarios.setText(horarios[id]);
			txt_website.setText(website[id]);
			Linkify.addLinks(txt_website, Linkify.ALL);
			txt_correos.setText(email[id]);
			Linkify.addLinks(txt_correos, Linkify.ALL);
			
			Button call = (Button)findViewById(R.id.llamar);
			ButtonListener listener = new ButtonListener();
			call.setOnClickListener(listener);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalles, menu);
		return true;
	}
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()){
		case R.id.action_options:
			
				String[] nombre = getResources().getStringArray(R.array.Listado);
				String[] direccion = getResources().getStringArray(R.array.Direccion);
				String[] telefono = getResources().getStringArray(R.array.Telefonos);
				String[] horarios = getResources().getStringArray(R.array.Horarios);
				String[] website = getResources().getStringArray(R.array.Website);
				String[] email = getResources().getStringArray(R.array.Correos);
				int id = getIntent().getIntExtra("ID", -1);
				
				String msg= nombre[id] + " " + direccion[id] + " " + telefono[id] + " " + horarios[id] + " " + website[id] + " " + email[id];
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_SEND);
				intent.putExtra(Intent.EXTRA_TEXT, msg);
				intent.setType("text/plain");
				startActivity(Intent.createChooser(intent, "Compatir"));
				return true;
			default:
					return super.onOptionsItemSelected(item);
		}
	}



	public class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		    try {
		        int id = getIntent().getIntExtra("ID", -1);
		        String[] telefono = getResources().getStringArray(R.array.Telefonos);
		        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono[id]));
		        startActivity(intent);
		    } catch (ActivityNotFoundException activityException) {
		        Log.e("dialing-example", "Call failed", activityException);
		    }
		}
		
	}
}
