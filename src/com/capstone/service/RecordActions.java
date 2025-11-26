package com.capstone.service;

import com.capstone.model.Student;
import com.capstone.util.StudentNotFoundException;
import java.util.List;
import java.util.Scanner;

public interface RecordActions {
    void addStudent(Scanner scanner);
    void updateStudent(Scanner scanner) throws StudentNotFoundException;
    void deleteStudent(Scanner scanner) throws StudentNotFoundException;
    Student searchStudent(Scanner scanner) throws StudentNotFoundException;
    void viewAllStudents();
    void saveAndExit();
}