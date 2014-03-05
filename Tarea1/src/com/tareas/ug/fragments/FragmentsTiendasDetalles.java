package com.tareas.ug.fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.tareas.ug.R;

public class FragmentsTiendasDetalles extends Fragment implements OnClickListener {

	ListView listview;
	TextView txt_nombre;
	TextView txt_direcion;
	TextView txt_telefono;
	TextView txt_horarios;
	TextView txt_website;
	TextView txt_correos;
	Button call;
	Button imagen;
	View view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		view =  inflater.inflate(R.layout.fragment_comments, container, false);
//		listview = (ListView)view.findViewById(R.id.Lista);
		txt_nombre = (TextView)view.findViewById(R.id.nombre);
		txt_direcion = (TextView)view.findViewById(R.id.direccion);
		txt_telefono = (TextView)view.findViewById(R.id.telefono);
		txt_horarios = (TextView)view.findViewById(R.id.horarios);
		txt_website = (TextView)view.findViewById(R.id.website);
		txt_correos = (TextView)view.findViewById(R.id.email);
		call = (Button)view.findViewById(R.id.llamar);
		
		String[] nombre = getResources().getStringArray(R.array.Listado);
		String[] direccion = getResources().getStringArray(R.array.Direccion);
		String[] telefono = getResources().getStringArray(R.array.Telefonos);
		String[] horarios = getResources().getStringArray(R.array.Horarios);
		String[] website = getResources().getStringArray(R.array.Website);
		String[] email = getResources().getStringArray(R.array.Correos);
		
		//int id =  Integer.parseInt(getIntent().getStringExtra("ID").toString());
		Bundle extras = getActivity().getIntent().getExtras(); 
		if (extras != null)
		{
			Log.d("DEBUG", getActivity().getIntent().getIntExtra("ID", -1) + "");
			int id = getActivity().getIntent().getIntExtra("ID", -1);
			
			txt_nombre.setText(nombre[id]);
			txt_direcion.setText(direccion[id]);
			txt_telefono.setText(telefono[id]);
			txt_horarios.setText(horarios[id]);
			txt_website.setText(website[id]);
			Linkify.addLinks(txt_website, Linkify.ALL);
			txt_correos.setText(email[id]);
			Linkify.addLinks(txt_correos, Linkify.ALL);
			
			call.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					// TODO Auto-generated method stub
				    try {
				        int id = getActivity().getIntent().getIntExtra("ID", -1);
				        String[] telefono = getResources().getStringArray(R.array.Telefonos);
				        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono[id]));
				        startActivity(intent);
				    } catch (ActivityNotFoundException activityException) {
				        Log.e("dialing-example", "Call failed", activityException);
				    }
				}
			});
					
			imagen.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
			        
			        
					
				}
			});
		}
		return view;
	}
	
	public void instanciar()
	{
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
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
				int id = getActivity().getIntent().getIntExtra("ID", -1);
				
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


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// Inflate the menu; this adds items to the action bar if it is present.
		inflater.inflate(R.menu.detalles, menu);
	}
	
	

}
