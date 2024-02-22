/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assesment.model;

/**
 *
 * @author simla
 */
  public class RentalAgreement {
    private int leaseNum;
    private Student student;

    // Constructor
    public RentalAgreement(int leaseNum, Student student) {
        this.leaseNum = leaseNum;
        this.student = student;
    }

    // Getter for lease number
    public int getLeaseNum() {
        return leaseNum;
    }

    // Getter for student
    public Student getStudent() {
        return student;
    }
    // Getter for student ID
    public int getStudentID() {
        return student.getStudentID();
    }

    // Getter for student name
    public String getStudentName() {
        return student.getStudentName();
    }

    // Getter for student phone number
    public int getStudentPhoneNum() {
        return student.getStudentPhoneNum();
    }

    // Getter for student email
    public String getStudentEmail() {
        return student.getStudentEmail();
    }
}
