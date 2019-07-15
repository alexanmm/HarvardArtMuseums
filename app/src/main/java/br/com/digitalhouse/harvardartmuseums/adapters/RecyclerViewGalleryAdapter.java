package br.com.digitalhouse.harvardartmuseums.adapters;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.interfaces.RecyclerViewGalleryClickListener;
import br.com.digitalhouse.harvardartmuseums.model.Obra;

public class RecyclerViewGalleryAdapter extends RecyclerView.Adapter<RecyclerViewGalleryAdapter.ViewHolder> {

    private List<Obra> obras;
    private RecyclerViewGalleryClickListener listener;

    public RecyclerViewGalleryAdapter(List<Obra> obras, RecyclerViewGalleryClickListener listener) {
        this.obras = obras;
        this.listener = listener;
    }


    @NonNull
    @Override
    public RecyclerViewGalleryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_galeria_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewGalleryAdapter.ViewHolder viewHolder, int i) {
        final Obra obra = obras.get(i);
        viewHolder.bind(obra);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(obra);
            }
        });

        viewHolder.imageViewFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Se for favoirito muda a imagem
                if (obra.isFavorite()){
                    viewHolder.imageViewFavorite.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                }else {
                    viewHolder.imageViewFavorite.setImageResource(R.drawable.ic_favorite_red_24dp);
                }

                // configura um novo valor para o favorito
                obra.setFavorite(!obra.isFavorite());
            }
        });
    }

    @Override
    public int getItemCount() {
        return obras.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewImagemObra;
        private TextView textViewNomeObra;
        private TextView textViewDescricaoObra;
        private ImageView imageViewFavorite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewImagemObra = itemView.findViewById(R.id.imageViewImagemObra);
            textViewNomeObra = itemView.findViewById(R.id.textViewNomeObra);
            textViewDescricaoObra = itemView.findViewById(R.id.textViewDescricaoObra);
            imageViewFavorite = itemView.findViewById(R.id.imageViewFavorite);
        }

        public void bind(Obra obra) {
            imageViewImagemObra.setImageDrawable(ContextCompat.getDrawable(imageViewImagemObra.getContext(), obra.getImagemObra()));
            textViewNomeObra.setText(obra.getNomeObra());
            textViewDescricaoObra.setText(obra.getDescricaoObra());
            if(obra.isFavorite()) {
                imageViewFavorite.setImageDrawable(ContextCompat.getDrawable(imageViewFavorite.getContext(), R.drawable.ic_favorite_red_24dp));
            }
        }
    }
}
