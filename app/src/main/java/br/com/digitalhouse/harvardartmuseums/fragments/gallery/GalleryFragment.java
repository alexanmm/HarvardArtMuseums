package br.com.digitalhouse.harvardartmuseums.fragments.gallery;

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

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.adapters.RecyclerViewGalleryAdapter;
import br.com.digitalhouse.harvardartmuseums.interfaces.Comunicator;
import br.com.digitalhouse.harvardartmuseums.interfaces.RecyclerViewGalleryClickListener;
import br.com.digitalhouse.harvardartmuseums.model.favorites.Favorites;
import br.com.digitalhouse.harvardartmuseums.model.gallery.Gallery;
import br.com.digitalhouse.harvardartmuseums.model.object.Object;
import br.com.digitalhouse.harvardartmuseums.model.userdata.UserData;
import br.com.digitalhouse.harvardartmuseums.viewmodel.GalleryViewModel;
import br.com.digitalhouse.harvardartmuseums.viewmodel.ObjectViewModel;

import static br.com.digitalhouse.harvardartmuseums.util.AppUtil.isNetworkConnected;

public class GalleryFragment extends Fragment implements RecyclerViewGalleryClickListener {

    private RecyclerView recyclerViewGallery;
    private RecyclerViewGalleryAdapter adapter;
    private Comunicator comunicator;

    private UserData userData = new UserData();

    private int pagina = 1; //Primeira página

    private GalleryViewModel galleryViewModel;
    private List<Gallery> galleryList = new ArrayList<>();

    private ObjectViewModel objectViewModel;
    private List<Object> objectList = new ArrayList<>();

    private String andar = "";

    public GalleryFragment() {
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
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        ProgressBar progressBar = view.findViewById(R.id.progressBar);

        //Inicializa as Views
        initViews(view);

        //Seleciona dinamicamente as obras conforme o andar
        if (getArguments() != null) {

            String andarNew = getArguments().getString("MESSAGE", "1");

            if (andarNew != andar) {
                andar = andarNew; //Atualiza o andar atual

                //Somente atualiza os dados da API quando o andar for modificado
                galleryViewModel.searchGallery(Integer.parseInt(andar), pagina);

                //Observable Loading
                galleryViewModel.getGalleryLoadingLiveData().observe(this, isLoading -> {
                    if (isLoading) {
                        progressBar.setVisibility(View.VISIBLE);
                    } else {
                        progressBar.setVisibility(View.GONE);
                    }
                });

                galleryViewModel.getGalleryLiveData().observe(this, galleryListLocal -> {

                    objectViewModel.searchObject(galleryListLocal);

                });

                //Observable Error
                galleryViewModel.getGalleryErrorLiveData().observe(this, throwable -> {
                    Snackbar.make(recyclerViewGallery, throwable.getMessage(), Snackbar.LENGTH_SHORT).show();
                });

                //Adiciona os observables
                objectViewModel.getObjectLiveData().observe(this, objectListLocal -> {

                    adapter.addObject(objectListLocal, getContext());

                    // *** Favoritos ***
                    //Instancia do firebase
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

                    //Referencia
                    DatabaseReference usuarioReference = databaseReference.child("tab_usuarios").child(userData.getUser().getUid());

                    //Verifica se há favoritos para os itens
                    for (Object objectLine: objectListLocal){

                        DatabaseReference objectReference = usuarioReference.child("favoritos").child(objectLine.getObjectid().toString());

                        //Adiciona o listener para buscar o objeto gravado em favoritos
                        objectReference.orderByKey().addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                Favorites favoritesLocal = dataSnapshot.getValue(Favorites.class);

                                if (favoritesLocal != null && favoritesLocal.getObjectGallery().getObjectid() != null){
                                    adapter.modifyObject(favoritesLocal.getObjectGallery(), getContext());
                                }

                            }

                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }

                });

                //Observable Error
                objectViewModel.getErrorLiveData().observe(this, throwable -> {
                    Snackbar.make(recyclerViewGallery, throwable.getMessage(), Snackbar.LENGTH_SHORT).show();
                });
            }
        }

        return view;
    }

    public void initViews(View view) {

        recyclerViewGallery = view.findViewById(R.id.galleryRecyclerViewer);

        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        objectViewModel = ViewModelProviders.of(this).get(ObjectViewModel.class);
        adapter = new RecyclerViewGalleryAdapter(objectList, this, getActivity());

        recyclerViewGallery.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerViewGallery.setAdapter(adapter);

        setScrollListener();
    }

    @Override
    public void onClick(Object object) {

        comunicator.sendArtToFragments(object);

    }

    private void setScrollListener() {

        recyclerViewGallery.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                //Somente atualizar a paginação se estiver Conectado na Internet
                if (isNetworkConnected(getActivity().getApplication())) {

                    LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    int totalItemCount = manager.getItemCount();
                    int lastVisible = manager.findLastVisibleItemPosition();

                    boolean fimFoiEncontrado = lastVisible + 5 >= totalItemCount;

                    if (totalItemCount > 0 && fimFoiEncontrado) {
                        pagina++;
                        galleryViewModel.searchGallery(Integer.parseInt(andar), pagina);
                    }
                }
            }
        });
    }

}
