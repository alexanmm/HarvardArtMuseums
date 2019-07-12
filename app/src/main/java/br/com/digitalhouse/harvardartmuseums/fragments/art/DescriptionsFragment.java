package br.com.digitalhouse.harvardartmuseums.fragments.art;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.digitalhouse.harvardartmuseums.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionsFragment extends Fragment {

    private View convertView;

    public DescriptionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (convertView == null){
            convertView = inflater.inflate(R.layout.fragment_descriptions, container, false);
        }

        return convertView;
    }

}
