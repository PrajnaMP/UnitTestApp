package com.mobinius.unittestapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by prajna on 16/11/16.
 */

public class RegistrationActivity extends Activity {
    private EditText mName, mPassword;
    private Button mSubmit;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
    }

    private void init() {
        mName = (EditText) findViewById(R.id.register_name);
        mPassword = (EditText) findViewById(R.id.register_password);
        mSubmit = (Button) findViewById(R.id.register_submit);
       final String mEmail=mName.getText().toString();
       final String mPassWord=mPassword.getText().toString();
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                intent.putExtra("name", mName.getText().toString());
                intent.putExtra("password", mPassword.getText().toString());
                startActivity(intent);
            }
        });
    }
}
