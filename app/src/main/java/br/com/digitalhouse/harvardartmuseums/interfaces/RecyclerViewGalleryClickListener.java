package br.com.digitalhouse.harvardartmuseums.interfaces;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import br.com.digitalhouse.harvardartmuseums.model.object.Object;

public interface RecyclerViewGalleryClickListener {
    void onClick(Object object);
}
