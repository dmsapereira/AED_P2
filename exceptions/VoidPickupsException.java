package exceptions;

public class VoidPickupsException extends RuntimeException implements CustomException  {
    public VoidPickupsException(){}

    @Override
    public String toString() {
        return "Utilizador nao utilizou o sistema.";
    }
}
