package com.capstone.util;

import com.capstone.model.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String FILE_NAME = "students.txt";

    public static List<Student> loadRecords() {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("Data file not found. Starting with empty records.");
            return students;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 6) {
                    try {
                        Student s = new Student();
                        s.setRollNo(Integer.parseInt(parts[0]));
                        s.setName(parts[1]);
                        s.setEmail(parts[2]);
                        s.setCourse(parts[3]);
                        s.setMarks(Double.parseDouble(parts[4]));
                        // Grade (parts[5]) is ignored as it is recalculated
                        s.calculateGrade(); 
                        students.add(s);
                    } catch (NumberFormatException e) {
                        System.err.println("Error reading record: " + line);
                    }
                }
            }
            System.out.println("Records loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error loading file: " + e.getMessage());
        }
        return students;
    }

    public static void saveRecords(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                bw.write(student.toFileString());
                bw.newLine();
            }
            System.out.println("Records saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }
}