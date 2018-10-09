package exceptions;

public class DuplicateUserException extends RuntimeException implements CustomException  {
    public DuplicateUserException(){}

    @Override
    public String toString() {
        return "Utilizador existente.";
    }
}
