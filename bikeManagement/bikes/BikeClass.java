package bikeManagement.bikes;

import bikeManagement.PickUp;
import bikeManagement.parks.Park;
import dataStructures.*;

import java.util.Objects;

public class BikeClass implements Bike {
    static final long serialVersionUID=0L;
    private String id, plate;
    private Park park;
    private PickUp pickup;
    private List<PickUp> pickups;

    public BikeClass(String idBike, Park park, String plate){
        this.id=idBike;
        this.park=park;
        this.plate=plate;
        pickups=new DoublyLinkedList<>();
    }

    @Override
    public String getBikeId() {
        return this.id;
    }

    @Override
    public String getPlate() {
        return this.plate;
    }

    @Override
    public Park getPark() {
        return this.park;
    }

    @Override
    public void pickUp(PickUp pickup) {
        this.pickup=pickup;
    }

    @Override
    public void pickDown() {
        pickups.addLast(this.pickup);
        pickup=null;
    }

    @Override
    public Iterator<PickUp> getPickUps() {
        return pickups.iterator();
    }

    @Override
    public boolean isMoving() {
        return this.pickup!=null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BikeClass bikeClass = (BikeClass) o;
        return Objects.equals(id, bikeClass.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
