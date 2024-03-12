 package assesment.model;

public class RentalAgreement {
    private int leaseNumber;
    private String firstName;
    private String lastName;
    private String studentNumber;
    private int phoneNumber;

    // Constructor
    public RentalAgreement(int leaseNumber, String firstName, String lastName, String studentNumber, int phoneNumber) {
        this.leaseNumber = leaseNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public int getLeaseNumber() {
        return leaseNumber;
    }

    public void setLeaseNumber(int leaseNum) {
        this.leaseNumber = leaseNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fullName) {
        this.firstName = fullName;
    }
   
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String fullName) {
        this.lastName = fullName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
