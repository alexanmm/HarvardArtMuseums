package br.com.digitalhouse.harvardartmuseums.fragments.art;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.model.Obra;

public class HistoryFragment extends Fragment {

    private static final String OBRA = "obra";
    private Obra obra;

    public HistoryFragment() {
        // Required empty public constructor
    }

    public static HistoryFragment newInstance(Obra obra) {
        Bundle args = new Bundle();
        args.putParcelable(OBRA, obra);

        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        obra = getArguments().getParcelable(OBRA);
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        TextView titulo = view.findViewById(R.id.textViewIdentification);
        titulo.setText(obra.getNomeObra());

        return view;
    }

}
