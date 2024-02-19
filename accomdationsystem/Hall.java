/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accomdationsystem;

   import java.util.ArrayList;

public class Hall {
    private String hallName;
    private String hallManagerName;
    private ArrayList<Room> rooms;

    // Constructor
    public Hall(String hallName) {
        this.hallName = hallName;
        this.rooms = new ArrayList<>();
    }

    // Getter for hall name
    public String getHallName() {
        return hallName;
    }

    // Getter for hall manager name
    public String getHallManagerName() {
        return hallManagerName;
    }

    // Setter for hall manager name
    public void setHallManagerName(String hallManagerName) {
        this.hallManagerName = hallManagerName;
    }

    // Getter for rooms
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    // Method to add a room to the hall
    public void addRoom(Room room) {
        rooms.add(room);
    }
}