package bikeManagement.bikes;

import bikeManagement.PickUp;
import bikeManagement.parks.Park;
import dataStructures.*;

public class BikeClass implements Bike {
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
}
