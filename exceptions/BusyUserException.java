package exceptions;

public class BusyUserException extends RuntimeException {
    public BusyUserException(){}

    @Override
    public String toString() {
        return "Utilizador em movimento.";
    }
}
