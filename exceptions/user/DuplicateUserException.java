package exceptions.user;

import exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at creating an existent <code>User</code>
 */
public class DuplicateUserException extends CustomException {
    public DuplicateUserException(){}

    @Override
    public String toString() {
        return "Utilizador existente.";
    }
}
