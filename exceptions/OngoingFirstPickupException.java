package exceptions;

public class OngoingFirstPickupException extends RuntimeException {
    public OngoingFirstPickupException(){}

    @Override
    public String toString() {
        return "Utilizador em primeiro PickUp.";
    }
}
