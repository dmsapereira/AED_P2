package bikeManagement.exceptions.user;

import bikeManagement.exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at using an occupied <code>User</code>
 */
public class BusyUserException extends CustomException {
    public BusyUserException(){}

    @Override
    public String toString() {
        return "Utilizador em movimento.";
    }
}
