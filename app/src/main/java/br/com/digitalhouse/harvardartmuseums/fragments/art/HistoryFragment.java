package br.com.digitalhouse.harvardartmuseums.fragments.art;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.model.object.Object;
import br.com.digitalhouse.harvardartmuseums.util.AppUtil;

public class HistoryFragment extends Fragment {

    private static final String OBRA = "obra";
    private Object object;

    private TextView textViewHistoryTitle;
    private TextView textViewHistoryCentury;
    private TextView textViewHistoryDated;
    private TextView textViewHistoryPeriod;
    private TextView textViewHistoryExhibitioncount;
    private TextView textViewHistoryDatebegin;
    private TextView textViewHistoryDateend;
    private TextView textViewHistoryContact;

    public HistoryFragment() {
        // Required empty public constructor
    }

    public static HistoryFragment newInstance(Object object) {
        Bundle args = new Bundle();
        args.putParcelable(OBRA, object);

        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        object = getArguments().getParcelable(OBRA);
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        try {
            textViewHistoryTitle = view.findViewById(R.id.textViewHistoryTitle);
            textViewHistoryCentury = view.findViewById(R.id.textViewHistoryCentury);
            textViewHistoryDated = view.findViewById(R.id.textViewHistoryDated);
            textViewHistoryPeriod = view.findViewById(R.id.textViewHistoryPeriod);
            textViewHistoryExhibitioncount = view.findViewById(R.id.textViewHistoryExhibitioncount);
            textViewHistoryDatebegin = view.findViewById(R.id.textViewHistoryDatebegin);
            textViewHistoryDateend = view.findViewById(R.id.textViewHistoryDateend);
            textViewHistoryContact = view.findViewById(R.id.textViewHistoryContact);

            textViewHistoryCentury.setText("Century: " + AppUtil.convString(object.getCentury()));
            textViewHistoryDated.setText("Dated: " + AppUtil.convString(object.getDated()));
            textViewHistoryPeriod.setText("Period: " + AppUtil.convString(object.getPeriod()));
            textViewHistoryExhibitioncount.setText("Exhibition count: " + AppUtil.convString(object.getExhibitioncount()));
            textViewHistoryDatebegin.setText("Date begin: " + AppUtil.convString(object.getDatebegin()));
            textViewHistoryDateend.setText("Date end: " + AppUtil.convString(object.getDateend()));
            textViewHistoryContact.setText("Contact: " + AppUtil.convString(object.getContact()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return view;
    }

}