package com.capstone;

import com.capstone.service.StudentManager;
import com.capstone.util.StudentNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Capstone Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save and Exit");
            System.out.print("Enter choice: ");

            try {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    scanner.nextLine();
                    choice = 0;
                    System.err.println("Invalid input. Please enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1: manager.addStudent(scanner); break;
                    case 2: manager.viewAllStudents(); break;
                    case 3: manager.searchStudent(scanner); break;
                    case 4: manager.deleteStudent(scanner); break;
                    case 5: manager.sortAndDisplayByMarks(); break;
                    case 6: manager.saveAndExit(); return;
                    default: System.out.println("Invalid choice. Please try again.");
                }
            } catch (StudentNotFoundException e) {
                System.err.println("Operation Failed: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.err.println("General Input Error: Please check your input format.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
            }

        } while (true);
    }
}