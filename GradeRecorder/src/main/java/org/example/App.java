package org.example;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Create Matakuliah objects
        Matakuliah matakuliah1 = new Matakuliah("TI0103", "ARSITEKTUR DAN ORGANISASI KOMPUTER", 3, 90);
        Matakuliah matakuliah2 = new Matakuliah("TI0093", "MATEMATIKA DISKRIT", 3, 90);
        Matakuliah matakuliah3 = new Matakuliah("TI0133", "STRUKTUR DATA", 3, 84);
        Matakuliah matakuliah4 = new Matakuliah("TI0153", "INFRASTRUKTUR LAN", 3, 79);

        // Create Daftar Matakuliah
        ArrayList<Matakuliah> edwardSnowdenMatakuliah = new ArrayList<>();
        edwardSnowdenMatakuliah.add(matakuliah1);
        edwardSnowdenMatakuliah.add(matakuliah2);
        edwardSnowdenMatakuliah.add(matakuliah3);
        edwardSnowdenMatakuliah.add(matakuliah4);

        // Create Mahasiswa
        Mahasiswa mahasiswaUKDW = new Mahasiswa("71190433", "Edward Snowden", "Fakultas Teknologi Informasi",
                "Informatika", edwardSnowdenMatakuliah);

        // Create GradeRecoder
        GradeRecoder mGradeRecorder = new GradeRecoder(mahasiswaUKDW);

        System.out.println("##################### Save grades to file #####################");
        // Save grades to file
        boolean saveSuccess = mGradeRecorder.saveGradesToFile("my_grade.txt");
        if (saveSuccess) {
            System.out.println("Grades saved successfully.");
        } else {
            System.out.println("Failed to save grades.");
        }

        System.out.println();
        System.out.println("##################### Grade file metadata #####################");
        //View grades file meta data
        mGradeRecorder.showGradesMetaData("my_grade.txt");

        System.out.println();
        System.out.println("##################### Load grades from file #####################");

        // Load grades from file
        //TODO 1: Tampilkan hasil deserialisasi dari file my_grade.txt menggunakan method loadGradesFromFile

        // Write your source code here

    }
}
