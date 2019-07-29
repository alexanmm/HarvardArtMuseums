package br.com.digitalhouse.harvardartmuseums.fragments.art;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.model.object.Object;
import br.com.digitalhouse.harvardartmuseums.util.AppUtil;

public class DescriptionsFragment extends Fragment {

    private static final String OBRA = "obra";
    private Object object;

    private TextView textViewDescriptionsTitle;
    private TextView textViewDescriptionsClassification;
    private TextView textViewDescriptionsMedium;
    private TextView textViewDescriptionsProvenance;
    private TextView textViewDescriptionsCulture;
    private TextView textViewDescriptionsDivision;
    private TextView textViewDescriptionsDepartment;
    private TextView textViewDescriptionsDimensions;

    public DescriptionsFragment() {
        // Required empty public constructor
    }

    public static DescriptionsFragment newInstance(Object object) {

        Bundle args = new Bundle();
        args.putParcelable(OBRA, object);

        DescriptionsFragment fragment = new DescriptionsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        object = getArguments().getParcelable(OBRA);
        View view = inflater.inflate(R.layout.fragment_descriptions, container, false);

        try {

            textViewDescriptionsTitle = view.findViewById(R.id.textViewDescriptionsTitle);
            textViewDescriptionsClassification = view.findViewById(R.id.textViewDescriptionsClassification);
            textViewDescriptionsMedium = view.findViewById(R.id.textViewDescriptionsMedium);
            textViewDescriptionsProvenance = view.findViewById(R.id.textViewDescriptionsProvenance);
            textViewDescriptionsCulture = view.findViewById(R.id.textViewDescriptionsCulture);
            textViewDescriptionsDivision = view.findViewById(R.id.textViewDescriptionsDivision);
            textViewDescriptionsDepartment = view.findViewById(R.id.textViewDescriptionsDepartment);
            textViewDescriptionsDimensions = view.findViewById(R.id.textViewDescriptionsDimensions);

            textViewDescriptionsClassification.setText("Classification: " + AppUtil.convString(object.getClassification()));
            textViewDescriptionsMedium.setText("Medium: " + AppUtil.convString(object.getMedium()));
            textViewDescriptionsProvenance.setText("Provenance: " + AppUtil.convString(object.getProvenance()));
            textViewDescriptionsCulture.setText("Culture: " + AppUtil.convString(object.getCulture()));
            textViewDescriptionsDivision.setText("Division: "+ AppUtil.convString(object.getDivision()));
            textViewDescriptionsDepartment.setText("Department: "+ AppUtil.convString(object.getDepartment()));
            textViewDescriptionsDimensions.setText("Dimensions: " + AppUtil.convString(object.getDimensions()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return view;
    }
}
