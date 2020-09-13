package com.example.bffdiabetes.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import com.example.bffdiabetes.HomeActivity;
import com.example.bffdiabetes.R;
import com.example.bffdiabetes.Helper.InputValidation;
import com.example.bffdiabetes.sql.DatabaseHelper;
import com.example.bffdiabetes.utils.PreferenceUtils;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

@SuppressLint("Registered")
public class LoginActivityNew extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = LoginActivityNew.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;

    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;

    private AppCompatButton appCompatButtonLogin;
    private AppCompatImageButton appCompatButtonface;
    private AppCompatImageButton appCompatButtoninsta;
    private AppCompatImageButton appCompatButtontweet;


    private AppCompatTextView textViewLinkRegister;
    private AppCompatTextView textViewLinkForgotPassword;

     private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

//    public void face1 (View view){
//        Intent faceIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tr-tr.facebook.com/wakkas.dogan"));
//        startActivity(faceIntent);
//    }

    public void insta1 (View view){
        Intent instaIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/wakkasdgn/?hl=tr\""));
        startActivity(instaIntent);
    }
    public void twit1 (View view){
        Intent twit1Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/WakkasDgn"));
        startActivity(twit1Intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_1);


        initViews();
        initListeners();
        initObjects();
    }
    private void initViews(){
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);

        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);

        appCompatButtonLogin = (AppCompatButton) findViewById(R.id.appCompatButtonLogin);

        textViewLinkRegister = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);
        textViewLinkForgotPassword = (AppCompatTextView) findViewById(R.id.forgotPassword);
        PreferenceUtils utils = new PreferenceUtils();

        if (utils.getEmail(this) != null ){
            Intent intent = new Intent(LoginActivityNew.this, HomeActivity.class);
            startActivity(intent);
        }else{

        }
    }

    private void initListeners(){
        appCompatButtonLogin.setOnClickListener(this);

        textViewLinkRegister.setOnClickListener(this);
        textViewLinkForgotPassword.setOnClickListener(this);
    }

    private void initObjects(){
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.appCompatButtonLogin:
                verifyFromSQLite();
                break;
            case R.id.textViewLinkRegister:
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivityNew.class);
                startActivity(intentRegister);
                break;
            case R.id.forgotPassword:
                Intent intent = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(intent);
                break;
//            case R.id.face:
//                Intent faceIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tr-tr.facebook.com/wakkas.dogan"));
//                startActivity(faceIntent);
//                break;
//            case R.id.insta:
//
//                Intent instaIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/wakkasdgn/?hl=tr\""));
//                startActivity(instaIntent);
//                break;
//            case R.id.tweet:
//                Intent twit1Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/WakkasDgn"));
//                startActivity(twit1Intent);
//                break;
        }


    }


    private void verifyFromSQLite(){
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_email))) {
            return;
        }
        String email = textInputEditTextEmail.getText().toString().trim();
        String password = textInputEditTextPassword.getText().toString().trim();

        if (databaseHelper.checkUser(email, password)) {
            PreferenceUtils.saveEmail(email, this);
            PreferenceUtils.savePassword(password, this);
            Intent accountsIntent = new Intent(activity, HomeActivity.class);
            accountsIntent.putExtra("EMAIL", textInputEditTextEmail.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountsIntent);
            finish();
        } else {
            Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }
    }

    private void emptyInputEditText(){
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
    }


    public void face1(View view) {
        Intent faceIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tr-tr.facebook.com/wakkas.dogan"));
        startActivity(faceIntent);
    }
}
