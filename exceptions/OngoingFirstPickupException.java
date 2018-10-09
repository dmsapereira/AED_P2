package exceptions;

public class OngoingFirstPickupException extends RuntimeException  implements CustomException {
    public OngoingFirstPickupException(){}

    @Override
    public String toString() {
        return "Utilizador em primeiro PickUp.";
    }
}
