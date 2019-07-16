package br.com.digitalhouse.harvardartmuseums.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.interfaces.RecyclerViewFavoriteClickListener;
import br.com.digitalhouse.harvardartmuseums.model.Obra;

public class RecyclerViewFavoriteAdapter extends RecyclerView.Adapter<RecyclerViewFavoriteAdapter.ViewHolder>{

    private List<Obra> obrasFavorties;
    private RecyclerViewFavoriteClickListener listener;

    public RecyclerViewFavoriteAdapter(List<Obra> obrasFavorties, RecyclerViewFavoriteClickListener listener) {
        this.obrasFavorties = obrasFavorties;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_favorite_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final Obra obra = obrasFavorties.get(position);
        viewHolder.bind(obra);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(obra);
            }
        });

        // Click em imagem de delete
        viewHolder.imageViewRemoveFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(position);
            }
        });
    }

    //Método para remover o item
    public void removeItem(int position){
        obrasFavorties.get(position).setFavorite(false);
        obrasFavorties.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return obrasFavorties.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewImagemObra;
        private TextView textViewNomeObra;
        private TextView textViewDescricaoObra;
        private ImageView imageViewRemoveFavorite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewImagemObra = itemView.findViewById(R.id.imageViewImagemObra);
            textViewNomeObra = itemView.findViewById(R.id.textViewNomeObra);
            textViewDescricaoObra = itemView.findViewById(R.id.textViewDescricaoObra);
            imageViewRemoveFavorite = itemView.findViewById(R.id.imageViewRemoveFavorite);
        }

        public void bind(Obra obra) {
            imageViewImagemObra.setImageDrawable(ContextCompat.getDrawable(imageViewImagemObra.getContext(), obra.getImagemObra()));
            textViewNomeObra.setText(obra.getNomeObra());
            textViewDescricaoObra.setText(obra.getDescricaoObra());
        }
    }
}
