package br.com.digitalhouse.harvardartmuseums.adapters;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.interfaces.RecyclerViewEventClickListener;
import br.com.digitalhouse.harvardartmuseums.model.Event;

public class RecyclerViewEventAdapter extends RecyclerView.Adapter<RecyclerViewEventAdapter.ViewHolder> {

    private List<Event> events;
    private RecyclerViewEventClickListener listener;

    public RecyclerViewEventAdapter(List<Event> events, RecyclerViewEventClickListener listener) {
        this.events = events;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_event_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Event event= events.get(i);
        viewHolder.bind(event);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(event);
            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewThumbnail;
        private TextView textViewDateEvent;
        private TextView textViewEventName;
        private TextView textViewEventTime;
        private TextView textViewEventAddress1;
        private TextView textViewEventAddress2;
        private TextView textViewEventDrescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewThumbnail = itemView.findViewById(R.id.imageViewThumbnail);
            textViewDateEvent = itemView.findViewById(R.id.textViewDateEvent);
            textViewEventName = itemView.findViewById(R.id.textViewEventName);
            textViewEventTime = itemView.findViewById(R.id.textViewEventTime);
            textViewEventAddress1 = itemView.findViewById(R.id.textViewEventAddress1);
            textViewEventAddress2 = itemView.findViewById(R.id.textViewEventAddress2);
            textViewEventDrescription = itemView.findViewById(R.id.textViewEventDrescription);
        }

        public void bind(Event event) {
            imageViewThumbnail.setImageDrawable(ContextCompat.getDrawable(imageViewThumbnail.getContext(), event.getThunbnail()));
            textViewDateEvent.setText(event.getDate());
            textViewEventName.setText(event.getName());
            textViewEventTime.setText(event.getTime());
            textViewEventAddress1.setText(event.getStreetAndNumber());
            textViewEventAddress2.setText(event.getCityAndState());
            textViewEventDrescription.setText(event.getDescription());
        }
    }
}
