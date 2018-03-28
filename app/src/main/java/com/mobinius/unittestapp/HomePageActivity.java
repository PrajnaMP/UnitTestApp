package com.mobinius.unittestapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by prajna on 9/11/16.
 */

public class HomePageActivity extends Activity {
    private TextView mName, mPass, mWelcome;
    private Button mClick;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mName = (TextView) findViewById(R.id.username_value);
        mPass = (TextView) findViewById(R.id.password_value);
        mWelcome = (TextView) findViewById(R.id.welcome_text_view);
        mClick = (Button) findViewById(R.id.click_button);

        username = getIntent().getStringExtra("username");
        password = getIntent().getStringExtra("password");
        mName.setText(username);
        mPass.setText(password);
        mClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, ResultActivity.class);
                intent.putExtra("name", username);
                startActivity(intent);
            }
        });
    }
}