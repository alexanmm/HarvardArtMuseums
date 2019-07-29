package br.com.digitalhouse.harvardartmuseums.fragments.exhibition;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.adapters.RecyclerViewExhibitionAdapter;
import br.com.digitalhouse.harvardartmuseums.interfaces.Comunicator;
import br.com.digitalhouse.harvardartmuseums.interfaces.RecyclerViewExhibitionClickListener;
import br.com.digitalhouse.harvardartmuseums.model.exhibition.Exhibition;
import br.com.digitalhouse.harvardartmuseums.viewmodel.ExhibitionViewModel;

import static br.com.digitalhouse.harvardartmuseums.util.AppUtil.isNetworkConnected;

public class ExhibitionFragment extends Fragment implements RecyclerViewExhibitionClickListener {

    private RecyclerView recyclerViewExhibition;
    private RecyclerViewExhibitionAdapter adapter;
    private Comunicator comunicator;

    private ExhibitionViewModel exhibitionViewModel;
    private List<Exhibition> exhibitionList = new ArrayList<>();

    private int pagina = 1; //Primeira página
    private int size = 10;

    private TextView textViewExhibitionBeginDate;
    private ImageView imageViewExhibitionTranslate;
    private ImageView imageViewExhibitionSound;
    private ImageView imageViewExhibitionAddCalendar;
    private TextView textViewExhibitionTitle;
    private TextView textViewExhibitionPeopleDisplayName;
    private TextView textViewExhibitionEndDate;
    private TextView textViewExhibitionTexTileDescription;

    public ExhibitionFragment() {
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
        View view = inflater.inflate(R.layout.fragment_exhibition, container, false);

        ProgressBar progressBar = view.findViewById(R.id.progressBar);

        //Inicializa as Views
        initViews(view);

        //Somente atualiza os dados da API quando o andar for modificado
        exhibitionViewModel.searchExhibition(pagina, size);

        //Observable Loading
        exhibitionViewModel.getExhibitionLoadingLiveData().observe(this, isLoading -> {
            if (isLoading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

        exhibitionViewModel.getExhibitionLiveData().observe(this, exhibitionListLocal -> {

            adapter.update(exhibitionListLocal, getContext());

        });

        //Observable Error
        exhibitionViewModel.getExhibitionErrorLiveData().observe(this, throwable -> {
            Snackbar.make(recyclerViewExhibition, throwable.getMessage(), Snackbar.LENGTH_SHORT).show();
        });

        return view;
    }

    public void initViews(View view) {

        recyclerViewExhibition = view.findViewById(R.id.recyclerViewExhibition);

        exhibitionViewModel = ViewModelProviders.of(this).get(ExhibitionViewModel.class);
        adapter = new RecyclerViewExhibitionAdapter(exhibitionList, this);

        recyclerViewExhibition.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerViewExhibition.setAdapter(adapter);

        setScrollListener();

        textViewExhibitionBeginDate = view.findViewById(R.id.textViewExhibitionBeginDate);
        imageViewExhibitionTranslate = view.findViewById(R.id.imageViewExhibitionTranslate);
        imageViewExhibitionSound = view.findViewById(R.id.imageViewExhibitionSound);
        imageViewExhibitionAddCalendar = view.findViewById(R.id.imageViewExhibitionAddCalendar);
        textViewExhibitionTitle = view.findViewById(R.id.textViewExhibitionTitle);
        textViewExhibitionPeopleDisplayName = view.findViewById(R.id.textViewExhibitionPeopleDisplayName);
        textViewExhibitionEndDate = view.findViewById(R.id.textViewExhibitionEndDate);
        textViewExhibitionTexTileDescription = view.findViewById(R.id.textViewExhibitionTexTileDescription);
    }

    @Override
    public void onClick(Exhibition exhibition) {

    }

    private void setScrollListener() {

        recyclerViewExhibition.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
                        exhibitionViewModel.searchExhibition(pagina, size);
                    }
                }
            }
        });
    }

}

