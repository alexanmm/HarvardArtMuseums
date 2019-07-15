package br.com.digitalhouse.harvardartmuseums.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Obra implements Parcelable {
    private int imagemObra;
    private String nomeObra;
    private String descricaoObra;
    private String andarObra;
    private boolean isFavorite;

    public Obra() {
    }

    public Obra(int imagemObra, String nomeObra, String descricaoObra, String andarObra, boolean isFavorite) {
        this.imagemObra = imagemObra;
        this.nomeObra = nomeObra;
        this.descricaoObra = descricaoObra;
        this.andarObra = andarObra;
        this.isFavorite = isFavorite;
    }

    protected Obra(Parcel in) {
        imagemObra = in.readInt();
        nomeObra = in.readString();
        descricaoObra = in.readString();
        andarObra = in.readString();
        isFavorite = in.readByte() != 0;
    }

    public static final Creator<Obra> CREATOR = new Creator<Obra>() {
        @Override
        public Obra createFromParcel(Parcel in) {
            return new Obra(in);
        }

        @Override
        public Obra[] newArray(int size) {
            return new Obra[size];
        }
    };

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

    public String getAndarObra() {
        return andarObra;
    }

    public void setAndarObra(String andarObra) {
        this.andarObra = andarObra;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagemObra);
        dest.writeString(nomeObra);
        dest.writeString(descricaoObra);
        dest.writeString(andarObra);
        dest.writeByte((byte) (isFavorite ? 1 : 0));
    }
}
