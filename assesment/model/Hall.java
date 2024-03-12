/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package assesment.model;

import java.util.ArrayList;
import java.util.List;




public class Hall {
    private String hallName;
    private String managerName;
    private String telNumber;
    private List<Room> rooms;

    public Hall(String hallName, String managerName, String telNumber, List<Room> rooms) {
        this.hallName = hallName;
        this.managerName = managerName;
        this.telNumber = telNumber;
        this.rooms = rooms;
    }

    public String getHallName() {
        return hallName;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public int getTotalRooms() {
        return rooms.size();
    }

}