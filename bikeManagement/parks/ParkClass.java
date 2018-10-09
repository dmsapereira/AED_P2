package bikeManagement.parks;

import bikeManagement.bikes.Bike;

public class ParkClass implements Park {
    private String id;
    private Bike bike;
    private int pickups;

    public ParkClass(String parkId){
        this.id=parkId;
        this.pickups=0;
    }

    @Override
    public String getParkId() {
        return this.id;
    }

    @Override
    public void parkBike(Bike bike) {
        this.bike=bike;
    }

    @Override
    public void pickUp() {
        this.bike=null;
    }
}
