package exceptions;

public class NewUserException extends RuntimeException implements CustomException  {
    public NewUserException(){}

    @Override
    public String toString() {
        return "Utilizador nao utilizou o sistema.";
    }
}
