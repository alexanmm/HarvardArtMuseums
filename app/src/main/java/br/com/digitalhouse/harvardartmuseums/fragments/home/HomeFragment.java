package br.com.digitalhouse.harvardartmuseums.fragments.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.view.base.BaseActivity;

public class HomeFragment extends Fragment {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView subsolo = view.findViewById(R.id.imageViewAndarSS);
        ImageView andar1 = view.findViewById(R.id.imageViewAndar1);
        ImageView andar2 = view.findViewById(R.id.imageViewAndar2);
        ImageView andar3 = view.findViewById(R.id.imageViewAndar3);
        ImageView andar4 = view.findViewById(R.id.imageViewAndar4);
        ImageView andar5 = view.findViewById(R.id.imageViewAndar5);

/*        subsolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity) getActivity()).replaceFragment();
            }
        });
        andar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment("1");
            }
        });
        andar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment("2");
            }
        });
        andar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment("3");
            }
        });
        andar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment("4");
            }
        });
        andar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment("5");
            }
        });*/

        return view;
    }

 /*   private void AndarOnClick(String andarEscolhido) {
        Intent intent = new Intent(Home.this, SplashActivityLevel.class);
        CriaBunble(intent,andarEscolhido);
        startActivity(intent);
    }

    //Troca os fragmentos do container
    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack("FRAGMENTS")
                .commit();
    }

    private void CriaBunble(Intent intent,String numeroAndar) {
        Bundle bundle = new Bundle();
        bundle.putString("ANDAR", numeroAndar);
        intent.putExtras(bundle);
    }*/

}
