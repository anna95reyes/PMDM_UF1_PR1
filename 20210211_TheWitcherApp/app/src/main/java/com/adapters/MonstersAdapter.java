package com.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.SelectedItemListener;
import com.example.Bestiary;
import com.example.Monster;
import com.example.MonsterType;
import com.thewitcherapp.R;

import java.util.List;

public class MonstersAdapter extends RecyclerView.Adapter<MonstersAdapter.ViewHolder> {
    private List<MonsterType> mMonsters;
    private SelectedItemListener mActivity;
    private Context context;

    public MonstersAdapter(List<MonsterType> pMonsters, SelectedItemListener activity, Context c){
        // desem les dades a un atribut de la classe
        mMonsters = pMonsters;
        mActivity= activity;
        context = c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View filaView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.llista_monsters, viewGroup, false);
        return new ViewHolder(filaView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MonsterType m = mMonsters.get(position);
        holder.txtTitolMonster.setText(m.getTitle());
        holder.txtSubtitolMonster.setText(m.getSubtitle());
        int drawableResourceId = context.getResources().getIdentifier(m.getImage(), "drawable", context.getPackageName());
        holder.imgMonster.setBackgroundResource(drawableResourceId);

        /*
        if(position==filaSeleccionada) {
            holder.borderMonster.setBackgroundColor(Color.YELLOW);
        } else {
            holder.borderMonster.setBackgroundColor(Color.LTGRAY);
        }
        */
    }

    @Override
    public int getItemCount() {
        return mMonsters.size();
    }
    private int filaSeleccionada = -1;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout borderMonster;
        public RelativeLayout imgMonster;
        public TextView txtTitolMonster;
        public TextView txtSubtitolMonster;
        public ViewHolder(@NonNull View fila) {
            super(fila);
            imgMonster = fila.findViewById(R.id.imgMonster);
            txtTitolMonster = fila.findViewById(R.id.txtTitolMonster);
            txtSubtitolMonster = fila.findViewById(R.id.txtSubtitolMonster);
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
        }
    }
}
