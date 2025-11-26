package com.capstone.model;

import java.io.Serializable;
import java.util.Scanner;

public class Student extends Person implements Serializable {
    private int rollNo;
    private String course;
    private double marks;
    private String grade;

    public Student() {
        super();
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    private void setGrade(String grade) {
        this.grade = grade;
    }

    public void calculateGrade() {
        if (marks >= 90) setGrade("A");
        else if (marks >= 80) setGrade("B");
        else if (marks >= 70) setGrade("C");
        else if (marks >= 60) setGrade("D");
        else setGrade("F");
    }

    public void inputDetails(Scanner scanner) throws IllegalArgumentException {
        System.out.print("Enter Roll No: ");
        if (scanner.hasNextInt()) {
            this.setRollNo(scanner.nextInt());
            scanner.nextLine();
        } else {
            scanner.nextLine();
            throw new IllegalArgumentException("Roll No must be an integer.");
        }

        System.out.print("Enter Name: ");
        this.setName(scanner.nextLine().trim());
        if (this.getName().isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");

        System.out.print("Enter Email: ");
        this.setEmail(scanner.nextLine().trim());
        if (!this.getEmail().contains("@")) throw new IllegalArgumentException("Invalid email format.");

        System.out.print("Enter Course: ");
        this.setCourse(scanner.nextLine().trim());
        if (this.getCourse().isEmpty()) throw new IllegalArgumentException("Course cannot be empty.");

        System.out.print("Enter Marks: ");
        if (scanner.hasNextDouble()) {
            double m = scanner.nextDouble();
            scanner.nextLine();
            if (m < 0 || m > 100) throw new IllegalArgumentException("Marks must be between 0 and 100.");
            this.setMarks(m);
            calculateGrade();
        } else {
            scanner.nextLine();
            throw new IllegalArgumentException("Marks must be a numeric value.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.printf("Roll No: %d\nName: %s\nEmail: %s\nCourse: %s\nMarks: %.1f\nGrade: %s\n",
                rollNo, getName(), getEmail(), course, marks, grade);
    }
    
    // Helper method for file storage
    public String toFileString() {
        return String.format("%d|%s|%s|%s|%.1f|%s", rollNo, getName(), getEmail(), course, marks, grade);
    }
}