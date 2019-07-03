package br.com.digitalhouse.harvardartmuseums.fragments.home.galeria.model;

public class Obra {
    private int imagemObra;
    private String nomeObra;
    private String descricaoObra;
    private String andarObra;

    public Obra() {
    }

    public Obra(int imagemObra, String nomeObra, String descricaoObra,String andarObra) {
        this.imagemObra = imagemObra;
        this.nomeObra = nomeObra;
        this.descricaoObra = descricaoObra;
        this.andarObra = andarObra;
    }

    public String getAndarObra() {
        return andarObra;
    }

    public void setAndarObra(String andarObra) {
        this.andarObra = andarObra;
    }

    public int getImagemObra() {
        return imagemObra;
    }

    public void setImagemObra(int imagemObra) {
        this.imagemObra = imagemObra;
    }

    public String getNomeObra() {
        return nomeObra;
    }

    public void setNomeObra(String nomeObra) {
        this.nomeObra = nomeObra;
    }

    public String getDescricaoObra() {
        return descricaoObra;
    }

    public void setDescricaoObra(String descricaoObra) {
        this.descricaoObra = descricaoObra;
    }
}
