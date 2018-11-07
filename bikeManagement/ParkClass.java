package bikeManagement;

import dataStructures.ChainedHashTable;
import dataStructures.HashTable;
import dataStructures.Queue;
import dataStructures.QueueInList;

class ParkClass implements Park {
    static final long serialVersionUID = 0L;
    private String id, name, address;
    private HashTable<String, BikeClass> bikes;
    private int pickups;

    ParkClass(String parkId, String name, String address) {
        this.bikes = new ChainedHashTable<>();
        this.id = parkId;
        this.name = name;
        this.address = address;
        this.pickups = 0;
    }

    @Override
    public String getParkId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    /**
     * @param bike <code>Bike</code> to be parked
     * @pre: bike!=null
     * Parks a bike in the park
     */
    void parkBike(BikeClass bike) {
        this.bikes.insert(bike.getBikeId().toUpperCase(), bike);
    }

    /**
     * Deletes the <code>Bike</code> from the Park
     */
    void deleteBike(String idBike) {

        this.bikes.remove(idBike.toUpperCase());
    }

    /**
     * Picks up the <code>Bike</code> that's currently in the park
     */
    void pickUp(String idBike) {
        this.bikes.remove(idBike.toUpperCase());
        this.pickups++;
    }

    @Override
    public int getPickups() {
        return this.pickups;
    }

    @Override
    public int getParkedBikes() {
        return this.bikes.size();
    }

    /**
     * Returns the <code>Bike</code> that's parked
     *
     * @return parked <code>Bike</code>
     */
    boolean isBikeParked(String idBike) {
        return this.bikes.find(idBike.toUpperCase()) != null;
    }
}
