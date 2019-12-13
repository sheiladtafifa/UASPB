package com.sheiladita.tugasuts;

import android.os.Parcel;
import android.os.Parcelable;

public class CulinaryItem implements Parcelable {

    private String id, name, description, image;

    public CulinaryItem() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
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
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.image);
    }

    public CulinaryItem(String id, String name, String description, String image){
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    protected CulinaryItem(Parcel in ){
        this.name = in.readString();
        this.description = in.readString();
        this.image = in.readString();
    }

    public static final Parcelable.Creator<CulinaryItem> CREATOR = new Parcelable.Creator<CulinaryItem>(){

        @Override
        public CulinaryItem createFromParcel(Parcel source) {
            return new CulinaryItem(source);
        }

        @Override
        public CulinaryItem[] newArray(int size) {
            return new CulinaryItem[size];
        }
    };

}
