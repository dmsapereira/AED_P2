package bikeManagement;

import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.List;

import java.util.Objects;

class BikeClass implements Bike {
    static final long serialVersionUID = 0L;
    private String id, plate;
    private Park park;
    private PickUp pickup;
    private List<PickUp> pickups;

     BikeClass(String idBike, Park park, String plate) {
        this.id = idBike;
        this.park = park;
        this.plate = plate;
        pickups = new DoublyLinkedList<>();
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

    /**
     * @return PickUp the bike is currently on. Null if there's none
     */
    PickUp getOngoingPickUp(){
         return this.pickup;
    }

    /**
     * Picks up bike, unparking it and registering the pickup
     *
     * @param pickup Pre-created pick up with infortmation of the user and the bike being used
     */
    void pickUp(PickUp pickup) {
        this.pickup = pickup;
        this.park = null;
    }

    /**
     * Delivers the bike, parking it and registering the successful pickup
     */
    void pickDown() {
        this.park = this.pickup.getFinalPark();
        pickups.addLast(this.pickup);
        pickup = null;
    }

    @Override
    public Iterator<PickUp> getPickUps() {
        return pickups.iterator();
    }

    @Override
    public boolean isMoving() {
        return this.pickup != null;
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
