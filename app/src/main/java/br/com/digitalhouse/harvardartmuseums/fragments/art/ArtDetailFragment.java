package br.com.digitalhouse.harvardartmuseums.fragments.art;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.adapters.ViewPageAdapter;
import br.com.digitalhouse.harvardartmuseums.data.database.Database;
import br.com.digitalhouse.harvardartmuseums.data.database.dao.FavoritesDAO;
import br.com.digitalhouse.harvardartmuseums.model.favorites.Favorites;
import br.com.digitalhouse.harvardartmuseums.model.object.Object;
import br.com.digitalhouse.harvardartmuseums.util.AppUtil;

public class ArtDetailFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager vpConteudo;
    private ViewPageAdapter adapter;
    private ArrayList<Fragment> arrayFragmentos;
    private ArrayList<String> arrayTitulos;
    private Object object;

    private TextView textViewDetailNomeObra;
    private TextView textViewDetailDescricaoObra;
    private ImageView imageViewDetailImagemObra;
    private ImageView imageViewDetailStar1;
    private ImageView imageViewDetailStar2;
    private ImageView imageViewDetailStar3;
    private ImageView imageViewDetailStar4;
    private ImageView imageViewDetailStar5;
    private ImageView imageViewDetailShare;
    private ImageView imageViewDetailTranslate;
    private ImageView imageViewDetailSpeak;
    private ImageView imageViewDetailFavorites;

    public ArtDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_art_detail, container, false);

        //Inicializa Views
        initViews(view);

        //Parte superior do Fragmento
        if (getArguments() != null) {
            object = getArguments().getParcelable("OBRA");
            if (object != null) {

                textViewDetailNomeObra.setText(object.getTitle());
                textViewDetailDescricaoObra.setText(object.getVerificationleveldescription());

                if (object.getPrimaryimageurl() != null) {
                    Picasso.get().setIndicatorsEnabled(true);
                    Picasso.get()
                            .load(object.getPrimaryimageurl())
                            .error(R.drawable.image_logo_center)
                            .placeholder(R.drawable.image_logo_center)
                            .into(imageViewDetailImagemObra);
                }

                if (object.isFavorite()) {
                    imageViewDetailFavorites.setImageDrawable(ContextCompat.getDrawable(imageViewDetailFavorites.getContext(), R.drawable.ic_favorite_red_24dp));
                }

                imageViewDetailFavorites.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Se for favorito muda a imagem
                        if (object.isFavorite()) {
                            imageViewDetailFavorites.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                        } else {
                            imageViewDetailFavorites.setImageResource(R.drawable.ic_favorite_red_24dp);
                        }

                        // configura um novo valor para o favorito
                        object.setFavorite(!object.isFavorite());

                        //Atualiza tabela de favoritos
                        atualizaFavoritosUsuario(getActivity().getApplicationContext(), object);
                    }
                });
            }
        }

        imageViewDetailStar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Atualiza as estrelas na tela
                updateStars(1);
            }
        });

        imageViewDetailStar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Atualiza as estrelas na tela
                updateStars(2);
            }
        });

        imageViewDetailStar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Atualiza as estrelas na tela
                updateStars(3);
            }
        });

        imageViewDetailStar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Atualiza as estrelas na tela
                updateStars(4);
            }
        });

        imageViewDetailStar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Atualiza as estrelas na tela
                updateStars(5);
            }
        });

        imageViewDetailShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Tradução do Texto da tela
        imageViewDetailTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Tradução de texto
                try {

                    AppUtil.translateOut(textViewDetailNomeObra, object.getTitle(), getActivity());
                    AppUtil.translateOut(textViewDetailDescricaoObra, object.getVerificationleveldescription(), getActivity());

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        //Leitura de Voz
        imageViewDetailSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Leitura de voz
                AppUtil.speakOut("Nome da Obra", textViewDetailNomeObra.getText().toString(), v.getContext());
                AppUtil.speakOut("Descrição da Obra", textViewDetailDescricaoObra.getText().toString(), v.getContext());

            }
        });

        //Atualiza dados dos favoritos gravados anteriormente
        buscaFavoritosUsuario(getActivity().getApplicationContext(), object);

        //Parte inferior da Activity
        viewPagerComTabLayout(view);

        return view;
    }

    private void initViews(View view) {

        textViewDetailNomeObra = view.findViewById(R.id.textViewDetailNomeObra);
        textViewDetailDescricaoObra = view.findViewById(R.id.textViewDetailDescricaoObra);
        imageViewDetailImagemObra = view.findViewById(R.id.imageViewDetailImagemObra);
        imageViewDetailStar1 = view.findViewById(R.id.imageViewDetailStar1);
        imageViewDetailStar2 = view.findViewById(R.id.imageViewDetailStar2);
        imageViewDetailStar3 = view.findViewById(R.id.imageViewDetailStar3);
        imageViewDetailStar4 = view.findViewById(R.id.imageViewDetailStar4);
        imageViewDetailStar5 = view.findViewById(R.id.imageViewDetailStar5);
        imageViewDetailShare = view.findViewById(R.id.imageViewDetailShare);
        imageViewDetailTranslate = view.findViewById(R.id.imageViewDetailTranslate);
        imageViewDetailSpeak = view.findViewById(R.id.imageViewDetailSpeak);
        imageViewDetailFavorites = view.findViewById(R.id.imageViewDetailFavorites);

    }

    private void viewPagerComTabLayout(View view) {

        arrayFragmentos = new ArrayList<>();
        arrayFragmentos.add(IdentificationFragment.newInstance(object));
        arrayFragmentos.add(DescriptionsFragment.newInstance(object));
        arrayFragmentos.add(HistoryFragment.newInstance(object));

        arrayTitulos = new ArrayList<>();
        arrayTitulos.add("Identification");
        arrayTitulos.add("Descriptions");
        arrayTitulos.add("History");

        tabLayout = view.findViewById(R.id.tlTab);
        vpConteudo = view.findViewById(R.id.vpConteudo);
        adapter = new ViewPageAdapter(getChildFragmentManager(), arrayFragmentos, arrayTitulos);
        vpConteudo.setAdapter(adapter);
        tabLayout.setupWithViewPager(vpConteudo);
    }

    public void atualizaFavoritosUsuario(Context context, Object objectFavorites) {

        FavoritesDAO dao = Database.getDatabase(context).favoritesDAO();

        new Thread(() -> {

            if (objectFavorites.getLoginUser() == null) {
                objectFavorites.setLoginUser("");
            }

            dao.deleteByUserObjectId(objectFavorites.getLoginUser(), objectFavorites.getObjectid());
            dao.insert(new Favorites(objectFavorites));
        }).start();
    }

    public void updateStars(int starCount) {

        // configura um novo valor para o favorito
        object.setCountStarsFavorites(starCount);

        if (starCount >= 1) {
            imageViewDetailStar1.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
        } else {
            imageViewDetailStar1.setImageResource(R.drawable.ic_star_border_yellow_24dp);
        }

        if (starCount >= 2) {
            imageViewDetailStar2.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
        } else {
            imageViewDetailStar2.setImageResource(R.drawable.ic_star_border_yellow_24dp);
        }

        if (starCount >= 3) {
            imageViewDetailStar3.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
        } else {
            imageViewDetailStar3.setImageResource(R.drawable.ic_star_border_yellow_24dp);
        }

        if (starCount >= 4) {
            imageViewDetailStar4.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
        } else {
            imageViewDetailStar4.setImageResource(R.drawable.ic_star_border_yellow_24dp);
        }

        if (starCount >= 5) {
            imageViewDetailStar5.setImageResource(R.drawable.ic_star_fill_yellow_24dp);
        } else {
            imageViewDetailStar5.setImageResource(R.drawable.ic_star_border_yellow_24dp);
        }

        //Atualiza tabela de favoritos
        atualizaFavoritosUsuario(getActivity().getApplicationContext(), object);
    }

    public void buscaFavoritosUsuario(Context context, Object objectFavorites) {

        FavoritesDAO dao = Database.getDatabase(context).favoritesDAO();

        new Thread(() -> {

            if (objectFavorites.getLoginUser() == null) {
                objectFavorites.setLoginUser("");
            }

            Favorites favoritesLocal = dao.getFavoritesByUserObjectId(objectFavorites.getLoginUser(), objectFavorites.getObjectid());

            if (favoritesLocal != null) {
                //Atualiza na tela o numero de estrelas
                updateStars(favoritesLocal.getObjectGallery().getCountStarsFavorites());
            }


        }).start();
    }
}