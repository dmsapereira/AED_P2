package exceptions;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(){}

    @Override
    public String toString() {
        return "Utilizador existente.";
    }
}
