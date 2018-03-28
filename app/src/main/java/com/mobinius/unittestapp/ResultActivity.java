package com.mobinius.unittestapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajna on 11/11/16.
 */

public class ResultActivity extends Activity {
    private List<StudentClass> studentList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private StudentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new StudentAdapter(this, studentList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        studentResult();
    }

    private void studentResult() {
        StudentClass student = new StudentClass("Prajna M P", "4SN11EC074", "PASS");
        studentList.add(student);
        student = new StudentClass("Pooja Nayak", "4SN11EC073", "PASS");
        studentList.add(student);
        student = new StudentClass("Prathima Bhat", "4SN11EC075", "PASS");
        studentList.add(student);
        student = new StudentClass("Pooja Shetty", "4SN11EC072", "PASS");
        studentList.add(student);
        student = new StudentClass("Pinki Mol", "4SN11EC071", "PASS");
        studentList.add(student);
        student = new StudentClass("Nisha O R", "4SN11EC069", "PASS");
        studentList.add(student);
        student = new StudentClass("Pravitha Prakash", "4SN11EC076", "PASS");
        studentList.add(student);
        student = new StudentClass("Nireeksha B", "4SN11EC068", "PASS");
        studentList.add(student);
        student = new StudentClass("Keerthi P M", "4SN11EC080", "PASS");
        studentList.add(student);
        student = new StudentClass("Sapna S", "4SN11EC081", "PASS");
        studentList.add(student);
        student = new StudentClass("Vidya M", "4SN11EC082", "PASS");
        studentList.add(student);
        student = new StudentClass("Vandana Suvarna", "4SN11EC083", "PASS");
        studentList.add(student);
        student = new StudentClass("Swathi Lakshmi", "4SN11EC084", "PASS");
        studentList.add(student);
        student = new StudentClass("Sony P", "4SN11EC085", "PASS");
        studentList.add(student);
        student = new StudentClass("Shabnam", "4SN11EC086", "PASS");
        studentList.add(student);
        student = new StudentClass("Tessy V T", "4SN11EC087", "PASS");
        studentList.add(student);
        student = new StudentClass("Vishakha", "4SN11EC088", "PASS");
        studentList.add(student);
        student = new StudentClass("Keerthana", "4SN11EC089", "PASS");
        studentList.add(student);
        student = new StudentClass("Meghana", "4SN11EC090", "PASS");
        studentList.add(student);
        student = new StudentClass("Vani", "4SN11EC091", "PASS");
        studentList.add(student);
        student = new StudentClass("Preemol", "4SN11EC092", "PASS");
        studentList.add(student);
        student = new StudentClass("Smrithi", "4SN11EC093", "PASS");
        studentList.add(student);
        student = new StudentClass("Shobhitha", "4SN11EC094", "PASS");
        studentList.add(student);
        student = new StudentClass("Vanitha", "4SN11EC095", "PASS");
        studentList.add(student);
        student = new StudentClass("Kavya", "4SN11EC096", "PASS");
        studentList.add(student);
        student = new StudentClass("Priyanka", "4SN11EC097", "PASS");
        studentList.add(student);
        student = new StudentClass("Manu", "4SN11EC098", "PASS");
        studentList.add(student);
        student = new StudentClass("DeviPrasad", "4SN11EC099", "PASS");
        studentList.add(student);
        student = new StudentClass("Karthik", "4SN11EC100", "PASS");
        studentList.add(student);
        student = new StudentClass("Prajwal M P", "4SN11EC070", "PASS");
        studentList.add(student);
        mAdapter.notifyDataSetChanged();
    }
}
