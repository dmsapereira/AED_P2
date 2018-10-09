package exceptions;

public class VoidPickupsException extends RuntimeException {
    public VoidPickupsException(){}

    @Override
    public String toString() {
        return "Utilizador nao utilizou o sistema.";
    }
}
