package br.com.digitalhouse.harvardartmuseums.fragments.art;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.adapters.ViewPageAdapter;
import br.com.digitalhouse.harvardartmuseums.model.Obra;

public class ArtDetailFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager vpConteudo;
    private ViewPageAdapter adapter;
    private ArrayList<Fragment> arrayFragmentos;
    private ArrayList<String> arrayTitulos;

    public ArtDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_art_detail, container, false);

        TextView textViewNomeObra = view.findViewById(R.id.textViewNomeObra);
        TextView textViewDescricaoObra = view.findViewById(R.id.textViewDescricaoObra);
        ImageView imageViewImagemObra = view.findViewById(R.id.imageViewImagemObra);

        //Parte superior do Fragmento
        if (getArguments() != null) {
            Obra obra = getArguments().getParcelable("OBRA");
            if (obra != null) {
                textViewNomeObra.setText(obra.getNomeObra());
                textViewDescricaoObra.setText(obra.getDescricaoObra());
                imageViewImagemObra.setImageDrawable(ContextCompat.getDrawable(imageViewImagemObra.getContext(), obra.getImagemObra()));
            }
        }

        //Parte inferior da Activity
        CarregarFragmentos();
        CarregarTitulos();
        viewPagerComTabLayout(view);

        return view;
    }

    private void CarregarFragmentos() {
        arrayFragmentos = new ArrayList<>();
        arrayFragmentos.add(new IdentificationFragment());
        arrayFragmentos.add(new DescriptionsFragment());
        arrayFragmentos.add(new HistoryFragment());
    }

    private void CarregarTitulos() {
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
