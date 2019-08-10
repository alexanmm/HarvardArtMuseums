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

public class IdentificationFragment extends Fragment {

    private static final String OBRA = "obra";
    private Object object;

    private TextView textViewIdentificationTitle;
    private TextView textViewIdentificationObjectId;
    private TextView textViewIdentificationObjectNumber;
    private TextView textViewIdentificationVerificationLevel;
    private TextView textViewIdentificationVerificationLevelDescription;
    private TextView textViewIdentificationTechnique;
    private TextView textViewIdentificationEdition;
    private TextView textViewIdentificationLastUpdate;
    private TextView textViewIdentificationCopyright;
    private TextView textViewIdentificationCreditline;

    public IdentificationFragment() {
        // Required empty public constructor
    }

    public static IdentificationFragment newInstance(Object object) {
        Bundle args = new Bundle();
        args.putParcelable(OBRA, object);

        IdentificationFragment fragment = new IdentificationFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        object = getArguments().getParcelable(OBRA);
        View view = inflater.inflate(R.layout.fragment_identification, container, false);

        try {

            textViewIdentificationTitle = view.findViewById(R.id.textViewIdentificationTitle);
            textViewIdentificationObjectId = view.findViewById(R.id.textViewIdentificationObjectId);
            textViewIdentificationObjectNumber = view.findViewById(R.id.textViewIdentificationObjectNumber);
            textViewIdentificationVerificationLevel = view.findViewById(R.id.textViewIdentificationVerificationLevel);
            textViewIdentificationVerificationLevelDescription = view.findViewById(R.id.textViewIdentificationVerificationLevelDescription);
            textViewIdentificationTechnique = view.findViewById(R.id.textViewIdentificationTechnique);
            textViewIdentificationEdition = view.findViewById(R.id.textViewIdentificationEdition);
            textViewIdentificationLastUpdate = view.findViewById(R.id.textViewIdentificationLastUpdate);
            textViewIdentificationCopyright = view.findViewById(R.id.textViewIdentificationCopyright);
            textViewIdentificationCreditline = view.findViewById(R.id.textViewIdentificationCreditline);

            textViewIdentificationTitle.setText("Title: " + AppUtil.convString(object.getTitle()));
            textViewIdentificationObjectId.setText("Object Id.: " + AppUtil.convString(object.getObjectid()));
            textViewIdentificationObjectNumber.setText("Object Number: " + AppUtil.convString(object.getObjectnumber()));
            textViewIdentificationVerificationLevel.setText("Level: " + AppUtil.convString(object.getVerificationlevel()));
            textViewIdentificationVerificationLevelDescription.setText("Description: " + AppUtil.convString(object.getVerificationleveldescription()));
            textViewIdentificationTechnique.setText("Technique: " + AppUtil.convString(object.getTechnique()));
            textViewIdentificationEdition.setText("Edition: " + AppUtil.convString(object.getEdition()));
            textViewIdentificationLastUpdate.setText("Last Update: " + AppUtil.convString(object.getLastupdate()));
            textViewIdentificationCopyright.setText("Copyright: " + AppUtil.convString(object.getCopyright()));
            textViewIdentificationCreditline.setText("Creditline: " + AppUtil.convString(object.getCreditline()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return view;
    }
}
