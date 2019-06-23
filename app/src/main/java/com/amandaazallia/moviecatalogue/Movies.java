package com.amandaazallia.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {
    private String title;
    private String overview;
    private String user_score;
    private String status;
    private String original_language;
    private String runtime;
    private String genres;
    private String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUser_score() {
        return user_score;
    }

    public void setUser_score(String user_score) {
        this.user_score = user_score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    private int poster;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Movies() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.overview);
        dest.writeString(this.user_score);
        dest.writeString(this.status);
        dest.writeString(this.original_language);
        dest.writeString(this.runtime);
        dest.writeString(this.genres);
        dest.writeString(this.year);
        dest.writeInt(this.poster);
    }

    protected Movies(Parcel in) {
        this.title = in.readString();
        this.overview = in.readString();
        this.user_score = in.readString();
        this.status = in.readString();
        this.original_language = in.readString();
        this.runtime = in.readString();
        this.genres = in.readString();
        this.year = in.readString();
        this.poster = in.readInt();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel source) {
            return new Movies(source);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };
}
