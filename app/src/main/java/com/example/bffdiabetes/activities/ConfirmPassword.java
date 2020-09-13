package com.example.bffdiabetes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.NestedScrollView;

import com.example.bffdiabetes.R;


import com.example.bffdiabetes.Helper.InputValidation;
import com.example.bffdiabetes.sql.DatabaseHelper;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


/**
 * Created by delaroy on 3/3/18.
 */

public class ConfirmPassword extends AppCompatActivity {
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextConfirmPassword;

    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private NestedScrollView nestedScrollView;
    private AppCompatButton appCompatButtonReset;

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_confirmpassword);

        inputValidation = new InputValidation(this);
        databaseHelper = new DatabaseHelper(this);

        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputpass);
        textInputEditTextConfirmPassword = (TextInputEditText) findViewById(R.id.textInputConfirmPassword);

        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutConfirmPassword = (TextInputLayout) findViewById(R.id.textInputLayoutConfirmPassword);
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        appCompatButtonReset = (AppCompatButton) findViewById(R.id.appCompatButtonReset);

        Intent intent = getIntent();
        email = intent.getStringExtra("EMAIL");

        setTitle("Reset password");

        appCompatButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePassword();
            }
        });
    }


    private void updatePassword() {

        String value1 = textInputEditTextPassword.getText().toString().trim();
        String value2 = textInputEditTextConfirmPassword.getText().toString().trim();

        if (value1.isEmpty() && value2.isEmpty()){
            Toast.makeText(this, "fill all fields ", Toast.LENGTH_LONG).show();
            return;
        }

        if (!value1.contentEquals(value2)){
            Toast.makeText(this, "password doesn't match", Toast.LENGTH_LONG).show();
            return;
        }

        if (!databaseHelper.checkUser(email)) {

            Snackbar.make(nestedScrollView, "email doesn't exist", Snackbar.LENGTH_LONG).show();
            return;

        } else {
            databaseHelper.updatePassword(email, value1);

            Toast.makeText(this, "password reset successfully", Toast.LENGTH_SHORT).show();
            emptyInputEditText();

            Intent intent = new Intent(this, LoginActivityNew.class);
            startActivity(intent);
            finish();
        }

    }

    private void emptyInputEditText()
    {
        textInputEditTextPassword.setText("");
        textInputEditTextConfirmPassword.setText("");
    }
}
