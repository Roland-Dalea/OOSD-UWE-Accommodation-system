/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accomdationsystem;

/**
 *
 *  
 */
public class HallInformation {
    private String hallName;
    private String hallManagerName;
    private int totalRooms;
    private int availableRooms;
    private int roomsNeedingCleaning;
    private int offlineRooms;

    // Constructor
    public HallInformation(String hallName, String hallManagerName, int totalRooms, int availableRooms,
                           int roomsNeedingCleaning, int offlineRooms) {
        this.hallName = hallName;
        this.hallManagerName = hallManagerName;
        this.totalRooms = totalRooms;
        this.availableRooms = availableRooms;
        this.roomsNeedingCleaning = roomsNeedingCleaning;
        this.offlineRooms = offlineRooms;
    }

    // Getter methods
    public String getHallName() {
        return hallName;
    }

    public String getHallManagerName() {
        return hallManagerName;
    }
 
    public int getTotalRooms() {
        return totalRooms;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public int getRoomsNeedingCleaning() {
        return roomsNeedingCleaning;
    }

    public int getOfflineRooms() {
        return offlineRooms; 
    }
} 
