package br.com.digitalhouse.harvardartmuseums.interfaces;

import br.com.digitalhouse.harvardartmuseums.model.object.Object;

public interface Comunicator {

    void sendMessageToFragments(String message);

    void sendArtToFragments(Object object);

    void sendGameToPlayFragments();
}
