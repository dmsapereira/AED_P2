package exceptions;

public class InsufficientBalanceException extends RuntimeException implements CustomException  {
    public InsufficientBalanceException(){}

    @Override
    public String toString() {
        return "Saldo insuficiente";
    }
}
