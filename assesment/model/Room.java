 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assesment.model;

/**
 *
 * @author simla
 */
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Room {
    private final StringProperty roomNumber;
    private final StringProperty roomDescription;
    private final StringProperty roomPrice;
    private final StringProperty roomAvailability;
    public final StringProperty roomStatus;
   
    private Lease lease;

    public Room(String roomNumber, String roomDescription, String roomPrice, String roomAvailability, String roomStatus) {
        this.roomNumber = new SimpleStringProperty(roomNumber);
        this.roomDescription = new SimpleStringProperty(roomDescription);
        this.roomPrice = new SimpleStringProperty(roomPrice);
        this.roomAvailability = new SimpleStringProperty(roomAvailability);
        this.roomStatus = new SimpleStringProperty(roomStatus);
    }

    public String getRoomNumber() {
        return roomNumber.get();
    }

    public StringProperty roomNumberProperty() {
        return roomNumber;
    }

    public String getRoomDescription() {
        return roomDescription.get();
    }

    public StringProperty roomDescriptionProperty() {
        return roomDescription;
    }

    public String getRoomPrice() {
        return roomPrice.get();
    }

    public StringProperty roomPriceProperty() {
        return roomPrice;
    }

    public String getRoomAvailability() {
        return roomAvailability.get();
    }

    public StringProperty roomAvailabilityProperty() {
        return roomAvailability;
    }

    public String getRoomStatus() {
        return roomStatus.get();
    }

    public StringProperty roomStatusProperty() {
        return roomStatus;
    }


    public String getDisplayAvailability() {
        if (roomStatus.get().equals("Offline")) {
            return "Unavailable";
        } else {
            return roomAvailability.get();
        }
    }
    
        public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }

   public void setRoomAvailability(String roomAvailability) {
        this.roomAvailability.set(roomAvailability);
    }

     
    public void setRoomStatus(String roomStatus) {
    this.roomStatus.set(roomStatus);
    }
    
    public void deleteLease(){
            this.lease = null;
            }
}


