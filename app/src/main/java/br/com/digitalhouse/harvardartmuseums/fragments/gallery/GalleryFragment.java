package br.com.digitalhouse.harvardartmuseums.fragments.gallery;

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
import br.com.digitalhouse.harvardartmuseums.adapters.RecyclerViewGalleryAdapter;
import br.com.digitalhouse.harvardartmuseums.interfaces.Comunicator;
import br.com.digitalhouse.harvardartmuseums.interfaces.RecyclerViewGalleryClickListener;
import br.com.digitalhouse.harvardartmuseums.model.Obra;

public class GalleryFragment extends Fragment implements RecyclerViewGalleryClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewGalleryAdapter adapter;
    private Comunicator comunicator;

    public GalleryFragment() {
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
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        recyclerView = view.findViewById(R.id.galleryRecyclerViewer);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        //Seleciona dinamicamente as obras conforme o andar
        if (getArguments() != null) {
            String andar = getArguments().getString("MESSAGE");
            if (andar != null) {
                adapter = new RecyclerViewGalleryAdapter(listaObras(andar), this);
            }
        }

        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Obra> listaObras(String andar) {
        List<Obra> obras = new ArrayList<>();
        switch (andar) {
            case "0":
                obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture", "0"));
                obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture", "0"));
                obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture", "0"));
                obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture", "0"));
                obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture", "0"));
                break;
            case "1":
                obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table", "1"));
                obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table", "1"));
                obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table", "1"));
                obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table", "1"));
                obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table", "1"));
                break;
            case "2":
                obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall", "2"));
                obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall", "2"));
                obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall", "2"));
                obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall", "2"));
                obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall", "2"));
                break;
            case "3":
                obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball", "3"));
                obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball", "3"));
                obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball", "3"));
                obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball", "3"));
                obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball", "3"));
                break;
            case "4":
                obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call", "4"));
                obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call", "4"));
                obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call", "4"));
                obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call", "4"));
                obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call", "4"));
                break;
            case "5":
                obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose", "5"));
                obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose", "5"));
                obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose", "5"));
                obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose", "5"));
                obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose", "5"));
                break;
        }
        return obras;
    }

    @Override
    public void onClick(Obra obra) {
        comunicator.sendArtToFragments(obra);
    }
}
