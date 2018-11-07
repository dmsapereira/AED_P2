package bikeManagement;

import java.io.Serializable;

public interface PickUp extends Serializable {

    /**
     * Returns <code>User</code> that picked up the bike
     * @return <code>User</code> responsible for the pickup
     */
    User getUser();

    /**
     * Returns the <code>Bike</code> that was picked up
     * @return <code>Bike</code> that's been picked up
     */
    Bike getBike();

    /**
     * @pre: park!=null && duration>0
     * Completes the pickup, parking the <code>Bike</code> in the <code>Park</code> and registering the duration
     * @param park <code>Park</code> where bike will be parked
     * @param duration amount of time the <code>PickUp</code> took
     */
    void pickDown(Park park, int duration);

    /**
     * Returns the <code>Park</code> where the <code>Bike</code> was picked up
     * @return <code>Park</code> where <code>Bike</code> was picked up
     */
    Park getInitialPark();

    /**
     * @pre: pickDown(...) has been called
     * Returns the <code>Park</code> where the <code>Bike</code> will be parked
     * @return <code>Park</code> where <code>Bike</code> will be parked
     */
    Park getFinalPark();

    /**
     * @pre: pickDown(...) has been called
     * Returns the duration of the pickup
     * @return duration of the pickup
     */
    int getDuration();

    /**
     * @pre: pickDown(...) has been called
     * Returns the delay of the <code>PickUp</code>
     * @return delay of the <code>PickUp</code>
     */
    int getDelay();

    /**
     * @pre: pickDown(...) has been called
     * Returns the cost the pickdown will have to the <code>User</code>
     * @return cost of the <code>PickUp</code>
     */
    int getCost();
}
