package br.com.digitalhouse.harvardartmuseums.fragments.favorites;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.adapters.RecyclerViewFavoritesAdapter;
import br.com.digitalhouse.harvardartmuseums.interfaces.Comunicator;
import br.com.digitalhouse.harvardartmuseums.interfaces.RecyclerViewFavoritesClickListener;
import br.com.digitalhouse.harvardartmuseums.model.favorites.Favorites;
import br.com.digitalhouse.harvardartmuseums.model.userdata.UserData;
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

        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        ProgressBar progressBar = view.findViewById(R.id.progressBar);

        //Inicializa as Views
        initViews(view);

        //Instancia do firebase
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        //Referencia
        UserData userData = new UserData();

        DatabaseReference usuarioReference = databaseReference.child("tab_usuarios").child(userData.getUser().getUid());
        DatabaseReference favoritosReference = usuarioReference.child("favoritos");

        //Adicionamos o loistener par pegar os resultados do firebase
        favoritosReference.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //Lista vazia pra pegar os resultados do firebase
                List<Favorites> favoritesList = new ArrayList<>();

                //Após receber os dados, os memos serão adicionados para atualização do Adapter
                for (DataSnapshot resultSnapshot : dataSnapshot.getChildren()) {

                    Favorites favoritesLocal = resultSnapshot.getValue(Favorites.class);

                    //Somente exibe os favoritos marcados
                    if (favoritesLocal.getObjectGallery().isFavorite()){
                        //Acrescenta o registro na lista de favoritos
                        favoritesList.add(favoritesLocal);
                    }
                }

                //Atualiza o Adapter para exibição da lista de favoritos a partir do Firebase
                adapter.updateFavorites(favoritesList);
            }

            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

/* Comentada a chamada do Bando de Dados local para utilização do Firebase
        //Somente atualiza os dados dos Favoritos
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
*/

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

    @Override
    public void removeFavoriteClickListener(Favorites favorites) {

    }
}
