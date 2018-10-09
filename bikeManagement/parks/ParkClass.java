package bikeManagement.parks;

import bikeManagement.bikes.Bike;
import dataStructures.Queue;
import dataStructures.QueueInList;

public class ParkClass implements Park {
    private String id, name, address;
    private Bike bike;
    private int pickups;

    public ParkClass(String parkId, String name, String address){
        this.id=parkId;
        this.pickups=0;
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
        Queue<String> info=new QueueInList<>();
        info.enqueue("1");
        info.enqueue(this.address);
        info.enqueue(this.name);
        return info;
    }

    @Override
    public void parkBike(Bike bike) {
        this.bike=bike;
    }

    @Override
    public void pickUp() {
        pickups++;
        this.bike=null;
    }

    @Override
    public int getPickups() {
        return this.pickups;
    }
}
