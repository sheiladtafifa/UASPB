package com.sheiladita.tugasuts;

import android.os.Parcel;
import android.os.Parcelable;

public class KoreanDramaItem implements Parcelable {

    private String id, drama, network, episodes, releasedate, runtime , genre , sinopsis, image;

    public KoreanDramaItem(){

    }

    public String getDrama() {
        return drama;
    }

    public String getNetwork() {
        return network;
    }

    public String getEpisodes() {
        return episodes;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getImage() { return image; }

    public void setDrama(String drama) {
        this.drama = drama;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setGenre(String genre) { this.genre = genre; }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.drama);
        parcel.writeString(this.network);
        parcel.writeString(this.episodes);
        parcel.writeString(this.releasedate);
        parcel.writeString(this.runtime);
        parcel.writeString(this.genre);
        parcel.writeString(this.sinopsis);
        parcel.writeString(this.image);
    }

    public KoreanDramaItem(String id, String drama, String network, String episodes, String releasedate,
                           String runtime , String genre , String sinopsis, String image){
        this.id = id;
        this.drama = drama;
        this.network = network;
        this.episodes = episodes;
        this.releasedate = releasedate;
        this.runtime = runtime;
        this.genre = genre;
        this.sinopsis = sinopsis;
        this.image = image;
    }


    protected KoreanDramaItem(Parcel in) {
        this.drama = in.readString();
        this.network = in.readString();
        this.episodes = in.readString();
        this.releasedate = in.readString();
        this.runtime = in.readString();
        this.genre = in.readString();
        this.sinopsis = in.readString();
        this.image = in.readString();
    }

    public static final Parcelable.Creator<KoreanDramaItem> CREATOR = new Parcelable.Creator<KoreanDramaItem>(){

        @Override
        public KoreanDramaItem createFromParcel(Parcel source) {
            return new KoreanDramaItem(source);
        }

        @Override
        public KoreanDramaItem[] newArray(int size) {
            return new KoreanDramaItem[size];
        }
    };


}
