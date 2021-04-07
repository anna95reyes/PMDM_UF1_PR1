package com.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.SelectedMonsterType;
import com.example.MonsterType;
import com.thewitcherapp.R;

import java.util.List;

public class MonsterTypeAdapter extends RecyclerView.Adapter<MonsterTypeAdapter.ViewHolder> {
    private List<MonsterType> mMonstersType;
    private SelectedMonsterType mActivity;
    private Context context;

    public MonsterTypeAdapter(List<MonsterType> pMonstersType, SelectedMonsterType activity, Context c){
        // desem les dades a un atribut de la classe
        mMonstersType = pMonstersType;
        mActivity= activity;
        context = c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View filaView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.llista_monsters_type, viewGroup, false);
        return new ViewHolder(filaView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MonsterType m = mMonstersType.get(position);
        holder.txtTitolMonsterType.setText(m.getTitle());
        holder.txtSubtitolMonsterType.setText(m.getSubtitle());
        int drawableResourceId = context.getResources().getIdentifier(m.getImage(), "drawable", context.getPackageName());
        holder.imgMonsterType.setBackgroundResource(drawableResourceId);

        if(position==filaSeleccionada) {
            holder.borderMonsterType.setBackgroundColor(Color.YELLOW);

        } else {
            holder.borderMonsterType.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount() {
        return mMonstersType.size();
    }
    private int filaSeleccionada = -1;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout borderMonsterType;
        public RelativeLayout imgMonsterType;
        public TextView txtTitolMonsterType;
        public TextView txtSubtitolMonsterType;

        public ViewHolder(@NonNull View fila) {
            super(fila);
            imgMonsterType = fila.findViewById(R.id.imgMonsterType);
            txtTitolMonsterType = fila.findViewById(R.id.txtTitolMonsterType);
            txtSubtitolMonsterType = fila.findViewById(R.id.txtSubtitolMonsterType);
            borderMonsterType = fila.findViewById(R.id.borderMonsterType);

            fila.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int seleccionadaAnterior = filaSeleccionada;
                    filaSeleccionada = getAdapterPosition();
                    //notifyDataSetChanged();
                    notifyItemChanged(filaSeleccionada);
                    notifyItemChanged(seleccionadaAnterior);
                    MonsterType monsterType = mMonstersType.get(filaSeleccionada);
                    mActivity.onSelectedMonsterType(monsterType);
                }
            });
        }
    }
}
