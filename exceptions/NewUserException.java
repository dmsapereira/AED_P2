package exceptions;

public class NewUserException extends CustomException  {
    public NewUserException(){}

    @Override
    public String toString() {
        return "Utilizador nao utilizou o sistema.";
    }
}
