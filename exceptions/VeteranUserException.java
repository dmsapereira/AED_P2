package exceptions;

public class VeteranUserException extends CustomException  {
    public VeteranUserException(){}

    @Override
    public String toString() {
        return "Utilizador ja utilizou o sistema.";
    }
}
