package com.bquiet.bquiet.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bquiet.bquiet.MyClass;
import com.bquiet.bquiet.R;
import com.bquiet.bquiet.adapters.MyClassListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyClassFragment extends Fragment {
    private RecyclerView recyclerView;

    public MyClassFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_class, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.fragment__my_class_recycler_view);

        List<MyClass> listMyClass = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            MyClass e = new MyClass("MyClass" + i);
            listMyClass.add(e);
        }
        MyClassListAdapter adapter = new MyClassListAdapter(getContext(), listMyClass);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}
