package br.com.digitalhouse.harvardartmuseums.fragments.favorite;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.adapters.RecyclerViewFavoriteAdapter;
import br.com.digitalhouse.harvardartmuseums.interfaces.Comunicator;
import br.com.digitalhouse.harvardartmuseums.interfaces.RecyclerViewFavoriteClickListener;
import br.com.digitalhouse.harvardartmuseums.model.Obra;

public class FavoriteFragment extends Fragment implements RecyclerViewFavoriteClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewFavoriteAdapter adapter;
    private Comunicator comunicator;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            comunicator = (Comunicator) context;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        recyclerView = view.findViewById(R.id.favoriteRecyclerViewer);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new RecyclerViewFavoriteAdapter(listaObrasFavoritadas(), this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Obra> listaObrasFavoritadas() {
        List<Obra> obras = new ArrayList<>();
        List<Obra> obrasFavorties = new ArrayList<>();
        obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture", "0", true));
        obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture", "0", false));
        obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture", "0", false));
        obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture", "0", false));
        obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture", "0", false));
        obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table", "1", true));
        obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table", "1", false));
        obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table", "1", false));
        obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table", "1", false));
        obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table", "1", false));
        obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall", "2", true));
        obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall", "2", false));
        obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall", "2", false));
        obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall", "2", false));
        obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall", "2", false));
        obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball", "3", true));
        obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball", "3", false));
        obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball", "3", false));
        obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball", "3", false));
        obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball", "3", false));
        obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call", "4", true));
        obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call", "4", false));
        obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call", "4", false));
        obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call", "4", false));
        obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call", "4", false));
        obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose", "5", true));
        obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose", "5", false));
        obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose", "5", false));
        obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose", "5", false));
        obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose", "5", false));
        //Seleciona apenas as obras que estão marcadas como favoritas
        for (int i=0; i<obras.size();i++){
            if (obras.get(i).isFavorite()){
                obrasFavorties.add(obras.get(i));
            }
        }
        return obrasFavorties;
    }

    @Override
    public void onClick(Obra obra) {
            comunicator.sendArtToFragments(obra);
    }
}
