package exceptions;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(){}

    @Override
    public String toString() {
        return "Saldo insuficiente";
    }
}
