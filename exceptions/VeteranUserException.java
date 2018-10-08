package exceptions;

public class VeteranUserException extends RuntimeException {
    public VeteranUserException(){}

    @Override
    public String toString() {
        return "Utilizador ja utilizou o sistema.";
    }
}
