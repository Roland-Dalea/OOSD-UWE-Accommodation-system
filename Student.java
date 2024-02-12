/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accomdationsystem;

/**
 *
 * @author simla
 */
 public class Student {
    private String studentName = "";
    private int studentID;
    private String studentEmail;
    private int studentPhoneNum;

    // Constructor
    public Student(String studentName, int studentID, String studentEmail, int studentPhoneNum) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentEmail = studentEmail;
        this.studentPhoneNum = studentPhoneNum;
    }

    // Getter for student name
    public String getStudentName() {
        return studentName;
    }

    // Getter for student ID
    public int getStudentID() {
        return studentID;
    }

    // Getter for student email
    public String getStudentEmail() {
        return studentEmail;
    }

    // Getter for student phone number
    public int getStudentPhoneNum() {
        return studentPhoneNum;
    }
}
