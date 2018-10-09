package exceptions;

public class VeteranUserException extends RuntimeException implements CustomException  {
    public VeteranUserException(){}

    @Override
    public String toString() {
        return "Utilizador ja utilizou o sistema.";
    }
}
