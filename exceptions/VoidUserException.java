package exceptions;

public class VoidUserException extends CustomException  {

    public VoidUserException(){}

    @Override
    public String toString(){
        return "Utilizador inexistente.";
    }

}
