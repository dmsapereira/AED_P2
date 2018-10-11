package bikeManagement.users;

import bikeManagement.pickup.PickUp;
import dataStructures.Iterator;
import dataStructures.Queue;
import exceptions.InvalidDataException;
import exceptions.user.OngoingFirstPickupException;
import exceptions.VoidPickupsException;

import java.io.Serializable;

public interface User extends Serializable {

    /**
     * Returns a <code>Queue</code> of <code>User</code> info: name->nif->address->email->phone->balance->points
     * @return <code>Queue</code> of <code>User</code> info
     */
    Queue<String> getUserInfo();

    /**
     * Returns the <code>User</code>'s unique ID
     * @return <code>User</code>'s unique ID
     */
    String getUserId();

    /**
     * Returns the number of delay points the <code>User</code> has
     * @return number of delay points
     */
    int getPoints();

    /**
     * Returns the <code>User</code>'s balance
     * @return <code>User</code> balance
     */
    int getBalance();

    /**
     * Adds an amount to the <code>User</code>'s balance
     * @param value amount to be added
     * @throws InvalidDataException if value<1
     */
    void addBalance(int value) throws InvalidDataException;

    /**
     * @pre: value>=1
     * Subtracts an amount from the <code>User</code>'s balance
     * @param value amount to be subtracted
     */
    void subtractBalance(int value);

    /**
     * Returns the <code>PickUp</code> the <code>User</code> is currently on
     * @return <code>PickUP</code> user is on, null if he's doing none
     */
    PickUp getCurrentPickup();

    /**
     * @pre: pickup!=null
     * Executes a <code>PickUp</code>
     * @param pickup <code>PickUp</code> to be registered
     */
    void pickUp(PickUp pickup);

    /**
     * @pre: getCurrentPickUp()!=null
     * Finalizes the <code>PickUp</code> registering it to the list of completed <code>PickUp</code>s
     */
    void pickDown();

    /**
     * Returns an <code>Iterator</code> of this <code>User</code>'s successful <code>PickUp</code>s
     * @return <code>Iterator</code> for the <code>PickUp</code>s
     * @throws OngoingFirstPickupException if <code>User</code> hasn't called <code>pickDown()</code> after calling <code>pickUp(...)</code> for the first time
     * @throws VoidPickupsException if  no <code>PickUp</code>s have been completed yet
     */
    Iterator<PickUp> getPickUps() throws OngoingFirstPickupException, VoidPickupsException;


}
