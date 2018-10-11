package exceptions.user;

import exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at using an inexistent <code>User</code>
 */
public class VoidUserException extends CustomException {

    public VoidUserException(){}

    @Override
    public String toString(){
        return "Utilizador inexistente.";
    }

}
