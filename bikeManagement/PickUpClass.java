package bikeManagement;

class PickUpClass implements PickUp {
    static final int MAX_DELAY=60;
    static final int DELAY_COST_TIME=30;
    static final long serialVersionUID = 0L;
    private User user;
    private Bike bike;
    private Park iPark, fPark;
    private int duration;

     PickUpClass(User user, Bike bike, Park park) {
        this.user = user;
        this.bike = bike;
        this.iPark = park;
        this.duration = 0;
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public Bike getBike() {
        return this.bike;
    }

    @Override
    public void pickDown(Park park, int duration) {
        this.fPark = park;
        this.duration = duration;
    }

    @Override
    public Park getInitialPark() {
        return this.iPark;
    }

    @Override
    public Park getFinalPark() {
        return this.fPark;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    @Override
    public int getDelay() {
        int delay = this.duration - MAX_DELAY;
        if (delay <= 0)
            return 0;
        else
            return delay;
    }

    @Override
    public int getCost() {
        return this.getDelay() % DELAY_COST_TIME;
    }
}
