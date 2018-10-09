package exceptions;

public class BusyUserException extends RuntimeException implements CustomException {
    public BusyUserException(){}

    @Override
    public String toString() {
        return "Utilizador em movimento.";
    }
}
