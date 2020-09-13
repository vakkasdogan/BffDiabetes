package com.example.bffdiabetes;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.bffdiabetes.activities.LoginActivityNew;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bffdiabetes.R;

import com.example.bffdiabetes.utils.PreferenceUtils;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    Button next_page_btn;

    private TextView textViewName;

    @SuppressLint({"WrongViewCast", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewName = (TextView) findViewById(R.id.text1);
        Intent intent = getIntent();
        if (intent.hasExtra("EMAIL")){
            String nameFromIntent = getIntent().getStringExtra("EMAIL");
            textViewName.setText("Welcome " + nameFromIntent);
        }else{
            String email = PreferenceUtils.getEmail(this);
            textViewName.setText("Welcome " + email);

        }

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_message);
        }

        next_page_btn= findViewById(R.id.next_page);
        next_page_btn.setOnClickListener(v -> {
            Intent registerIntent = new Intent(HomeActivity.this,WelcomeActivity.class);
            startActivity(registerIntent);
        });
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.nav_chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ChatFragment()).commit();
                break;
            case R.id.nav_about_us:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutUs()).commit();
                break;
            case R.id.nav_profile:
                Intent Intent1 = new Intent(HomeActivity.this,CurrentStateActivity.class);
                startActivity(Intent1);
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//
                break;
            case R.id.nav_alarm:
                Intent registerIntent = new Intent(HomeActivity.this,MainAlarmActivity.class);
                startActivity(registerIntent);
                break;
            case R.id.nav_reminder:
                Intent registerIntent1 = new Intent(HomeActivity.this,MainReminderActivity.class);
                startActivity(registerIntent1);
                break;
            case R.id.nav_news:
                Intent Intent23 = new Intent(HomeActivity.this,Diabetes_org.class);
                startActivity(Intent23);
                break;

            case R.id.nav_predictState:
                Intent Intent2 = new Intent(HomeActivity.this,PredictStateActivity.class);
                startActivity(Intent2);
                break;
            case R.id.nav_share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my app");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Intent instaIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/wakkasdgn/?hl=tr"));
                startActivity(instaIntent1);
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_email:
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","vkksdgn2@gmail.com", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                intent.putExtra(Intent.EXTRA_TEXT, "message");
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.log_out:
                PreferenceUtils.savePassword(null, this);
                PreferenceUtils.saveEmail(null, this);
                Intent intent = new Intent(this, LoginActivityNew.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.action_language:
                Intent languageIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(languageIntent);
                return true;
            default:
                // Do nothing

        }

        return super.onOptionsItemSelected(item);
    }


}
