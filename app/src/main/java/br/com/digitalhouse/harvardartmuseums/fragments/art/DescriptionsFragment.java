package br.com.digitalhouse.harvardartmuseums.fragments.art;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.model.Obra;

public class DescriptionsFragment extends Fragment {

    private static final String OBRA = "obra";
    private Obra obra;

    public DescriptionsFragment() {
        // Required empty public constructor
    }

    public static DescriptionsFragment newInstance(Obra obra) {

        Bundle args = new Bundle();
        args.putParcelable(OBRA, obra);

        DescriptionsFragment fragment = new DescriptionsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        obra = getArguments().getParcelable(OBRA);
        View view = inflater.inflate(R.layout.fragment_descriptions, container, false);

        TextView titulo = view.findViewById(R.id.textViewIdentification);
        titulo.setText(obra.getDescricaoObra());

        return view;
    }
}
