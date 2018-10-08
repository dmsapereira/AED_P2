package exceptions;

public class VoidUserException extends RuntimeException {

    public VoidUserException(){}

    @Override
    public String toString(){
        return "Utilizador inexistente.";
    }

}
