package br.com.digitalhouse.harvardartmuseums.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.data.database.Database;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.FavoritesDAO;
import br.com.digitalhouse.harvardartmuseums.interfaces.RecyclerViewFavoritesClickListener;
import br.com.digitalhouse.harvardartmuseums.model.favorites.Favorites;
import br.com.digitalhouse.harvardartmuseums.model.object.Object;

public class RecyclerViewFavoritesAdapter extends RecyclerView.Adapter<RecyclerViewFavoritesAdapter.ViewHolder> {

    private List<Favorites> favoritesList;
    private RecyclerViewFavoritesClickListener listener;

    public RecyclerViewFavoritesAdapter(List<Favorites> favoritesList, RecyclerViewFavoritesClickListener listener) {
        this.favoritesList = favoritesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_favorites_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final Favorites favorites = favoritesList.get(position);
        viewHolder.bind(favorites);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(favorites);
            }
        });

        viewHolder.imageViewFavoritesStar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewHolder.imageViewFavoritesStar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewHolder.imageViewFavoritesStar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewHolder.imageViewFavoritesStar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewHolder.imageViewFavoritesStar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewHolder.imageViewFavoritesItemShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewHolder.imageViewFavoritesItemTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewHolder.imageViewFavoritesItemSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Remove item
        viewHolder.imageViewFavoritesItemRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Remove o item na tela
                removeFavorites(position);

                //Remove o item no banco de dados
                removeFavoritosUsuario(v.getContext(), favorites.getObjectGallery());
            }
        });
    }

    //Método para remover o item
    public void removeFavorites(int position) {

        favoritesList.remove(position);

        notifyDataSetChanged();
    }

    public void updateFavorites(List<Favorites> favoritesList) {
        this.favoritesList = favoritesList;

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return favoritesList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewFavoritesItemObject;
        private ImageView imageViewFavoritesStar1;
        private ImageView imageViewFavoritesStar2;
        private ImageView imageViewFavoritesStar3;
        private ImageView imageViewFavoritesStar4;
        private ImageView imageViewFavoritesStar5;
        private ImageView imageViewFavoritesItemShare;
        private ImageView imageViewFavoritesItemTranslate;
        private ImageView imageViewFavoritesItemSpeak;
        private ImageView imageViewFavoritesItemRemove;
        private TextView textViewFavoritesItemObjectTitle;
        private TextView textViewFavoritesItemObjectDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewFavoritesItemObject = itemView.findViewById(R.id.imageViewFavoritesItemObject);
            imageViewFavoritesStar1 = itemView.findViewById(R.id.imageViewFavoritesStar1);
            imageViewFavoritesStar2 = itemView.findViewById(R.id.imageViewFavoritesStar2);
            imageViewFavoritesStar3 = itemView.findViewById(R.id.imageViewFavoritesStar3);
            imageViewFavoritesStar4 = itemView.findViewById(R.id.imageViewFavoritesStar4);
            imageViewFavoritesStar5 = itemView.findViewById(R.id.imageViewFavoritesStar5);
            imageViewFavoritesItemShare = itemView.findViewById(R.id.imageViewFavoritesItemShare);
            imageViewFavoritesItemTranslate = itemView.findViewById(R.id.imageViewFavoritesItemTranslate);
            imageViewFavoritesItemSpeak = itemView.findViewById(R.id.imageViewFavoritesItemSpeak);
            imageViewFavoritesItemRemove = itemView.findViewById(R.id.imageViewFavoritesItemRemove);
            textViewFavoritesItemObjectTitle = itemView.findViewById(R.id.textViewFavoritesItemObjectTitle);
            textViewFavoritesItemObjectDescription = itemView.findViewById(R.id.textViewFavoritesItemObjectDescription);

        }

        public void bind(Favorites favorites) {

            //Imagem
            if (favorites.getObjectGallery().getPrimaryimageurl() != null) {
                Picasso.get().setIndicatorsEnabled(true);
                Picasso.get()
                        .load(favorites.getObjectGallery().getPrimaryimageurl())
                        .error(R.mipmap.ic_launcher)
                        .placeholder(R.mipmap.ic_launcher)
                        .into(imageViewFavoritesItemObject);
            }

            //Favoritos Título
            textViewFavoritesItemObjectTitle.setText(favorites.getObjectGallery().getTitle());

            //Descrição dos favoritos
            textViewFavoritesItemObjectDescription.setText(favorites.getObjectGallery().getDescription());
        }
    }

    public void removeFavoritosUsuario(Context context, Object objectFavorites) {

        FavoritesDAO dao = Database.getDatabase(context).favoritesDAO();

        new Thread(() -> {
            dao.deleteByUserObjectId(objectFavorites.getLoginUser(), objectFavorites.getObjectid());
        }).start();
    }

}
