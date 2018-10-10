package bikeManagement;

import bikeManagement.bikes.Bike;
import bikeManagement.bikes.BikeClass;
import bikeManagement.parks.Park;
import bikeManagement.parks.ParkClass;
import bikeManagement.users.User;
import bikeManagement.users.UserClass;
import dataStructures.Iterator;
import dataStructures.Queue;
import exceptions.*;

public class BikeManagementClass implements BikeManagement {
    static final long serialVersionUID = 0L;
    private User user;
    private Bike bike;
    private Park park;

    @Override
    public void addUser(String idUser, String nif, String email, String phone, String name, String address) throws DuplicateUserException {
        if (this.user != null && this.user.getUserId().equalsIgnoreCase(idUser))
            throw new DuplicateUserException();
        else
            this.user = new UserClass(idUser, nif, email, phone, name, address);
    }

    @Override
    public void removeUser(String idUser) throws VoidUserException, VeteranUserException {
        if (this.user == null || !this.user.getUserId().equalsIgnoreCase(idUser))
            throw new VoidUserException();
        else if (this.user.getPickUps().hasNext())
            throw new VeteranUserException();
        else
            this.user = null;
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
        if (this.bike != null && this.bike.getBikeId().equalsIgnoreCase(idBike))
            throw new DuplicateBikeException();
        else if (this.park == null || !this.park.getParkId().equalsIgnoreCase(idPark))
            throw new VoidParkException();
        else {
            this.bike = new BikeClass(idBike, this.park, plate);
            this.park.addBike(this.bike);
        }
    }

    @Override
    public void removeBike(String idBike) throws UsedBikeException, VoidBikeException {

        if (this.bike == null || !this.bike.getBikeId().equalsIgnoreCase(idBike))
            throw new VoidBikeException();
        else if (this.bike.getPickUps().hasNext())
            throw new UsedBikeException();
        else {
            this.bike = null;
            this.park.deleteBike();
        }
    }

    @Override
    public Queue<String> getParkInfo(String parkId) throws VoidParkException {
        if (this.park == null || !this.park.getParkId().equalsIgnoreCase(parkId))
            throw new VoidParkException();
        else
            return this.park.getParkInfo();
    }

    @Override
    public void pickUp(String idBike, String idUser) throws VoidBikeException, MovingBikeException, VoidUserException, BusyUserException, InsufficientBalanceException {
        PickUp pickup;
        if (this.bike == null || !this.bike.getBikeId().equalsIgnoreCase(idBike))
            throw new VoidBikeException();
        else if (this.bike.isMoving())
            throw new MovingBikeException();
        else if (this.user == null || !this.user.getUserId().equalsIgnoreCase(idUser))
            throw new VoidUserException();
        else if (this.user.getCurrentPickup() != null)
            throw new BusyUserException();
        else if (this.user.getBalance() < 5)
            throw new InsufficientBalanceException();
        else {
            pickup = new PickUpClass(this.user, this.bike, this.bike.getPark());
            this.user.pickUp(pickup);
            this.bike.pickUp(pickup);
            this.park.pickUp();
        }

    }

    @Override
    public User pickDown(String idBike, String idPark, int duration) throws VoidBikeException, StoppedBikeException, VoidParkException, InvalidDataException {
        if (this.bike == null || !this.bike.getBikeId().equalsIgnoreCase(idBike))
            throw new VoidBikeException();
        else if (!this.bike.isMoving())
            throw new StoppedBikeException();
        else if (this.park == null || !this.park.getParkId().equalsIgnoreCase(idPark))
            throw new VoidParkException();
        else if (duration <= 0)
            throw new InvalidDataException();
        else {
            this.user.getCurrentPickup().pickDown(this.park, duration);
            this.park.parkBike(this.bike);
            this.bike.pickDown();
            if (duration > 60)
                user.subtractBalance((duration - 60) % 30);
            this.user.pickDown();
            return this.user;
        }
    }

    @Override
    public User chargeUser(String idUser, int amount) throws VoidUserException, InvalidDataException {
        if (this.user == null || !this.user.getUserId().equalsIgnoreCase(idUser))
            throw new VoidUserException();
        else if (amount <= 0)
            throw new InvalidDataException();
        else
            this.user.addBalance(amount);
        return this.user;
    }

    @Override
    public Iterator<PickUp> listBikePickups(String idBike) throws VoidBikeException, UnusedBikeException, OngoingFirstPickupException {
        if (this.bike == null || !this.bike.getBikeId().equalsIgnoreCase(idBike))
            throw new VoidBikeException();
        else if ((!this.bike.getPickUps().hasNext()) && this.bike.isMoving())
            throw new OngoingFirstPickupException();
        else if (!this.bike.getPickUps().hasNext())
            throw new UnusedBikeException();
        return this.bike.getPickUps();
    }

    @Override
    public Iterator<PickUp> listUserPickups(String idUser) throws VoidUserException, NewUserException, OngoingFirstPickupException {
        if (this.user == null || !this.user.getUserId().equalsIgnoreCase(idUser))
            throw new VoidUserException();
        else if ((!this.user.getPickUps().hasNext()) && this.user.getCurrentPickup() != null)
            throw new OngoingFirstPickupException();
        else if (!this.user.getPickUps().hasNext())
            throw new NewUserException();
        else
            return this.user.getPickUps();
    }

    @Override
    public boolean parkedBike(String idBike, String idPark) throws VoidBikeException, VoidParkException {
        if (this.bike == null || !this.bike.getBikeId().equalsIgnoreCase(idBike))
            throw new VoidBikeException();
        else if (this.park == null || !this.park.getParkId().equalsIgnoreCase(idPark))
            throw new VoidParkException();
        else {
            return this.park.getParkedBike() != null && this.park.getParkedBike().getBikeId().equalsIgnoreCase(idBike);
        }
    }

    @Override
    public Iterator<User> listDelayed() {
        return null;
    }

    @Override
    public Park favoriteParks() {
        return this.park;
    }

    @Override
    public Queue<String> getUserInfo(String userId) throws VoidUserException {
        if (this.user == null || !this.user.getUserId().equalsIgnoreCase(userId))
            throw new VoidUserException();
        return this.user.getUserInfo();
    }

}
