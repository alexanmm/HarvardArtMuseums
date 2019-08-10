package br.com.digitalhouse.harvardartmuseums.fragments.information;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.harvardartmuseums.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {

    private TextView textViewTopMessageChoose;
    private ImageView imageViewTopMessage;

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info, container, false);

        //Inicializa Views
        initViews(view);

        textViewTopMessageChoose.setText("Each click is an opportunity to interact with us!");
        imageViewTopMessage.setImageDrawable(getResources().getDrawable(R.drawable.personagem07));

        return view;
    }

    public void initViews(View view) {

        textViewTopMessageChoose = view.findViewById(R.id.textViewTopMessageChoose);
        imageViewTopMessage = view.findViewById(R.id.imageViewTopMessage);

    }
}