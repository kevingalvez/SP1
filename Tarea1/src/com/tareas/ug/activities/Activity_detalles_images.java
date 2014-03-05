package com.tareas.ug.activities;

import com.tareas.ug.R;
import com.tareas.ug.R.layout;
import com.tareas.ug.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Activity_detalles_images extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_detalles_images);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_detalles_images, menu);
		return true;
	}

}
