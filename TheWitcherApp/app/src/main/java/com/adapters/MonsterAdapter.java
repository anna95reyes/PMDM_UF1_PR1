package com.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.SelectedMonsterType;
import com.example.Monster;
import com.thewitcherapp.R;

import java.util.List;

public class MonsterAdapter extends RecyclerView.Adapter<MonsterAdapter.ViewHolder> {

    private List<Monster> mMonsters;
    private SelectedMonsterType mActivity;
    private Context context;

    public MonsterAdapter(List<Monster> pMonsters, SelectedMonsterType activity, Context c){
        // desem les dades a un atribut de la classe
        mMonsters = pMonsters;
        mActivity= activity;
        context = c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View filaView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.llista_monsters, viewGroup, false);
        return new ViewHolder(filaView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Monster m = mMonsters.get(position);
        holder.txtTitolMonster.setText(m.getTitle());
        int drawableResourceId = context.getResources().getIdentifier(m.getImage(), "drawable", context.getPackageName());
        holder.imgMonster.setBackgroundResource(drawableResourceId);
    }

    @Override
    public int getItemCount() {
        return mMonsters.size();
    }

    private int filaSeleccionada = -1;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgMonster;
        public TextView txtTitolMonster;

        public ViewHolder(@NonNull View fila) {
            super(fila);
            imgMonster = fila.findViewById(R.id.imgMonster);
            txtTitolMonster = fila.findViewById(R.id.txtTitolMonster);
/*
            fila.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int seleccionadaAnterior = filaSeleccionada;
                    filaSeleccionada = getAdapterPosition();
                    //notifyDataSetChanged();
                    notifyItemChanged(filaSeleccionada);
                    notifyItemChanged(seleccionadaAnterior);
                    mActivity.onSelectedItem(filaSeleccionada);
                }
            });


 */
        }
    }

}
