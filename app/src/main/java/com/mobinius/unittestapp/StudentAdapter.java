package com.mobinius.unittestapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by prajna on 15/11/16.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.CustomViewHolder> {
    private List<StudentClass> studentList;
    private Context context;
    private LinearLayout linearLayout;

    public StudentAdapter(Context context, List<StudentClass> studentList) {
        this.studentList = studentList;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        final StudentClass student = studentList.get(position);
        holder.name.setText(student.getName());
        holder.rollno.setText(student.getRollno());
        holder.result.setText(student.getResult());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, IndividualResultActivity.class);
                intent.putExtra("name", student.getName());
                intent.putExtra("rollno", student.getRollno());
                intent.putExtra("result", student.getResult());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView name, rollno, result;
        public LinearLayout linearLayout;

        public CustomViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            rollno = (TextView) view.findViewById(R.id.roll_no);
            result = (TextView) view.findViewById(R.id.result);
            linearLayout = (LinearLayout) view.findViewById(R.id.main_layout);
        }
    }
}
