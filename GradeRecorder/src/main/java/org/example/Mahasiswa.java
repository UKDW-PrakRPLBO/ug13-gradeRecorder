package org.example;

import java.util.ArrayList;

public class Mahasiswa {
    private String nama;

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getFakultas() {
        return fakultas;
    }

    public String getProdi() {
        return prodi;
    }

    private String nim;
    private String fakultas;
    private String prodi;

    public ArrayList<Matakuliah> getDaftarMatakuliah() {
        return daftarMatakuliah;
    }

    private ArrayList<Matakuliah> daftarMatakuliah;

    public Mahasiswa(String nim, String nama, String fakultas, String prodi, ArrayList<Matakuliah> daftarMatakuliah){
        this.nim = nim;
        this.nama = nama;
        this.fakultas = fakultas;
        this.prodi = prodi;
        this.daftarMatakuliah = daftarMatakuliah;
    }


    public void setDaftarMatakuliah(ArrayList<Matakuliah> daftarMatakuliah) {
        this.daftarMatakuliah = daftarMatakuliah;
    }
}
