package bikeManagement;

import dataStructures.ChainedHashTable;
import dataStructures.HashTable;
import dataStructures.Iterator;
import bikeManagement.exceptions.*;
import bikeManagement.exceptions.bike.*;
import bikeManagement.exceptions.park.DuplicateParkException;
import bikeManagement.exceptions.park.VoidParkException;
import bikeManagement.exceptions.user.*;

public class BikeManagementClass implements BikeManagement {
    static final long serialVersionUID = 0L;
    private HashTable<String, UserClass> users;
    private HashTable<String, BikeClass> bikes;
    private ParkClass park;

    public BikeManagementClass() {
        this.users = new ChainedHashTable<>();
        this.bikes = new ChainedHashTable<>();
    }

    @Override
    public void addUser(String idUser, String nif, String email, String phone, String name, String address) throws DuplicateUserException {
        if (this.users.find(idUser.toUpperCase()) != null)
            throw new DuplicateUserException();
        else
            this.users.insert(idUser.toUpperCase(), new UserClass(idUser, nif, email, phone, name, address));
    }

    @Override
    public void removeUser(String idUser) throws VoidUserException, VeteranUserException {
        if (this.users.find(idUser.toUpperCase()) == null)
            throw new VoidUserException();
        else if (this.users.find(idUser.toUpperCase()).getPickUps().hasNext())
            throw new VeteranUserException();
        else
            this.users.remove(idUser.toUpperCase());
    }

    @Override
    public void addPark(String idPark, String name, String address) throws DuplicateParkException {
        if (this.park != null && this.park.getParkId().equalsIgnoreCase(idPark))
            throw new DuplicateParkException();
        else
            this.park = new ParkClass(idPark, name, address);
    }

    @Override
    public void addBike(String idBike, String idPark, String plate) throws DuplicateBikeException, VoidParkException {
        if (this.bikes.find(idBike.toUpperCase()) != null)
            throw new DuplicateBikeException();
        else if (this.park == null || !this.park.getParkId().equalsIgnoreCase(idPark))
            throw new VoidParkException();
        else {
            BikeClass newBike = new BikeClass(idBike, this.park, plate);
            this.bikes.insert(idBike.toUpperCase(), newBike);
            this.park.parkBike(newBike);
        }
    }

    @Override
    public void removeBike(String idBike) throws UsedBikeException, VoidBikeException {
        if (this.bikes.find(idBike.toUpperCase()) == null)
            throw new VoidBikeException();
        else if (this.bikes.find(idBike.toUpperCase()).getPickUps().hasNext())
            throw new UsedBikeException();
        else {
            this.bikes.remove(idBike.toUpperCase());
            this.park.deleteBike(idBike.toUpperCase());
        }
    }

    @Override
    public Park getPark(String parkId) throws VoidParkException {
        if (this.park == null || !this.park.getParkId().equalsIgnoreCase(parkId))
            throw new VoidParkException();
        else
            return this.park;
    }

    @Override
    public void pickUp(String idBike, String idUser) throws VoidBikeException, MovingBikeException, VoidUserException, BusyUserException, InsufficientBalanceException {
        PickUp pickup;
        BikeClass bike = this.bikes.find(idBike.toUpperCase());
        UserClass user = this.users.find(idUser.toUpperCase());
        if (bike == null)
            throw new VoidBikeException();
        else if (bike.isMoving())
            throw new MovingBikeException();
        else if (user == null)
            throw new VoidUserException();
        else if (user.getCurrentPickup() != null)
            throw new BusyUserException();
        else if (user.getBalance() < UserClass.BALANCE)
            throw new InsufficientBalanceException();
        else {
            pickup = new PickUpClass(user, bike, bike.getPark());
            user.pickUp(pickup);
            bike.pickUp(pickup);
            this.park.pickUp(idBike.toUpperCase());
        }

    }

    @Override
    public User pickDown(String idBike, String idPark, int duration) throws VoidBikeException, StoppedBikeException, VoidParkException, InvalidDataException {
        BikeClass bike = this.bikes.find(idBike.toUpperCase());
        if (bike == null)
            throw new VoidBikeException();
        else if (!bike.isMoving())
            throw new StoppedBikeException();
        else if (this.park == null || !this.park.getParkId().equalsIgnoreCase(idPark))
            throw new VoidParkException();
        else if (duration <= 0)
            throw new InvalidDataException();
        else {
            PickUp pickup = bike.getOngoingPickUp();
            pickup.pickDown(this.park,duration);
            UserClass user = this.users.find(pickup.getUser().getUserId().toUpperCase());
            user.pickDown();
            this.park.parkBike(bike);
            bike.pickDown();
            if (duration > 60)
                user.subtractBalance((duration - 60) % 30);
            return user;
        }
    }

    @Override
    public User chargeUser(String idUser, int amount) throws VoidUserException, InvalidDataException {
        UserClass user = this.users.find(idUser.toUpperCase());
        if (user == null)
            throw new VoidUserException();
        else if (amount <= 0)
            throw new InvalidDataException();
        else
            user.addBalance(amount);
        return user;
    }

    @Override
    public Iterator<PickUp> listBikePickups(String idBike) throws VoidBikeException, UnusedBikeException, OngoingFirstPickupException {
        BikeClass bike = this.bikes.find(idBike.toUpperCase());
        if (bike == null)
            throw new VoidBikeException();
        else if (!bike.getPickUps().hasNext()) {
            if (bike.isMoving())
                throw new OngoingFirstPickupException();
            else
                throw new UnusedBikeException();
        }
        return bike.getPickUps();
    }

    @Override
    public Iterator<PickUp> listUserPickups(String idUser) throws VoidUserException, NewUserException, OngoingFirstPickupException {
        UserClass user = this.users.find(idUser.toUpperCase());
        if (user == null)
            throw new VoidUserException();
        else if (!user.getPickUps().hasNext()) {
            if (user.getCurrentPickup() != null)
                throw new OngoingFirstPickupException();
            else
                throw new NewUserException();
        }
        return user.getPickUps();
    }

    @Override
    public boolean parkedBike(String idBike, String idPark) throws VoidBikeException, VoidParkException {
        if (this.bikes.find(idBike.toUpperCase()) == null)
            throw new VoidBikeException();
        else if (this.park == null || !this.park.getParkId().equalsIgnoreCase(idPark))
            throw new VoidParkException();
        else {
            return this.park.isBikeParked(idBike);
        }
    }

    @Override
    public Park favoriteParks() {
        return this.park;
    }

    @Override
    public User getUser(String userId) throws VoidUserException {
        User user = this.users.find(userId.toUpperCase());
        if (user == null)
            throw new VoidUserException();
        return user;
    }

}
