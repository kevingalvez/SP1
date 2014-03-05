package com.tareas.ug.activities;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

import com.tareas.ug.R;
import com.tareas.ug.fragments.FragmentComments;
import com.tareas.ug.fragments.FragmentsTiendasDetalles;
//import android.view.View;

public class Detalles extends ActionBarActivity {
	
	Fragment[] fragments = new Fragment[] {new FragmentsTiendasDetalles(), new FragmentComments()};	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalles);
		
		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction().add(R.id.Detalles, fragments[0]).commit();
		//manager.beginTransaction().add(R.id.Detalles, fragments[1]).commit();		
			
			
	}
}
	