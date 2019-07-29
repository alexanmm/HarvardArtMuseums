package br.com.digitalhouse.harvardartmuseums.fragments.game;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.fragments.art.ArtDetailFragment;
import br.com.digitalhouse.harvardartmuseums.interfaces.Comunicator;
import br.com.digitalhouse.harvardartmuseums.model.object.Object;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    private Comunicator comunicator;

    private TextView textViewTopMessageChoose;
    private ImageView imageViewTopMessage;
    private Button buttonGamePlay;
    private Button buttonGameSettings;
    private Button buttonGameExit;

    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game, container, false);

        //Inicializa Views
        initViews(view);

        textViewTopMessageChoose.setText("Uhu, teste your memory! \nClick in 'Play' to start the game...");
        imageViewTopMessage.setImageDrawable(getResources().getDrawable(R.drawable.personagem06));

        buttonGamePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                comunicator.sendGameToPlayFragments();
            }
        });

        buttonGameSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        buttonGameExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
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

    public void initViews(View view) {

        textViewTopMessageChoose = view.findViewById(R.id.textViewTopMessageChoose);
        imageViewTopMessage = view.findViewById(R.id.imageViewTopMessage);

        buttonGamePlay = view.findViewById(R.id.buttonGamePlay);
        buttonGameSettings = view.findViewById(R.id.buttonGameSettings);
        buttonGameExit = view.findViewById(R.id.buttonGameExit);

    }
}
