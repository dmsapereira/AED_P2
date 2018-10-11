package bikeManagement.pickup;

import bikeManagement.bikes.Bike;
import bikeManagement.parks.Park;
import bikeManagement.users.User;

public class PickUpClass implements PickUp {
    static final long serialVersionUID = 0L;
    private User user;
    private Bike bike;
    private Park iPark, fPark;
    private int duration;

    public PickUpClass(User user, Bike bike, Park park) {
        this.user = user;
        this.bike = bike;
        this.iPark = park;
        this.duration = 0;
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public Bike getBike() {
        return this.bike;
    }

    @Override
    public void pickDown(Park park, int duration) {
        this.fPark = park;
        this.duration = duration;
    }

    @Override
    public Park getInitialPark() {
        return this.iPark;
    }

    @Override
    public Park getFinalPark() {
        return this.fPark;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    @Override
    public int getDelay() {
        int delay = this.duration - 60;
        if (delay <= 0)
            return 0;
        else
            return delay;
    }

    @Override
    public int getCost() {
        return this.getDelay() % 30;
    }
}
