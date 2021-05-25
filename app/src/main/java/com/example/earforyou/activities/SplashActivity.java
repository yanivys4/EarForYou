package com.example.earforyou.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.earforyou.R;

/**
 This activity is the entrance of the application and appear each time the app is initially started.
 */
public class SplashActivity extends Activity {

    private SharedPreferences sharedPref;

    /**
     * Hook method called when a new instance of Activity is
     * created. One time initialization code goes here, e.g.,
     * checking isLoggedIn state and starting the next activity.
     *
     * @param savedInstanceState object that contains saved state information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Always call super class for necessary
        // initialization/implementation.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Context context = SplashActivity.this;
        startMainActivity();
    }
    //============================================================================================

    /**
     * This function is wrapped by a handler that make sure it will execute after 300 m/s.
     * The function Starts the MainActivity.

     */
    private void startMainActivity() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent;
            intent = MainActivity.makeIntent();
            startActivity(intent);
            finish();
        }, 300);
    }
}
//============================================================================================
