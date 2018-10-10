package exceptions;

public class BusyUserException extends CustomException {
    public BusyUserException(){}

    @Override
    public String toString() {
        return "Utilizador em movimento.";
    }
}
