package com.futonredemption.nokeyguard.activities;

import com.futonredemption.nokeyguard.Intents;
import com.futonredemption.nokeyguard.R;
import com.futonredemption.nokeyguard.StrictModeEnabler;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class NoKeyguardPreferenceActivity extends PreferenceActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		StrictModeEnabler.setupStrictMode();
		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.pref_main);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		this.startService(Intents.refreshWidgets(this));
		finish();
	}
}
