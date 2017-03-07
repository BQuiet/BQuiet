package com.bquiet.bquiet.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bquiet.bquiet.MyClass;
import com.bquiet.bquiet.R;

public class RowViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private MyClass myClass;

    public RowViewHolder(View row) {
        super(row);
        nameTextView = (TextView) row.findViewById(R.id.cardview_class_text);
    }

    public MyClass getMyClass() {
        return myClass;
    }

    public void setMyClass(MyClass myClass) {
        this.myClass = myClass;
        nameTextView.setText(myClass.getName());
    }
}


