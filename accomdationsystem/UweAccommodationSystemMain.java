/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accomdationsystem;


 import accomdationsystem.*;

public class UweAccommodationSystemMain {
    public static void main(String[] args) {
        // Create a Hall instance
        Hall hallA = new Hall("Hall A");
        hallA.setHallManagerName("Manager Name");  
        
        // Create some rooms
        Room room101 = new Room(101, "Single", 100.0f, "Available", "Occupied", RoomCleaningStatus.CLEAN, "Basic single room");
        Room room102 = new Room(102, "Double", 150.0f, "Available", "Vacant", RoomCleaningStatus.DIRTY, "Basic double room");
        
        // Create a student
        Student student = new Student("", 123456789, "student@example.com", 123456789);
        
        // Create a rental agreement
        RentalAgreement rentalAgreement = new RentalAgreement(12345, student);
        room101.setRentalAgreement(rentalAgreement);
        
        // Add rooms to the hall
        hallA.addRoom(room101);
        hallA.addRoom(room102);
        
        // Print hall information
        System.out.println("Halls:");
        System.out.println("Hall Name: " + hallA.getHallName());
        for (Room room : hallA.getRooms()) {
            System.out.println("Room Number: " + room.getRoomNumber());
            System.out.println("Room Type: " + room.getRoomType());
            System.out.println("Room Price: " + room.getRoomPrice());
            System.out.println("Room Availability: " + room.getRoomAvailability());
            System.out.println("Room Occupancy: " + room.getRoomOccupancy());
            System.out.println("Room Cleaning Status: " + room.getRoomCleaningStatus());
            System.out.println("Room Description: " + room.getRoomDescription());
            RentalAgreement roomRentalAgreement = room.getRentalAgreement();
            if (roomRentalAgreement != null) {
                Student roomStudent = roomRentalAgreement.getStudent();
                if (roomStudent != null) {
                    System.out.println("Student ID: " + roomStudent.getStudentID());
                    System.out.println("Student Name: " + roomStudent.getStudentName());
                    System.out.println("Student Phone Number: " + roomStudent.getStudentPhoneNum());
                    System.out.println("Student Email: " + roomStudent.getStudentEmail());
                }
                System.out.println("Lease Number: " + roomRentalAgreement.getLeaseNum());
            }
        }
    }
}
