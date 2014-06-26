package com.mindpin.android.codescanview.samples;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

import com.mindpin.android.codescanview.samples.BuildConfig;
import com.mindpin.android.codescanview.samples.R;

public class MainActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		if (BuildConfig.DEBUG)
//		{
//			Log.d(getClass().getName(), "onCreate");
//			Log.d(getClass().getName(), "using library '" + Resources.getLibraryName(this) + "', version " + Resources.getLibraryVersion(this));
//		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}
}
