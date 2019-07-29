package br.com.digitalhouse.harvardartmuseums.fragments.art;


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
import br.com.digitalhouse.harvardartmuseums.model.object.Object;

public class ArtDetailFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager vpConteudo;
    private ViewPageAdapter adapter;
    private ArrayList<Fragment> arrayFragmentos;
    private ArrayList<String> arrayTitulos;
    private Object object;

    public ArtDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_art_detail, container, false);

        TextView textViewNomeObra = view.findViewById(R.id.textViewNomeObra);
        TextView textViewDescricaoObra = view.findViewById(R.id.textViewDescricaoObra);
        ImageView imageViewImagemObra = view.findViewById(R.id.imageViewImagemObra);
        final ImageView imageViewFavorite = view.findViewById(R.id.imageViewFavorite);

        //Parte superior do Fragmento
        if (getArguments() != null) {
            object = getArguments().getParcelable("OBRA");
            if (object != null) {

                textViewNomeObra.setText(object.getTitle());
                textViewDescricaoObra.setText(object.getVerificationleveldescription());

                if (object.getPrimaryimageurl() != null) {
                    Picasso.get().setIndicatorsEnabled(true);
                    Picasso.get()
                            .load(object.getPrimaryimageurl())
                            .error(R.mipmap.ic_launcher)
                            .placeholder(R.mipmap.ic_launcher)
                            .into(imageViewImagemObra);
                }

                if (object.isFavorite()) {
                    imageViewFavorite.setImageDrawable(ContextCompat.getDrawable(imageViewFavorite.getContext(), R.drawable.ic_favorite_red_24dp));
                }

                imageViewFavorite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Se for favoirito muda a imagem
                        if (object.isFavorite()) {
                            imageViewFavorite.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                        } else {
                            imageViewFavorite.setImageResource(R.drawable.ic_favorite_red_24dp);
                        }

                        // configura um novo valor para o favorito
                        object.setFavorite(!object.isFavorite());
                    }
                });
            }
        }

        //Parte inferior da Activity
        inicializaDetalhesObra();
        viewPagerComTabLayout(view);

        return view;
    }

    private void inicializaDetalhesObra() {
        arrayFragmentos = new ArrayList<>();
        arrayFragmentos.add(IdentificationFragment.newInstance(object));
        arrayFragmentos.add(DescriptionsFragment.newInstance(object));
        arrayFragmentos.add(HistoryFragment.newInstance(object));

        arrayTitulos = new ArrayList<>();
        arrayTitulos.add("Identification");
        arrayTitulos.add("Descriptions");
        arrayTitulos.add("History");

    }

    private void viewPagerComTabLayout(View view) {
        tabLayout = view.findViewById(R.id.tlTab);
        vpConteudo = view.findViewById(R.id.vpConteudo);
        adapter = new ViewPageAdapter(getChildFragmentManager(), arrayFragmentos, arrayTitulos);
        vpConteudo.setAdapter(adapter);
        tabLayout.setupWithViewPager(vpConteudo);
    }

}
