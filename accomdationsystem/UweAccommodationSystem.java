/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accomdationsystem;
 import java.util.ArrayList;

public class UweAccommodationSystem {
    private ArrayList<Hall> halls;

    // Constructor
    public UweAccommodationSystem() {
        this.halls = new ArrayList<>();
    }
    
    // Getter for halls
    public ArrayList<Hall> getHalls() {
        return halls;
    }

    // Method to add a hall to the system
    public void addHall(Hall hall) {
        halls.add(hall);
    }
  
    // a method to display information about all halls in the system
    public void displayAllHallsInfo() {
        System.out.println("------ All Halls Information ------");
        for (Hall hall : halls) {
            System.out.println("Hall Name: " + hall.getHallName());
            System.out.println("Number of Rooms: " + hall.getRooms().size());
            System.out.println("--------------------");
        }
    }
}
