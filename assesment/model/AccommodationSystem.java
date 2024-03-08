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
    int numRooms = 10; // Number of rooms to generate for each hall

    // Generate random room details for the hall
    for (int i = 1; i <= numRooms; i++) {
        String roomId = String.valueOf(i);
        String roomType = getRandomRoomType();
        String roomPrice = String.valueOf(500 + random.nextInt(300)); // Random price between 500 and 800
        String cleanliness = getRandomCleanliness();
        String roomStatus = getRandomRoomStatus(cleanliness); // Pass cleanliness status

        rooms.add(new Room(roomId, roomType, roomPrice, roomStatus, cleanliness));
    }

    // Generate a random lease for each room and associate it
    for (Room room : rooms) {
        Lease lease = generateRandomLease();
        room.setLease(lease);
    }

    return rooms;
}

    

    // Generate random room type
    private String getRandomRoomType() {
        String[] roomTypes = {"Regular", "Superior"};
        return roomTypes[new Random().nextInt(roomTypes.length)];
    }

    // Generate random room status
    private String getRandomRoomStatus(String cleanliness) {
      if (cleanliness.equals("Clean")) {
        return "Available";
    } else {
        String[] roomStatuses = {"Unavailable"};
        return roomStatuses[new Random().nextInt(roomStatuses.length)];
    }
}

    // Generate random cleanliness status
    private String getRandomCleanliness() {
        String[] cleanlinessStatuses = {"Clean", "Dirty", "Offline"};
        return cleanlinessStatuses[new Random().nextInt(cleanlinessStatuses.length)];
    }

    public Hall getHall(String hallName) {
        return halls.get(hallName);
    }

    public List<String> getHallNames() {
        return new ArrayList<>(halls.keySet());
    }

    //dummy data for lease (TO BE DELETED)
    private Lease generateRandomLease() {
        // Generate random lease details
        String leaseNumber = "L" + UUID.randomUUID().toString().substring(0, 6); // Random lease number
        String firstName = getRandomFirstName();
        String lastName = getRandomLastName();
        String studentNumber = "S" + String.format("%06d", new Random().nextInt(1000000)); // Random student number
        String phoneNumber = getRandomPhoneNumber(); // Random phone number

    return new Lease(leaseNumber, firstName, lastName, studentNumber, phoneNumber);
}

    private String getRandomFirstName() {
        String[] firstNames = {"John", "Jane", "Michael", "Emily", "David", "Sarah", "James", "Emma", "William", "Olivia"};
        
    return firstNames[new Random().nextInt(firstNames.length)];
}

    private String getRandomLastName() {
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Martinez", "Lopez"};
    return lastNames[new Random().nextInt(lastNames.length)];
}

    private String getRandomPhoneNumber() {
    // Generate a random phone number in format XXX-XXX-XXXX
    return String.format("%03d-%03d-%04d", new Random().nextInt(1000), new Random().nextInt(1000), new Random().nextInt(10000));
}
    
}

