package exceptions.user;

import exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at an action that requires balance that the <code>User</code> doesn't possess
 */
public class InsufficientBalanceException extends CustomException {
    public InsufficientBalanceException(){}

    @Override
    public String toString() {
        return "Saldo insuficiente";
    }
}
