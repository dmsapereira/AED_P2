package exceptions;

public class InsufficientBalanceException extends CustomException  {
    public InsufficientBalanceException(){}

    @Override
    public String toString() {
        return "Saldo insuficiente";
    }
}
