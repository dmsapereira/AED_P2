package bikeManagement.users;

import bikeManagement.PickUp;
import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.Queue;
import exceptions.InvalidDataException;
import exceptions.OngoingFirstPickupException;
import exceptions.VoidPickupsException;

public interface User {

    Queue<String> getUserInfo();

    String getUserId();

    String getNIF();

    String getEmail();

    String getPhone();

    String getName();

    String getAdress();

    int getPoints();

    void addPoint();

    int getBalance();

    void addBalance(int value) throws InvalidDataException;

    void subtractBalance(int value);

    PickUp getCurrentPickup();

    void pickUp(PickUp pickup);

    void pickDown();

    Iterator<PickUp> getPickUps() throws OngoingFirstPickupException, VoidPickupsException;


}
