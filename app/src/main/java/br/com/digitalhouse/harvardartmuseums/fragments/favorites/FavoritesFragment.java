package br.com.digitalhouse.harvardartmuseums.fragments.favorites;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.adapters.RecyclerViewFavoritesAdapter;
import br.com.digitalhouse.harvardartmuseums.interfaces.Comunicator;
import br.com.digitalhouse.harvardartmuseums.interfaces.RecyclerViewFavoritesClickListener;
import br.com.digitalhouse.harvardartmuseums.model.favorites.Favorites;
import br.com.digitalhouse.harvardartmuseums.viewmodel.FavoritesViewModel;

public class FavoritesFragment extends Fragment implements RecyclerViewFavoritesClickListener {

    private RecyclerView recyclerViewFavorites;
    private RecyclerViewFavoritesAdapter adapter;
    private Comunicator comunicator;

    private FavoritesViewModel favoritesViewModel;
    private List<Favorites> favoritesList = new ArrayList<>();

    public FavoritesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            comunicator = (Comunicator) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        ProgressBar progressBar = view.findViewById(R.id.progressBar);

        //Inicializa as Views
        initViews(view);

        //Somente atualiza os dados dos Fsvoritos
        favoritesViewModel.searchFavorites();

        //Observable Loading
        favoritesViewModel.getFavoritesLoadingLiveData().observe(this, isLoading -> {
            if (isLoading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

        favoritesViewModel.getFavoritesLiveData().observe(this, favoritesListLocal -> {

            adapter.updateFavorites(favoritesListLocal);

        });

        //Observable Error
        favoritesViewModel.getFavoritesErrorLiveData().observe(this, throwable -> {
            Snackbar.make(recyclerViewFavorites, throwable.getMessage(), Snackbar.LENGTH_SHORT).show();
        });

        return view;
    }

    public void initViews(View view) {

        recyclerViewFavorites = view.findViewById(R.id.recyclerViewFavorites);

        favoritesViewModel = ViewModelProviders.of(this).get(FavoritesViewModel.class);
        adapter = new RecyclerViewFavoritesAdapter(favoritesList, this);

        recyclerViewFavorites.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerViewFavorites.setAdapter(adapter);

    }

    @Override
    public void onClick(Favorites favorites) {
        //comunicator.sendArtToFragments(favorites);
    }
}
