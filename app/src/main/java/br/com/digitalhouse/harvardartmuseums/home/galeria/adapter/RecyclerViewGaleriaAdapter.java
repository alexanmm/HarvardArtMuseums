package br.com.digitalhouse.harvardartmuseums.home.galeria.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.home.DetalheDaObraActivity;
import br.com.digitalhouse.harvardartmuseums.home.galeria.model.Obra;

public class RecyclerViewGaleriaAdapter extends RecyclerView.Adapter<RecyclerViewGaleriaAdapter.ViewHolder> {

    private List<Obra> obras;
    private String andarAtual;


    public RecyclerViewGaleriaAdapter(List<Obra> obras, String andarAtual) {
        this.obras = obras;
        this.andarAtual = andarAtual;
    }

    @NonNull
    @Override
    public RecyclerViewGaleriaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_galeria_item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewGaleriaAdapter.ViewHolder viewHolder, int i) {
        Obra obra = obras.get(i);
        viewHolder.setConteudoNoRecyclerViewGaleria(obra);
    }

    @Override
    public int getItemCount() {
        return obras.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewImagemObra;
        private TextView textViewNomeObra;
        private TextView textViewDescricaoObra;
        private TextView textViewAndarAtualObra;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            final int idObra;
            imageViewImagemObra = itemView.findViewById(R.id.imageViewImagemObra);
            textViewNomeObra = itemView.findViewById(R.id.textViewNomeObra);
            textViewDescricaoObra = itemView.findViewById(R.id.textViewDescricaoObra);
            textViewAndarAtualObra = itemView.findViewById(R.id.textViewAndarAtual);

            idObra = R.id.imageViewImagemObra;


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    andarAtual = textViewAndarAtualObra.getText().toString();
                    Intent intentDetalhe = new Intent(v.getContext(), DetalheDaObraActivity.class);
                    Bundle bundleDetalhe = new Bundle();
                    bundleDetalhe.putInt("OBRA", idObra);
                    bundleDetalhe.putString("ANDAR", andarAtual);
                    intentDetalhe.putExtras(bundleDetalhe);
                    v.getContext().startActivity(intentDetalhe);
                }
            });
        }

        private void setConteudoNoRecyclerViewGaleria(Obra obra){
            imageViewImagemObra.setImageDrawable(ContextCompat.getDrawable(imageViewImagemObra.getContext(),obra.getImagemObra()));
            textViewNomeObra.setText(obra.getNomeObra());
            textViewDescricaoObra.setText(obra.getDescricaoObra());
            textViewAndarAtualObra.setText(obra.getAndarObra());
        }



    }
}
