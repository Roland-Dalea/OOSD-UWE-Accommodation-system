 package assesment.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccommodationSystem {
    // Singleton instance
    private static AccommodationSystem instance;

    // Map to store halls
    private Map<String, Hall> halls;

    // Private constructor to prevent instantiation from outside
    public AccommodationSystem() {
        this.halls = new HashMap<>();
    }

    // Singleton method to get the instance of AccommodationSystem
    public static AccommodationSystem getInstance() {
        if (instance == null) {
            instance = new AccommodationSystem();
        }
        return instance;
    }

    // Method to initialize halls and rooms
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

    // Method to create rooms for a hall
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

    // Method to get a specific hall
    public Hall getHall(String hallName) {
        return halls.get(hallName);
    }

    // Method to get the list of hall names
    public List<String> getHallNames() {
        return new ArrayList<>(halls.keySet());
    }
}
