package io.github.bayu1993.androidbasic.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Bayu teguh pamuji on 10/18/18.
 * email : bayuteguhpamuji@gmail.com.
 */
public class PariwisataModel implements Parcelable {
    private String nama_pariwisata,alamat_pariwisata,detail_pariwisata,gambar_pariwisata;

    protected PariwisataModel(Parcel in) {
        nama_pariwisata = in.readString();
        alamat_pariwisata = in.readString();
        detail_pariwisata = in.readString();
        gambar_pariwisata = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama_pariwisata);
        dest.writeString(alamat_pariwisata);
        dest.writeString(detail_pariwisata);
        dest.writeString(gambar_pariwisata);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PariwisataModel> CREATOR = new Creator<PariwisataModel>() {
        @Override
        public PariwisataModel createFromParcel(Parcel in) {
            return new PariwisataModel(in);
        }

        @Override
        public PariwisataModel[] newArray(int size) {
            return new PariwisataModel[size];
        }
    };

    public String getNama_pariwisata() {
        return nama_pariwisata;
    }

    public String getAlamat_pariwisata() {
        return alamat_pariwisata;
    }

    public String getDetail_pariwisata() {
        return detail_pariwisata;
    }

    public String getGambar_pariwisata() {
        return gambar_pariwisata;
    }
}
