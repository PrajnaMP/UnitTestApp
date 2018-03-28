package com.mobinius.unittestapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by prajna on 8/11/16.
 */

public class LoginActivity extends Activity {
    private EditText mUserName, mPassWord;
    private Button mLogIn;
    private String mEmail, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private boolean validateData() {

        if (mEmail.equals("") || mPassword.equals("")) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("FIELD_VACCANT");
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

            return false;
        }

        if (!validateEmailAddress(mEmail.toString())) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Invalid Email Id");
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

            return false;
        }

        if (mPassword.length() < 8 || mPassword.length() > 8) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Invalid Password");
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

            return false;

        } else if (mEmail.equals("prajna@gmail.com") && mPassword.equals("12345678")) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Login Successful");
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                    intent.putExtra("username", mEmail);
                    intent.putExtra("password", mPassword);
                    mUserName.setText("");
                    mPassWord.setText("");
                    startActivity(intent);
                }
            });
            alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

            return true;

        } else {
            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(intent);
        }

        return true;
    }

    public static boolean validateEmailAddress(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void init() {
        mUserName = (EditText) findViewById(R.id.username_edit_text);
        mPassWord = (EditText) findViewById(R.id.password_edit_text);
        mLogIn = (Button) findViewById(R.id.login_button);
        mLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEmail = mUserName.getText().toString();
                mPassword = mPassWord.getText().toString();
                validateData();
            }
        });

        Intent intent = new Intent();
        String username = getIntent().getStringExtra("name");
        String userpassword = getIntent().getStringExtra("password");
        mUserName.setText(username);
        mPassWord.setText(userpassword);
    }

    @Override
    public void onBackPressed() {

    }
}
