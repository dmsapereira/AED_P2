package bikeManagement;

import bikeManagement.bikes.Bike;
import bikeManagement.users.User;

public class PickUpClass implements PickUp {
    private User user;
    private Bike bike;

    public PickUpClass(User user, Bike bike){
        this.user=user;
        this.bike=bike;
    }
    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public Bike getBike() {
        return this.bike;
    }
}
