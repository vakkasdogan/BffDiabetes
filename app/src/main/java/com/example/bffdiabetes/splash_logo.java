package com.example.bffdiabetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.bffdiabetes.activities.LoginActivityNew;

public class splash_logo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_logo);
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                try
                {
                    sleep(4000);

                }
                catch (Exception e)
                {
                    e.printStackTrace();

                }
                finally
                {
                    Intent mainIntent = new Intent(splash_logo.this,LoginActivityNew.class);
                    startActivity(mainIntent);

                }
            }
        };
        thread.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();

    }

}

