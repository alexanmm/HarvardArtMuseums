package br.com.digitalhouse.harvardartmuseums.fragments.home.galeria.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.digitalhouse.harvardartmuseums.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ObraFragment extends Fragment {


    public ObraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_obra, container, false);
    }

}
