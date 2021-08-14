package com.kinantips.pergiwisata;

import java.io.Serializable;

public class detailModel implements Serializable {
    String Alamat, Deskripsi, Htm, Jam, imageWisata, namaWisata;
    Long id;

    public detailModel(String alamat, String deskripsi, String htm, String jam, String imageWisata, String namaWisata, Long id) {
        Alamat = alamat;
        Deskripsi = deskripsi;
        Htm = htm;
        Jam = jam;
        this.imageWisata = imageWisata;
        this.namaWisata = namaWisata;
        this.id = id;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        Deskripsi = deskripsi;
    }

    public String getHtm() {
        return Htm;
    }

    public void setHtm(String htm) {
        Htm = htm;
    }

    public String getJam() {
        return Jam;
    }

    public void setJam(String jam) {
        Jam = jam;
    }

    public String getImageWisata() {
        return imageWisata;
    }

    public void setImageWisata(String imageWisata) {
        this.imageWisata = imageWisata;
    }

    public String getNamaWisata() {
        return namaWisata;
    }

    public void setNamaWisata(String namaWisata) {
        this.namaWisata = namaWisata;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
