package br.com.digitalhouse.harvardartmuseums.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.interfaces.RecyclerViewExhibitionClickListener;
import br.com.digitalhouse.harvardartmuseums.model.exhibition.Exhibition;
import br.com.digitalhouse.harvardartmuseums.util.AppUtil;

public class RecyclerViewExhibitionAdapter extends RecyclerView.Adapter<RecyclerViewExhibitionAdapter.ViewHolder> {

    private List<Exhibition> exhibitionList;
    private RecyclerViewExhibitionClickListener listener;
    private FragmentActivity activity;

    public RecyclerViewExhibitionAdapter(List<Exhibition> exhibitionList, RecyclerViewExhibitionClickListener listener, FragmentActivity activity) {
        this.exhibitionList = exhibitionList;
        this.listener = listener;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_exhibition_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Exhibition exhibition = exhibitionList.get(i);
        viewHolder.bind(exhibition);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(exhibition);
            }
        });

        //Google Tradutor
        viewHolder.imageViewExhibitionTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Tradução de texto
                try {

                    AppUtil.translateOut(viewHolder.textViewExhibitionTitle, exhibition.getTitle(), activity);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //Google Speak
        viewHolder.imageViewExhibitionSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//Leitura de voz
                AppUtil.speakOut("Evento", viewHolder.textViewExhibitionTitle.getText().toString(), v.getContext());
            }
        });

    }

    public void update(List<Exhibition> exhibitionList, Context context) {
        this.exhibitionList.addAll(exhibitionList);

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return exhibitionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewExhibitionPrimaryImageurl;
        private TextView textViewExhibitionBeginDate;
        private TextView textViewExhibitionTitle;
        private TextView textViewExhibitionPeopleDisplayName;
        private TextView textViewExhibitionEndDate;
        private TextView textViewExhibitionTexTileDescription;
        private ImageView imageViewExhibitionTranslate;
        private ImageView imageViewExhibitionSound;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewExhibitionPrimaryImageurl = itemView.findViewById(R.id.imageViewExhibitionPrimaryImageurl);
            textViewExhibitionBeginDate = itemView.findViewById(R.id.textViewExhibitionBeginDate);
            textViewExhibitionTitle = itemView.findViewById(R.id.textViewExhibitionTitle);
            textViewExhibitionPeopleDisplayName = itemView.findViewById(R.id.textViewExhibitionPeopleDisplayName);
            textViewExhibitionEndDate = itemView.findViewById(R.id.textViewExhibitionEndDate);
            textViewExhibitionTexTileDescription = itemView.findViewById(R.id.textViewExhibitionTexTileDescription);
            imageViewExhibitionTranslate = itemView.findViewById(R.id.imageViewExhibitionTranslate);
            imageViewExhibitionSound = itemView.findViewById(R.id.imageViewExhibitionSound);

        }

        public void bind(Exhibition exhibition) {

            if (exhibition.getPrimaryimageurl() != null) {
                Picasso.get().setIndicatorsEnabled(true);
                Picasso.get()
                        .load(exhibition.getPrimaryimageurl())
                        .error(R.drawable.image_logo_center)
                        .placeholder(R.drawable.image_logo_center)
                        .into(imageViewExhibitionPrimaryImageurl);
            }

            textViewExhibitionBeginDate.setText("Begin date: " + exhibition.getBegindate());
            textViewExhibitionTitle.setText(exhibition.getTitle());

            //Busca a primeira linha com o nome do artista
            if (exhibition.getPeople().size() > 0) {
                textViewExhibitionPeopleDisplayName.setText(
                        exhibition.getPeople().get(0).getDisplayname());
            }

            textViewExhibitionEndDate.setText("End date: " + exhibition.getEnddate());
            textViewExhibitionTexTileDescription.setText(exhibition.getTextiledescription());

        }
    }
}