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
        Random random = new Random();
        int numRooms = 10; // Number of rooms to generate for each hall

        // Generate random room details for the hall
        for (int i = 1; i <= numRooms; i++) {
            String roomId = String.valueOf(i);
            String roomType = getRandomRoomType();
            String roomPrice = String.valueOf(500 + random.nextInt(300)); // Random price between 500 and 800
            String roomStatus = getRandomRoomStatus();
            String cleanliness = getRandomCleanliness();

            rooms.add(new Room(roomId, roomType, roomPrice, roomStatus, cleanliness));
        }

        return rooms;
    }

    // Generate random room type
    private String getRandomRoomType() {
        String[] roomTypes = {"Regular", "Superior"};
        return roomTypes[new Random().nextInt(roomTypes.length)];
    }

    // Generate random room status
    private String getRandomRoomStatus() {
        String[] roomStatuses = {"Available", "Unavailable"};
        return roomStatuses[new Random().nextInt(roomStatuses.length)];
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
}

