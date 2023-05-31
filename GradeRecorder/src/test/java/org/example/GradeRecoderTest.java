package org.example;

import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class GradeRecoderTest {

    private Mahasiswa mahasiswa;
    private GradeRecoder gradeRecorder;

    @Before
    public void setUp() {
        // Create a sample Mahasiswa object
        String nama = "John Doe";
        String nim = "123456";
        String fakultas = "Fakultas Teknologi Informasi";
        String prodi = "Prodi Informatika";
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

        mahasiswa = new Mahasiswa(nama, nim, fakultas, prodi, edwardSnowdenMatakuliah );
        gradeRecorder = new GradeRecoder(mahasiswa);
    }

    @Test
    public void testSaveGradesToFile() throws IOException {
        String filename = "test_grades.txt";

        // Call the method to save grades to file
        boolean result = gradeRecorder.saveGradesToFile(filename);

        // Check if the file was saved successfully
        assertTrue(result);

        // Check if the file exists
        File file = new File(filename);
        assertTrue(file.exists());

    }

    @Test
    public void testLoadGradesFromFile() throws IOException {
        String filename = "test_grades.txt";

        // Create a sample grades file
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("KODE | NAMA MATAKULIAH | SKS | NILAI");
        writer.newLine();
        writer.write("====================================");
        writer.newLine();
        writer.write("CSC101#Introduction to Programming#3#85");
        writer.newLine();
        writer.write("MAT202#Linear Algebra#4#90");
        writer.newLine();
        writer.close();

        // Call the method to load grades from file
        Mahasiswa loadedMahasiswa = gradeRecorder.loadGradesFromFile(filename);

        // Check if the loaded Mahasiswa object is not null
        assertNotNull(loadedMahasiswa);

        // Check the loaded grades
        ArrayList<Matakuliah> loadedMatakuliah = loadedMahasiswa.getDaftarMatakuliah();
        assertEquals(2, loadedMatakuliah.size());
        Matakuliah matakuliah1 = loadedMatakuliah.get(0);
        assertEquals("CSC101", matakuliah1.getKode());
        assertEquals("Introduction to Programming", matakuliah1.getNama());
        assertEquals(3, matakuliah1.getSks());
        assertEquals(85, matakuliah1.getNilai());
        Matakuliah matakuliah2 = loadedMatakuliah.get(1);
        assertEquals("MAT202", matakuliah2.getKode());
        assertEquals("Linear Algebra", matakuliah2.getNama());
        assertEquals(4, matakuliah2.getSks());
        assertEquals(90, matakuliah2.getNilai());

        // Clean up the file
        File file = new File(filename);
        file.delete();
    }

    @Test
    public void testShowGradesMetaData() throws IOException {
        String filename = "test_grades.txt";

        // Create a sample grades file
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("KODE | NAMA MATAKULIAH | SKS | NILAI");
        writer.newLine();
        writer.write("====================================");
        writer.newLine();
        writer.write("CSC101 | Introduction to Programming | 3 | 85");
        writer.newLine();
        writer.write("MAT202 | Linear Algebra | 4 | 90");
        writer.newLine();
        writer.close();

        // Call the method to show grades metadata
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        gradeRecorder.showGradesMetaData(filename);

        // Check the output
        String expectedOutput = "File Name: test_grades.txt" + System.lineSeparator() +
                "File Extension: txt"  + System.lineSeparator() +
                "File Size: 157 bytes"  + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());

        // Clean up the file
        File file = new File(filename);
        file.delete();
    }
}
