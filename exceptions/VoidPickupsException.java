package exceptions;

public class VoidPickupsException extends CustomException  {
    public VoidPickupsException(){}

    @Override
    public String toString() {
        return "Utilizador nao utilizou o sistema.";
    }
}
