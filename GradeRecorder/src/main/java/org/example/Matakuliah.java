package org.example;

public class Matakuliah {
    private String kode;
    private String nama;
    private int sks;
    private int nilai;

    public Matakuliah(String kode, String nama, int sks, int nilai) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.nilai = nilai;
    }


    public void setNilai(int i) {
        this.nilai = i;
    }

    public int getNilai() {
        return this.nilai;
    }

    public String getNama() {
        return this.nama;
    }

    public String getKode() {
        return this.kode;
    }

    public int getSks() {
        return this.sks;
    }
}
