package com.mk.pomoapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder>{
    private List<Historial> historialList;

    public class HistorialViewHolder extends RecyclerView.ViewHolder {
        public TextView tipo, opcion_tiempo, tiempo_designado, tiempo_transcurrido, hora_inicio, hora_fin;

        public HistorialViewHolder(View view) {
            super(view);
            tipo = view.findViewById(R.id.tvTipo);
            opcion_tiempo = view.findViewById(R.id.tvOpcionTiempo);
            tiempo_designado = view.findViewById(R.id.tvTiempoDesignado);
            tiempo_transcurrido = view.findViewById(R.id.tvTiempoTranscurrido);
            hora_inicio = view.findViewById(R.id.tvHoraInicio);
            //hora_fin = view.findViewById(R.id.hora_fin);
        }
    }

    public HistorialAdapter(List<Historial> historialList) {
        this.historialList = historialList;
    }

    @Override
    public HistorialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_historial, parent, false);

        return new HistorialViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HistorialViewHolder holder, int position) {
        Historial historial = historialList.get(position);
        holder.tipo.setText(historial.getTipo());
        holder.opcion_tiempo.setText(historial.getOpcion_tiempo());
        holder.tiempo_designado.setText(String.valueOf(historial.getTiempo_designado()));
        holder.tiempo_transcurrido.setText(String.valueOf(historial.getTiempo_transcurrido()));
        holder.hora_inicio.setText(historial.getHora_inicio());
        //holder.hora_fin.setText(historial.getHoraFin());
    }

    @Override
    public int getItemCount() {
        return historialList.size();
    }
}
