package com.kinantips.pergiwisata;

import java.io.Serializable;

public class wisataModel implements Serializable {

    String Alamat, Deskripsi, Htm, Jam, imageWisata, namaWisata, id;
    double Latitude, Longitude;

    public wisataModel() {
    }

    public wisataModel(String alamat, String deskripsi, String htm, String jam, String imageWisata, String namaWisata, String id, double latitude, double longitude) {
        this.Alamat = alamat;
        this.Deskripsi = deskripsi;
        this.Htm = htm;
        this.Jam = jam;
        this.imageWisata = imageWisata;
        this.namaWisata = namaWisata;
        this.id = id;
        this.Latitude = latitude;
        this.Longitude = longitude;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        this.Alamat = alamat;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.Deskripsi = deskripsi;
    }

    public String getHtm() {
        return Htm;
    }

    public void setHtm(String htm) {
        this.Htm = htm;
    }

    public String getJam() {
        return Jam;
    }

    public void setJam(String jam) {
        this.Jam = jam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaWisata() {
        return namaWisata;
    }

    public void setNamaWisata(String namaWisata) {
        this.namaWisata = namaWisata;
    }

    public String getImageWisata() {
        return imageWisata;
    }

    public void setImageWisata(String imageWisata) {
        this.imageWisata = imageWisata;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }
}
