/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accomdationsystem;

/**
 *
 * @author simla
 */
  public class Room {
    private int roomNumber;
    private String roomType;
    private float roomPrice;
    private String roomAvailability;
    private String roomOccupancy;
    private RoomCleaningStatus roomCleaningStatus;
    private String roomDescription;
    private RentalAgreement rentalAgreement;

    // Constructor
    public Room(int roomNumber, String roomType, float roomPrice, String roomAvailability,
                String roomOccupancy, RoomCleaningStatus roomCleaningStatus, String roomDescription) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomAvailability = roomAvailability;
        this.roomOccupancy = roomOccupancy;
        this.roomCleaningStatus = roomCleaningStatus;
        this.roomDescription = roomDescription;
    }

    // Getters and Setters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public float getRoomPrice() {
        return roomPrice;
    }

    public String getRoomAvailability() {
        return roomAvailability;
    }

    public void setRoomAvailability(String roomAvailability) {
        this.roomAvailability = roomAvailability;
    }

    public String getRoomOccupancy() {
        return roomOccupancy;
    }

    public void setRoomOccupancy(String roomOccupancy) {
        this.roomOccupancy = roomOccupancy;
    }

    public RoomCleaningStatus getRoomCleaningStatus() {
        return roomCleaningStatus;
    }

    public void setCleaningStatus(RoomCleaningStatus roomCleaningStatus) throws IllegalArgumentException {
        if (this.roomCleaningStatus == RoomCleaningStatus.OFFLINE && roomCleaningStatus == RoomCleaningStatus.CLEAN) {
            throw new IllegalArgumentException("the room should be set to dirty first");
        }
        this.roomCleaningStatus = roomCleaningStatus;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public RentalAgreement getRentalAgreement() {
        return rentalAgreement;
    }

    public void setRentalAgreement(RentalAgreement rentalAgreement) {
        this.rentalAgreement = rentalAgreement;
    }

    // Method to change the room cleaning status
    public void changeCleaningStatus(RoomCleaningStatus newCleaningStatus) {
        this.roomCleaningStatus = newCleaningStatus;
    }

    // Method to check if room is occupied
    public boolean isOccupied() {
        return roomOccupancy.equals("Occupied");
    }
}
