package bikeManagement;

import bikeManagement.bikes.Bike;
import bikeManagement.parks.Park;
import bikeManagement.users.User;
import dataStructures.Iterator;
import dataStructures.Queue;
import exceptions.*;

public class BikeManagementClass implements BikeManagement {
    private User user;
    private Bike bike;
    private Park park;
    @Override
    public void addUser(String idUser, String nif, String email, String phone, String name, String address) throws DuplicateUserException {

    }

    @Override
    public void removeUser(String idUser) throws VoidUserException, VeteranUserException {

    }

    @Override
    public void addPark(String idPark, String name, String address) throws DuplicateParkException {

    }

    @Override
    public void addBike(String idBike, String idPark, String plate) throws DuplicateBikeException, VoidParkException {

    }

    @Override
    public void removeBike(String idBike) throws UsedBikeException, VoidBikeException {

    }

    @Override
    public Queue<String> getParkInfo(String parkId) throws VoidParkException {
        return null;
    }

    @Override
    public void pickUp(String idBike, String idUser) throws VoidBikeException, MovingBikeException, VoidUserException, BusyUserException, InsufficientBalanceException {

    }

    @Override
    public void pickDown(String idBike, String idPark, int duration) throws VoidBikeException, StoppedBikeException, VoidParkException, InvalidDataException {

    }

    @Override
    public void chargeUser(String idUser, int amount) throws VoidUserException, InvalidDataException {

    }

    @Override
    public Iterator<PickUp> listBikePickups(String idBike) throws VoidBikeException, UnusedBikeException, OngoingFirstPickupException {
        return null;
    }

    @Override
    public Iterator<PickUp> listUserPickups(String idUser) throws VoidUserException, NewUserException, OngoingFirstPickupException {
        return null;
    }

    @Override
    public boolean parkedBike(String idBike, String idPark) throws VoidBikeException, VoidParkException, UnparkedBikeException {
        return false;
    }

    @Override
    public Iterator<User> listDelayed() {
        return null;
    }

    @Override
    public Iterator<Park> favoriteParks() {
        return null;
    }

    @Override
    public Queue<String> getUser(String userId) throws VoidUserException {
        return null;
    }
}
