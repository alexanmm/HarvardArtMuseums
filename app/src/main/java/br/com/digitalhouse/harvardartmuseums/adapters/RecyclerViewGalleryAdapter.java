package br.com.digitalhouse.harvardartmuseums.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.data.database.Database;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.FavoritesDAO;
import br.com.digitalhouse.harvardartmuseums.interfaces.RecyclerViewGalleryClickListener;
import br.com.digitalhouse.harvardartmuseums.model.favorites.Favorites;
import br.com.digitalhouse.harvardartmuseums.model.object.Object;
import br.com.digitalhouse.harvardartmuseums.util.AppUtil;

public class RecyclerViewGalleryAdapter extends RecyclerView.Adapter<RecyclerViewGalleryAdapter.ViewHolder> {

    private List<Object> objectList;
    private RecyclerViewGalleryClickListener listener;
    private FragmentActivity activity;

    public RecyclerViewGalleryAdapter() {
    }

    public RecyclerViewGalleryAdapter(List<Object> objectList, RecyclerViewGalleryClickListener listener, FragmentActivity activity) {
        this.objectList = objectList;
        this.listener = listener;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerViewGalleryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_gallery_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewGalleryAdapter.ViewHolder viewHolder, int i) {
        final Object object = objectList.get(i);
        viewHolder.bind(object);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(object);
            }
        });

        //Cinco estrelas
        //***
        //Uma estrela
        viewHolder.imageViewGalleryStar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.imageViewGalleryStar1.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewGalleryStar2.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                viewHolder.imageViewGalleryStar3.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                viewHolder.imageViewGalleryStar4.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                viewHolder.imageViewGalleryStar5.setImageResource(R.drawable.ic_star_border_yellow_24dp);

                //Atualiza a quantidade de estrelas marcadas
                object.setCountStarsFavorites(1);

                //Atualiza a tabela de favoritos
                atualizaFavoritosUsuario(v.getContext(), object);
            }
        });

        //Duas estrelas
        viewHolder.imageViewGalleryStar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.imageViewGalleryStar1.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewGalleryStar2.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewGalleryStar3.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                viewHolder.imageViewGalleryStar4.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                viewHolder.imageViewGalleryStar5.setImageResource(R.drawable.ic_star_border_yellow_24dp);

                //Atualiza a quantidade de estrelas marcadas
                object.setCountStarsFavorites(2);

                //Atualiza a tabela de favoritos
                atualizaFavoritosUsuario(v.getContext(), object);
            }
        });

        //Tres estrelas
        viewHolder.imageViewGalleryStar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.imageViewGalleryStar1.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewGalleryStar2.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewGalleryStar3.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewGalleryStar4.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                viewHolder.imageViewGalleryStar5.setImageResource(R.drawable.ic_star_border_yellow_24dp);

                //Atualiza a quantidade de estrelas marcadas
                object.setCountStarsFavorites(3);

                //Atualiza a tabela de favoritos
                atualizaFavoritosUsuario(v.getContext(), object);
            }
        });

        //Quatro estrelas
        viewHolder.imageViewGalleryStar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.imageViewGalleryStar1.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewGalleryStar2.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewGalleryStar3.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewGalleryStar4.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewGalleryStar5.setImageResource(R.drawable.ic_star_border_yellow_24dp);

                //Atualiza a quantidade de estrelas marcadas
                object.setCountStarsFavorites(4);

                //Atualiza a tabela de favoritos
                atualizaFavoritosUsuario(v.getContext(), object);
            }
        });

        //Cinco estrelas
        viewHolder.imageViewGalleryStar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.imageViewGalleryStar1.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewGalleryStar2.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewGalleryStar3.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewGalleryStar4.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
                viewHolder.imageViewGalleryStar5.setImageResource(R.drawable.ic_star_fill_yellow_24dp);

                //Atualiza a quantidade de estrelas marcadas
                object.setCountStarsFavorites(5);

                //Atualiza a tabela de favoritos
                atualizaFavoritosUsuario(v.getContext(), object);
            }
        });

        //Compartilhamento
        viewHolder.imageViewGalleryShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Google Tradutor
        viewHolder.imageViewGalleryTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Tradução de texto
                try {

                    AppUtil.translateOut(viewHolder.textViewNomeObra, object.getTitle(), activity);
                    AppUtil.translateOut(viewHolder.textViewDescricaoObra, object.getVerificationleveldescription(), activity);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //Google Speak
        viewHolder.imageViewGallerySpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//Leitura de voz
                AppUtil.speakOut("Nome da Obra", viewHolder.textViewNomeObra.getText().toString(), v.getContext());
                AppUtil.speakOut("Descrição da Obra", viewHolder.textViewDescricaoObra.getText().toString(), v.getContext());
            }
        });

        //Favoritos
        viewHolder.imageViewGalleryFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Inverte opção do favoritos na tela
                object.setFavorite(!object.isFavorite());

                if (object.isFavorite()) {
                    viewHolder.imageViewGalleryFavorites.setImageResource(R.drawable.ic_favorite_red_24dp);
                } else {
                    viewHolder.imageViewGalleryFavorites.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                }

                //Atualiza a tabela de favoritos
                atualizaFavoritosUsuario(v.getContext(), object);
            }
        });
    }

    public void updateObject(List<Object> objectList) {
        this.objectList = objectList;

        notifyDataSetChanged();
    }

    public void addObject(List<Object> objectList, Context context) {
        this.objectList.addAll(objectList);

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewImagemObra;
        private TextView textViewNomeObra;
        private TextView textViewDescricaoObra;

        private ImageView imageViewGalleryStar1;
        private ImageView imageViewGalleryStar2;
        private ImageView imageViewGalleryStar3;
        private ImageView imageViewGalleryStar4;
        private ImageView imageViewGalleryStar5;
        private ImageView imageViewGalleryShare;
        private ImageView imageViewGalleryTranslate;
        private ImageView imageViewGallerySpeak;
        private ImageView imageViewGalleryFavorites;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewImagemObra = itemView.findViewById(R.id.imageViewImagemObra);
            textViewNomeObra = itemView.findViewById(R.id.textViewNomeObra);
            textViewDescricaoObra = itemView.findViewById(R.id.textViewDescricaoObra);
            imageViewGalleryStar1 = itemView.findViewById(R.id.imageViewGalleryStar1);
            imageViewGalleryStar2 = itemView.findViewById(R.id.imageViewGalleryStar2);
            imageViewGalleryStar3 = itemView.findViewById(R.id.imageViewGalleryStar3);
            imageViewGalleryStar4 = itemView.findViewById(R.id.imageViewGalleryStar4);
            imageViewGalleryStar5 = itemView.findViewById(R.id.imageViewGalleryStar5);
            imageViewGalleryShare = itemView.findViewById(R.id.imageViewGalleryShare);
            imageViewGalleryTranslate = itemView.findViewById(R.id.imageViewGalleryTranslate);
            imageViewGallerySpeak = itemView.findViewById(R.id.imageViewGallerySpeak);
            imageViewGalleryFavorites = itemView.findViewById(R.id.imageViewGalleryFavorites);

        }

        public void bind(Object object) {

            textViewNomeObra.setText(object.getObjectnumber() + " - " + object.getTitle());
            textViewDescricaoObra.setText(object.getVerificationleveldescription());

            if (object.getPrimaryimageurl() != null) {
                Picasso.get().setIndicatorsEnabled(true);
                Picasso.get()
                        .load(object.getPrimaryimageurl())
                        .error(R.drawable.image_logo_center)
                        .placeholder(R.drawable.image_logo_center)
                        .into(imageViewImagemObra);
            }

            //Favoritos
            if (object.isFavorite()) {
                imageViewGalleryFavorites.setImageResource(R.drawable.ic_favorite_red_24dp);
            } else {
                imageViewGalleryFavorites.setImageResource(R.drawable.ic_favorite_border_black_24dp);
            }

            //Quantidade de estrelas marcadas anteiormente
            if (object.getCountStarsFavorites() >= 1) {
                imageViewGalleryStar1.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
            } else {
                imageViewGalleryStar1.setImageResource(R.drawable.ic_star_border_yellow_24dp);
            }

            if (object.getCountStarsFavorites() >= 2) {
                imageViewGalleryStar2.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
            } else {
                imageViewGalleryStar2.setImageResource(R.drawable.ic_star_border_yellow_24dp);
            }

            if (object.getCountStarsFavorites() >= 3) {
                imageViewGalleryStar3.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
            } else {
                imageViewGalleryStar3.setImageResource(R.drawable.ic_star_border_yellow_24dp);
            }

            if (object.getCountStarsFavorites() >= 4) {
                imageViewGalleryStar4.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
            } else {
                imageViewGalleryStar4.setImageResource(R.drawable.ic_star_border_yellow_24dp);
            }

            if (object.getCountStarsFavorites() >= 5) {
                imageViewGalleryStar5.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
            } else {
                imageViewGalleryStar5.setImageResource(R.drawable.ic_star_border_yellow_24dp);
            }

        }

    }

    public void atualizaFavoritosUsuario(Context context, Object objectFavorites) {

        /*FavoritesDAO dao = Database.getDatabase(context).favoritesDAO();

        new Thread(() -> {

            if (objectFavorites.getLoginUser() == null) {
                objectFavorites.setLoginUser("");
            }

            dao.deleteByUserObjectId(objectFavorites.getLoginUser(), objectFavorites.getObjectid());
            dao.insert(new Favorites(objectFavorites));

        }).start();
        */

        //Atualiza favoritos do usuário no Firebase
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usuarioReference = databaseReference.child("tab_usuarios");

        usuarioReference
                .child("usuario") //.child(objectFavorites.getLoginUser())
                .child("favoritos")
                .child(objectFavorites.getObjectid().toString())
                .setValue(new Favorites(objectFavorites));

    }
}