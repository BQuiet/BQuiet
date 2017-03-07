package com.bquiet.bquiet.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bquiet.bquiet.MyClass;
import com.bquiet.bquiet.R;
import com.bquiet.bquiet.views.RowViewHolder;

import java.util.List;


public class MyClassListAdapter extends RecyclerView.Adapter<RowViewHolder>{
    private List<MyClass> myClassList;
    private LayoutInflater inflater;

    public MyClassListAdapter(Context context, List<MyClass> myClassList) { // Contexto para crear layoutInflater
        inflater = LayoutInflater.from(context);
        this.myClassList = myClassList;
    }

    @Override
    public RowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {   // Lo llama la lista para crear tantos diseños en memoria como quepan en pantalla. Se llama tantas veces como filas entran en pantalla
        Log.d("ADAPTER", "Creando una nueva fila en memoria");
        View view = inflater.inflate(R.layout.cardview_class, parent, false); // Carga una vista
        RowViewHolder row = new RowViewHolder(view);               // Crea celdas vacías en memoria
        return row;
    }

    @Override
    public void onBindViewHolder(RowViewHolder holder, int position) {
        Log.d("ADAPTER", "Reciclando una fila antigua y pintándola en la posición" + position);
        MyClass myClass = myClassList.get(position);
        holder.setMyClass(myClass);
    }

    @Override
    public int getItemCount() {
        if(myClassList == null) {
            Log.w("WARNING", "Se ha pasado una lista vacía");
            return 0;
        }
        return myClassList.size();
    }

}
