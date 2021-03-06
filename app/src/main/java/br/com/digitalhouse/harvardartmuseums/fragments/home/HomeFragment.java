package br.com.digitalhouse.harvardartmuseums.fragments.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.interfaces.Comunicator;
import br.com.digitalhouse.harvardartmuseums.model.userdata.UserData;

public class HomeFragment extends Fragment {

    private Comunicator comunicator;

    private TextView textViewTopMessageChoose;
    private ImageView imageViewTopMessage;

    private ImageView subsolo;
    private ImageView andar1;
    private ImageView andar2;
    private ImageView andar3;
    private ImageView andar4;
    private ImageView andar5;

    public HomeFragment() {
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

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Inicializa Views
        initViews(view);

        textViewTopMessageChoose.setText("Choose a floor to visit the Gallery");
        imageViewTopMessage.setImageDrawable(getResources().getDrawable(R.drawable.personagem04));

        subsolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comunicator.sendMessageToFragments("0");
            }
        });
        andar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comunicator.sendMessageToFragments("1");
            }
        });
        andar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comunicator.sendMessageToFragments("2");
            }
        });
        andar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comunicator.sendMessageToFragments("3");
            }
        });
        andar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comunicator.sendMessageToFragments("4");
            }
        });
        andar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comunicator.sendMessageToFragments("5");
            }
        });

        return view;
    }

    private void initViews(View view) {

        textViewTopMessageChoose = view.findViewById(R.id.textViewTopMessageChoose);
        imageViewTopMessage = view.findViewById(R.id.imageViewTopMessage);

        subsolo = view.findViewById(R.id.imageViewAndarSS);
        andar1 = view.findViewById(R.id.imageViewAndar1);
        andar2 = view.findViewById(R.id.imageViewAndar2);
        andar3 = view.findViewById(R.id.imageViewAndar3);
        andar4 = view.findViewById(R.id.imageViewAndar4);
        andar5 = view.findViewById(R.id.imageViewAndar5);

    }

}
