package exceptions.user;

import exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at deleting a <code>User</code> thats used the service
 */
public class VeteranUserException extends CustomException {
    public VeteranUserException(){}

    @Override
    public String toString() {
        return "Utilizador ja utilizou o sistema.";
    }
}
