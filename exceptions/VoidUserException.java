package exceptions;

public class VoidUserException extends RuntimeException implements CustomException  {

    public VoidUserException(){}

    @Override
    public String toString(){
        return "Utilizador inexistente.";
    }

}
