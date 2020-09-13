package com.example.bffdiabetes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.VolumeShaper;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.bffdiabetes.Helper.LocaleHelper;

import java.util.Locale;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin,btnRegister,btnLanguage;

    public void face1 (View view){
        Intent faceIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tr-tr.facebook.com/wakkas.dogan"));
        startActivity(faceIntent);
    }

    public void insta1 (View view){
        Intent instaIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/wakkasdgn/?hl=tr\""));
        startActivity(instaIntent);
    }
    public void twit1 (View view){
        Intent twit1Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/WakkasDgn"));
        startActivity(twit1Intent);
    }

    public void init(){
        btnLogin = (Button) findViewById(R.id.alreadyAccount);
        btnRegister = (Button) findViewById(R.id.newaccount);



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        init();



    }



}
