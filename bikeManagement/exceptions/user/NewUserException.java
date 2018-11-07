package bikeManagement.exceptions.user;

import bikeManagement.exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at listing a new <code>User</code>'s <code>PickUp</code>s
 */
public class NewUserException extends CustomException {
    public NewUserException(){}

    @Override
    public String toString() {
        return "Utilizador nao utilizou o sistema.";
    }
}
