package org.example;

import java.io.*;
import java.util.ArrayList;

public class GradeRecoder {
    private Mahasiswa mahasiswa;

    public GradeRecoder(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public boolean saveGradesToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write Mahasiswa information
            writer.write("Nama: " + mahasiswa.getNama());
            writer.newLine();
            writer.write("NIM: " + mahasiswa.getNim());
            writer.newLine();
            writer.write("Fakultas: " + mahasiswa.getFakultas());
            writer.newLine();
            writer.write("Program Studi: " + mahasiswa.getProdi());
            writer.newLine();
            writer.newLine();

            // Write Matakuliah header
            writer.write("KODE | NAMA MATAKULIAH | SKS | NILAI");
            writer.newLine();
            writer.write("====================================");
            writer.newLine();

            // Write Matakuliah information
            ArrayList<Matakuliah> daftarMatakuliah = mahasiswa.getDaftarMatakuliah();
            for (Matakuliah matakuliah : daftarMatakuliah) {
                writer.write(matakuliah.getKode() + "#" + matakuliah.getNama() + "#" + matakuliah.getSks() + "#" + matakuliah.getNilai());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Mahasiswa loadGradesFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            ArrayList<Matakuliah> daftarMatakuliah = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("#");
                if (parts.length == 4) {
                    String kode = parts[0];
                    String nama = parts[1];
                    int sks = Integer.parseInt(parts[2]);
                    int nilai = Integer.parseInt(parts[3]);
                    Matakuliah matakuliah = new Matakuliah(kode, nama, sks, nilai);
                    daftarMatakuliah.add(matakuliah);
                }
            }

            mahasiswa.setDaftarMatakuliah(daftarMatakuliah);
            return mahasiswa;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



    public void showGradesMetaData(String filename) {
        File file = new File(filename);

        // Get file name
        String name = file.getName();
        System.out.println("File Name: " + name);

        // Get file extension
        String extension = name.substring(name.lastIndexOf(".") + 1);
        System.out.println("File Extension: " + extension);

        // Get file size in bytes
        long fileSize = file.length();
        System.out.println("File Size: " + fileSize + " bytes");

    }

}
