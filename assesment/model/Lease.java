/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assesment.model;

/**
 *
 * @author miche
 */
public class Lease {
    private String leaseNumber;
    private String firstName;
    private String lastName; // Changed from secondName
    private String studentNumber;
    private String phoneNumber;

    public Lease(String leaseNumber, String firstName, String lastName, String studentNumber, String phoneNumber) {
        this.leaseNumber = leaseNumber;
        this.firstName = firstName;
        this.lastName = lastName; // Changed from secondName
        this.studentNumber = studentNumber;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public String getLeaseNumber() {
        return leaseNumber;
    }

    public void setLeaseNumber(String leaseNumber) {
        this.leaseNumber = leaseNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { // Changed from getSecondName
        return lastName;
    }

    public void setLastName(String lastName) { // Changed from setSecondName
        this.lastName = lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
