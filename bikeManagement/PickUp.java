package bikeManagement;

import bikeManagement.bikes.Bike;
import bikeManagement.users.User;

public interface PickUp {

    User getUser();

    Bike getBike();
}
