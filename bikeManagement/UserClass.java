package bikeManagement;

import dataStructures.*;
import bikeManagement.exceptions.InvalidDataException;
import bikeManagement.exceptions.user.OngoingFirstPickupException;
import bikeManagement.exceptions.VoidPickupsException;

import java.util.Objects;

class UserClass implements User {
    static final int BALANCE=5;
    static final long serialVersionUID = 0L;
    private String id, nif, email, phone, name, address;
    private int balance, points;
    private PickUp currentPickup;
    private List<PickUp> pickups;

    UserClass(String id, String nif, String email, String phone, String name, String address) {
        this.id = id;
        this.nif = nif;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.balance = BALANCE;
        this.points = 0;
        pickups = new DoublyLinkedList<>();
    }

    @Override
    public String getUserId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getNIF() {
        return this.nif;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    /**
     * Adds an amount to the <code>User</code>'s balance
     *
     * @param value amount to be added
     * @throws InvalidDataException if value<1
     */
    void addBalance(int value) throws InvalidDataException {
        if (value < 1) throw new InvalidDataException();
        else this.balance += value;
    }

    /**
     * @param value amount to be subtracted
     * @pre: value>=1
     * Subtracts an amount from the <code>User</code>'s balance
     */
    void subtractBalance(int value) {
        this.balance -= value;
    }

    @Override
    public PickUp getCurrentPickup() {
        return currentPickup;
    }

    /**
     * @param pickup <code>PickUp</code> to be registered
     * @pre: pickup!=null
     * Executes a <code>PickUp</code>
     */
    void pickUp(PickUp pickup) {
        this.currentPickup = pickup;
    }

    /**
     * @pre: getCurrentPickUp()!=null
     * Finalizes the <code>PickUp</code> registering it to the list of completed <code>PickUp</code>s
     */
    void pickDown() {
        pickups.addLast(this.currentPickup);
        this.currentPickup = null;
    }

    @Override
    public Iterator<PickUp> getPickUps()  {
        return pickups.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserClass userClass = (UserClass) o;
        return Objects.equals(id, userClass.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
