package bikeManagement.parks;

import bikeManagement.bikes.Bike;
import dataStructures.Queue;
import dataStructures.QueueInList;

public class ParkClass implements Park {
    static final long serialVersionUID = 0L;
    private String id, name, address;
    private Bike bike;
    private int pickups;

    public ParkClass(String parkId, String name, String address) {
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

    @Override
    public Queue<String> getParkInfo() {
        Queue<String> info = new QueueInList<>();
        info.enqueue(this.name);
        info.enqueue(this.address);
        if (this.bike == null)
            info.enqueue("0");
        else
            info.enqueue("1");
        return info;
    }

    @Override
    public void parkBike(Bike bike) {
        this.bike = bike;
    }

    @Override
    public void addBike(Bike bike) {
        this.bike = bike;
    }

    @Override
    public void deleteBike() {
        this.bike = null;
    }

    @Override
    public void pickUp() {
        this.bike = null;
        this.pickups++;
    }

    @Override
    public int getPickups() {
        return this.pickups;
    }

    @Override
    public Bike getParkedBike() {
        return this.bike;
    }
}
