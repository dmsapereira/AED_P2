package bikeManagement.users;

import bikeManagement.PickUp;
import dataStructures.*;
import exceptions.InvalidDataException;
import exceptions.OngoingFirstPickupException;
import exceptions.VoidPickupsException;

import java.util.Objects;

public class UserClass implements User {
    static final long serialVersionUID=0L;
    private String id,nif,email,phone,name,address;
    private int balance, points;
    private PickUp currentPickup;
    private List<PickUp> pickups;

    public UserClass(String id, String nif, String email, String phone, String name, String address){
        this.id=id;
        this.nif=nif;
        this.email=email;
        this.phone=phone;
        this.name=name;
        this.address=address;
        this.balance=5;
        this.points=0;
        pickups=new DoublyLinkedList<>();
    }
    @Override
    public Queue<String> getUserInfo() {
        Queue<String> info=new QueueInList<>();
        info.enqueue(this.name);
        info.enqueue(this.nif);
        info.enqueue(this.address);
        info.enqueue(this.email);
        info.enqueue(this.phone);
        info.enqueue(String.valueOf(this.balance));
        info.enqueue(String.valueOf(this.points));
        return info;
    }

    @Override
    public String getUserId() {
        return this.id;
    }

    @Override
    public String getNIF() {
        return this.nif;
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
    public String getName() {
        return this.name;
    }

    @Override
    public String getAdress() {
        return this.address;
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public void addPoint() {
        this.points++;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void addBalance(int value) throws InvalidDataException {
        if(value<1) throw new InvalidDataException();
        else this.balance+=value;
    }

    @Override
    public void subtractBalance(int value) {
        this.balance-=value;
    }

    @Override
    public PickUp getCurrentPickup() {
        return currentPickup;
    }

    @Override
    public void pickUp(PickUp pickup) {
        this.currentPickup=pickup;
    }

    @Override
    public void pickDown() {
        pickups.addLast(this.currentPickup);
        this.currentPickup=null;
    }

    @Override
    public Iterator<PickUp> getPickUps() throws OngoingFirstPickupException, VoidPickupsException {
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
