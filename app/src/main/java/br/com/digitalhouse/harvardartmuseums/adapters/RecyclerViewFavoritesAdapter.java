package br.com.digitalhouse.harvardartmuseums.adapters;

import android.content.Intent;
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
import br.com.digitalhouse.harvardartmuseums.interfaces.RecyclerViewFavoritesClickListener;
import br.com.digitalhouse.harvardartmuseums.model.favorites.Favorites;
import br.com.digitalhouse.harvardartmuseums.model.userdata.UserData;

public class RecyclerViewFavoritesAdapter extends RecyclerView.Adapter<RecyclerViewFavoritesAdapter.ViewHolder> {

    private List<Favorites> favoritesList;
    private RecyclerViewFavoritesClickListener listener;

    //Dados gerais do usuário
    UserData userData = new UserData();

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

        viewHolder.imageViewFavoritesStar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Compartilhamento
        viewHolder.imageViewFavoritesItemShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Acao de envio na intencao de chamar outra Actitivity
                Intent intentCompartilhar = new Intent(Intent.ACTION_SEND);

                //Envia texto no compartilhamento
                intentCompartilhar.putExtra(Intent.EXTRA_TEXT, "Sharing favorites:" + "\n" +
                        "\nTitle: " + favorites.getObjectGallery().getTitle() + "\n" +
                        "\nDescription: " + favorites.getObjectGallery().getVerificationleveldescription() + "\n" +
                        "\nLink: " + favorites.getObjectGallery().getUrl());

                //Tipo de compartilhamento
                intentCompartilhar.setType("text/plain");

                //Mostra os aplicativos disponiveis para compartilhamento de dados
                Intent intentChooser = Intent.createChooser(
                        intentCompartilhar, "Share type:");

                //Start na Activity de compartilhamento
                viewHolder.itemView.getContext().startActivity(intentChooser);
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

                //Somente remover efetivamente do Banco de Dados quando o favoritos não tiver estrelas
                if (favorites.getObjectGallery().getCountStarsFavorites() == 0){
                    //Remove o item no banco de dados
                    userData.removeFavoritosUsuario(v.getContext(), favorites.getObjectGallery());

                } else{ //Atualiza Favoritos como "False"
                    favorites.getObjectGallery().setFavorite(false);
                    userData.atualizaFavoritosUsuario(v.getContext(), favorites.getObjectGallery());
                }

                //Remove o item na tela
                removeFavorites(position);

            }
        });

        //Cinco estrelas
        //***
        //Uma estrela
        viewHolder.imageViewFavoritesStar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.imageViewFavoritesStar1.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewFavoritesStar2.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                viewHolder.imageViewFavoritesStar3.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                viewHolder.imageViewFavoritesStar4.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                viewHolder.imageViewFavoritesStar5.setImageResource(R.drawable.ic_star_border_yellow_24dp);

                //Atualiza a quantidade de estrelas marcadas
                favorites.getObjectGallery().setCountStarsFavorites(1);

                //Atualiza a tabela de favoritos
                userData.atualizaFavoritosUsuario(v.getContext(), favorites.getObjectGallery());
            }
        });

        //Duas estrelas
        viewHolder.imageViewFavoritesStar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.imageViewFavoritesStar1.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewFavoritesStar2.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewFavoritesStar3.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                viewHolder.imageViewFavoritesStar4.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                viewHolder.imageViewFavoritesStar5.setImageResource(R.drawable.ic_star_border_yellow_24dp);

                //Atualiza a quantidade de estrelas marcadas
                favorites.getObjectGallery().setCountStarsFavorites(2);

                //Atualiza a tabela de favoritos
                userData.atualizaFavoritosUsuario(v.getContext(), favorites.getObjectGallery());
            }
        });

        //Tres estrelas
        viewHolder.imageViewFavoritesStar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.imageViewFavoritesStar1.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewFavoritesStar2.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewFavoritesStar3.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewFavoritesStar4.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                viewHolder.imageViewFavoritesStar5.setImageResource(R.drawable.ic_star_border_yellow_24dp);

                //Atualiza a quantidade de estrelas marcadas
                favorites.getObjectGallery().setCountStarsFavorites(3);

                //Atualiza a tabela de favoritos
                userData.atualizaFavoritosUsuario(v.getContext(), favorites.getObjectGallery());
            }
        });

        //Quatro estrelas
        viewHolder.imageViewFavoritesStar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.imageViewFavoritesStar1.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewFavoritesStar2.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewFavoritesStar3.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewFavoritesStar4.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewFavoritesStar5.setImageResource(R.drawable.ic_star_border_yellow_24dp);

                //Atualiza a quantidade de estrelas marcadas
                favorites.getObjectGallery().setCountStarsFavorites(4);

                //Atualiza a tabela de favoritos
                userData.atualizaFavoritosUsuario(v.getContext(), favorites.getObjectGallery());
            }
        });

        //Cinco estrelas
        viewHolder.imageViewFavoritesStar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.imageViewFavoritesStar1.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewFavoritesStar2.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewFavoritesStar3.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewFavoritesStar4.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewFavoritesStar5.setImageResource(R.drawable.ic_star_fill_yellow_24dp);

                //Atualiza a quantidade de estrelas marcadas
                favorites.getObjectGallery().setCountStarsFavorites(5);

                //Atualiza a tabela de favoritos
                userData.atualizaFavoritosUsuario(v.getContext(), favorites.getObjectGallery());
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
                        .error(R.drawable.image_logo_center)
                        .placeholder(R.drawable.image_logo_center)
                        .into(imageViewFavoritesItemObject);
            }

            //Favoritos Título
            textViewFavoritesItemObjectTitle.setText(favorites.getObjectGallery().getTitle());

            //Descrição dos favoritos
            textViewFavoritesItemObjectDescription.setText(favorites.getObjectGallery().getDescription());

            //Quantidade de estrelas marcadas anteiormente
            if (favorites.getObjectGallery().getCountStarsFavorites() >= 1) {
                imageViewFavoritesStar1.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
            } else {
                imageViewFavoritesStar1.setImageResource(R.drawable.ic_star_border_yellow_24dp);
            }

            if (favorites.getObjectGallery().getCountStarsFavorites() >= 2) {
                imageViewFavoritesStar2.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
            } else {
                imageViewFavoritesStar2.setImageResource(R.drawable.ic_star_border_yellow_24dp);
            }

            if (favorites.getObjectGallery().getCountStarsFavorites() >= 3) {
                imageViewFavoritesStar3.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
            } else {
                imageViewFavoritesStar3.setImageResource(R.drawable.ic_star_border_yellow_24dp);
            }

            if (favorites.getObjectGallery().getCountStarsFavorites() >= 4) {
                imageViewFavoritesStar4.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
            } else {
                imageViewFavoritesStar4.setImageResource(R.drawable.ic_star_border_yellow_24dp);
            }

            if (favorites.getObjectGallery().getCountStarsFavorites() >= 5) {
                imageViewFavoritesStar5.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
            } else {
                imageViewFavoritesStar5.setImageResource(R.drawable.ic_star_border_yellow_24dp);
            }

        }
    }
}
