package exceptions;

public class OngoingFirstPickupException extends CustomException {
    public OngoingFirstPickupException(){}

    @Override
    public String toString() {
        return "Utilizador em primeiro PickUp.";
    }
}
