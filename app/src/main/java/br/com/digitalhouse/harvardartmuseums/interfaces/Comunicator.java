package br.com.digitalhouse.harvardartmuseums.interfaces;

import br.com.digitalhouse.harvardartmuseums.model.Obra;

public interface Comunicator {
    void sendMessageToFragments(String message);
    void sendArtToFragments(Obra obra);
}
