/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assesment;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Accommodation {


    private final StringProperty number;
    private final StringProperty type;
    private final StringProperty price;
    private final StringProperty availability;
    private final StringProperty status;

    public Accommodation(String number, String type, String price, String availability, String status) {
        this.number = new SimpleStringProperty(number);
        this.type = new SimpleStringProperty(type);
        this.price = new SimpleStringProperty(price);
        this.availability = new SimpleStringProperty(availability);
        this.status = new SimpleStringProperty(status);
    }

    public String getnumber() {
        return number.get();
    }

    public void setnumber(String number) {
        this.number.set(number);
    }

    public StringProperty numberProperty() {
        return number;
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public StringProperty typeProperty() {
        return type;
    }

    public String getPrice() {
        return price.get();
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public StringProperty priceProperty() {
        return price;
    }

    public String getAvailability() {
        return availability.get();
    }

    public void setAvailability(String availability) {
        this.availability.set(availability);
    }

    public StringProperty availabilityProperty() {
        return availability;
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public StringProperty statusProperty() {
        return status;
    }
}


