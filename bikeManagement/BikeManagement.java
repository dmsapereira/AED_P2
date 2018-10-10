package bikeManagement;
import bikeManagement.parks.Park;
import bikeManagement.users.User;
import dataStructures.Iterator;
import dataStructures.Queue;
import exceptions.*;

import java.io.Serializable;

public interface BikeManagement extends Serializable {

    void addUser(String idUser, String nif, String email, String phone, String name, String address) throws DuplicateUserException;

    void removeUser(String idUser) throws VoidUserException, VeteranUserException;

    void addPark(String idPark, String name, String address) throws DuplicateParkException;

    void addBike(String idBike, String idPark, String plate) throws DuplicateBikeException, VoidParkException;

    void removeBike(String idBike) throws UsedBikeException, VoidBikeException;

    Queue<String> getParkInfo(String parkId) throws VoidParkException;

    void pickUp(String idBike, String idUser) throws VoidBikeException, MovingBikeException, VoidUserException, BusyUserException, InsufficientBalanceException;

    User pickDown(String idBike, String idPark, int duration) throws VoidBikeException, StoppedBikeException, VoidParkException, InvalidDataException;

    User chargeUser(String idUser, int amount) throws VoidUserException, InvalidDataException;

    Iterator<PickUp> listBikePickups(String idBike) throws VoidBikeException, UnusedBikeException, OngoingFirstPickupException;

    Iterator<PickUp> listUserPickups(String idUser) throws VoidUserException, NewUserException, OngoingFirstPickupException;

    boolean parkedBike(String idBike, String idPark) throws VoidBikeException, VoidParkException;

    Iterator<User> listDelayed();

    Park favoriteParks();

    Queue<String> getUserInfo(String userId) throws VoidUserException;

}
