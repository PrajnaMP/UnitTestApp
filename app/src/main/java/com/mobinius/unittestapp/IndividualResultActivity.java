package com.mobinius.unittestapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by prajna on 15/11/16.
 */

public class IndividualResultActivity extends Activity {
    private String name, rollno, result;
    private TextView mName, mRollno, mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);

        mName = (TextView) findViewById(R.id.individual_name);
        mRollno = (TextView) findViewById(R.id.individual_roll_no);
        mResult = (TextView) findViewById(R.id.individual_result);

        name = getIntent().getStringExtra("name");
        rollno = getIntent().getStringExtra("rollno");
        result = getIntent().getStringExtra("result");

        mName.setText(name);
        mRollno.setText(rollno);
        mResult.setText(result);
    }
}
