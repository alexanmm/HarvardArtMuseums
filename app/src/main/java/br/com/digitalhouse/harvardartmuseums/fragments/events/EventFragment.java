package br.com.digitalhouse.harvardartmuseums.fragments.events;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.adapters.RecyclerViewEventAdapter;
import br.com.digitalhouse.harvardartmuseums.interfaces.Comunicator;
import br.com.digitalhouse.harvardartmuseums.interfaces.RecyclerViewEventClickListener;
import br.com.digitalhouse.harvardartmuseums.model.Event;

public class EventFragment extends Fragment implements RecyclerViewEventClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewEventAdapter adapter;
    private Comunicator comunicator;

    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            comunicator = (Comunicator) context;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        recyclerView = view.findViewById(R.id.eventRecyclerViewer);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new RecyclerViewEventAdapter(getEvents(), this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(R.drawable.obra1,"Thursday, May 16, 2019","Gallery Talk","12:30pm - 1:00pm","32 Quincy Street","Cambridge, MA","Curatorial fellow Melissa Venator celebrates Gropius’s birthday with a walkthrough of the Bauhaus exhibition."));
        events.add(new Event(R.drawable.obra1,"Thursday, May 16, 2019","Gallery Talk","12:30pm - 1:00pm","32 Quincy Street","Cambridge, MA","Curatorial fellow Melissa Venator celebrates Gropius’s birthday with a walkthrough of the Bauhaus exhibition."));
        events.add(new Event(R.drawable.obra1,"Thursday, May 16, 2019","Gallery Talk","12:30pm - 1:00pm","32 Quincy Street","Cambridge, MA","Curatorial fellow Melissa Venator celebrates Gropius’s birthday with a walkthrough of the Bauhaus exhibition."));
        events.add(new Event(R.drawable.obra1,"Thursday, May 16, 2019","Gallery Talk","12:30pm - 1:00pm","32 Quincy Street","Cambridge, MA","Curatorial fellow Melissa Venator celebrates Gropius’s birthday with a walkthrough of the Bauhaus exhibition."));
        events.add(new Event(R.drawable.obra1,"Thursday, May 16, 2019","Gallery Talk","12:30pm - 1:00pm","32 Quincy Street","Cambridge, MA","Curatorial fellow Melissa Venator celebrates Gropius’s birthday with a walkthrough of the Bauhaus exhibition."));
        events.add(new Event(R.drawable.obra1,"Thursday, May 16, 2019","Gallery Talk","12:30pm - 1:00pm","32 Quincy Street","Cambridge, MA","Curatorial fellow Melissa Venator celebrates Gropius’s birthday with a walkthrough of the Bauhaus exhibition."));
        return events;
    }

    @Override
    public void onClick(Event event) {

    }
}
