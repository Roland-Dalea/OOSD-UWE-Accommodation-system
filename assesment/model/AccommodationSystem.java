 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package assesment.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

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
    public void initializeHalls() {
        // Create rooms for each hall
        List<Room> breconRooms = createRoomsForHall("Brecon");
        List<Room> cotswoldRooms = createRoomsForHall("Cotswold");
        List<Room> mendipRooms = createRoomsForHall("Mendip");
        List<Room> quantockRooms = createRoomsForHall("Quantock");

        // Create Hall objects and add them to the halls map
        halls.put("Brecon", new Hall("Brecon", "Michelle Chaunkaria", generateRandomTelNumber(), breconRooms));
        halls.put("Cotswold", new Hall("Cotswold", "Veena Shaji", generateRandomTelNumber(), cotswoldRooms));
        halls.put("Mendip", new Hall("Mendip", "Roland Dalea", generateRandomTelNumber(), mendipRooms));
        halls.put("Quantock", new Hall("Quantock", "Udula Sudirikku", generateRandomTelNumber(), quantockRooms));
    }

    //generate dummy phone 
    public static String generateRandomTelNumber() {
        Random random = new Random();
        StringBuilder telNumber = new StringBuilder("07"); // Start with "07"
        for (int i = 0; i < 9; i++) {
            telNumber.append(random.nextInt(10)); // Generate 9 random digits
            if (i == 3) {
                telNumber.append(" "); // Add space after the 4th digit
            }
        }
        return telNumber.toString();
    }

// dummy data for rooms
private List<Room> createRoomsForHall(String hallName) {
    List<Room> rooms = new ArrayList<>();
    Random random = new Random();
    int numStandardRooms = 30; // Number of standard rooms to generate for each hall
    int numSuperiorRooms = 10; // Number of superior rooms to generate for each hall
    int roomNumberCounter = 1; // Counter for room numbers

    // Generate regular room details for the hall
    for (int i = 0; i < numStandardRooms; i++) {
        String roomId = String.valueOf(roomNumberCounter++);
        String roomType = "Regular";
        String roomPrice = "700"; // Regular price
        String cleanliness = "Clean";
        String roomStatus = getRoomStatus(cleanliness); // Pass cleanliness status

        rooms.add(new Room(roomId, roomType, roomPrice, roomStatus, cleanliness));
    }
    
    // Generate superior room details for the hall
    for (int i = 0; i < numSuperiorRooms; i++) {
        String roomId = String.valueOf(roomNumberCounter++);
        String roomType = "Superior";
        String roomPrice = "750"; // superior price
        String cleanliness = "Clean";
        String roomStatus = getRoomStatus(cleanliness); // Pass cleanliness status

        rooms.add(new Room(roomId, roomType, roomPrice, roomStatus, cleanliness));
    }

    return rooms;
}


    // Generate random room status
    private String getRoomStatus(String cleanliness) {
      if (cleanliness.equals("Clean")) {
        return "Available";
    } else {
        String[] roomStatuses = {"Unavailable"};
        return roomStatuses[new Random().nextInt(roomStatuses.length)];
    }
}

    public Hall getHall(String hallName) {
        return halls.get(hallName);
    }

    public List<String> getHallNames() {
        return new ArrayList<>(halls.keySet());
    }
    
}