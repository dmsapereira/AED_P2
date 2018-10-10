package exceptions;

public class DuplicateUserException extends CustomException  {
    public DuplicateUserException(){}

    @Override
    public String toString() {
        return "Utilizador existente.";
    }
}
