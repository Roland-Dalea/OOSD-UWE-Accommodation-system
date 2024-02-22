/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assesment.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccommodationSystem {
    private Map<String, Hall> halls;

    public AccommodationSystem() {
        this.halls = new HashMap<>();
    }

    public void initializeHalls() {
        // Create rooms for each hall
        List<Room> breconRooms = createRoomsForHall("Brecon");
        List<Room> cotswoldRooms = createRoomsForHall("Cotswold");
        List<Room> mendipRooms = createRoomsForHall("Mendip");
        List<Room> quantockRooms = createRoomsForHall("Quantock");

        // Create Hall objects and add them to the halls map
        halls.put("Brecon", new Hall("Brecon", "Manager Name 1", "123456789", breconRooms));
        halls.put("Cotswold", new Hall("Cotswold", "Manager Name 2", "987654321", cotswoldRooms));
        halls.put("Mendip", new Hall("Mendip", "Manager Name 3", "456789123", mendipRooms));
        halls.put("Quantock", new Hall("Quantock", "Manager Name 4", "789123456", quantockRooms));
    }

    private List<Room> createRoomsForHall(String hallName) {
        List<Room> rooms = new ArrayList<>();
        // Add room details for the hall
        switch (hallName) {
            case "Brecon":
                rooms.add(new Room("1", "Regular", "600", "Occupied", "Clean"));
                rooms.add(new Room("2", "Regular", "570", "Available", "Dirty"));
                rooms.add(new Room("3", "Suprime", "700", "Occupied", "Clean"));
                rooms.add(new Room("4", "Regular", "650", "Available", "Dirty"));

                // Add more rooms for Brecon
                break;
            case "Cotswold":
                rooms.add(new Room("1", "Supreme", "730", "Available", "Clean"));
                rooms.add(new Room("2", "Regular", "640", "Occupied", "Offline"));
                rooms.add(new Room("3", "Regular", "560", "Occupied", "Clean"));
                rooms.add(new Room("4", "Regular", "630", "Available", "Dirty"));
                // Add more rooms for Cotswold
                break;
            case "Mendip":
                rooms.add(new Room("1", "Regular", "600", "Occupied", "Clean"));
                rooms.add(new Room("2", "Regular", "650", "Available", "Dirty"));
                rooms.add(new Room("3", "Regular", "600", "Occupied", "Clean"));
                rooms.add(new Room("4", "Regular", "640", "Available", "Dirty"));
                // Add more rooms for Brecon
                break;
            case "Quantock":
                rooms.add(new Room("1", "Supreme", "730", "Available", "Clean"));
                rooms.add(new Room("2", "Regular", "740", "Occupied", "Offline"));
                rooms.add(new Room("3", "Regular", "700", "Occupied", "Clean"));
                rooms.add(new Room("4", "Regular", "750", "Available", "Dirty"));
                rooms.add(new Room("4", "Regular", "750", "Available", "Offline"));
                // Add more rooms for Cotswold
                break;
        }
        return rooms;
    }

    public Hall getHall(String hallName) {
        return halls.get(hallName);
    }

    public List<String> getHallNames() {
        return new ArrayList<>(halls.keySet());
    }
}
