package exceptions.user;

import exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at deleting a <code>User</code> that's on his first <code>PickUp</code>
 */
public class OngoingFirstPickupException extends CustomException {
    public OngoingFirstPickupException(){}

    @Override
    public String toString() {
        return "Utilizador em primeiro pickup.";
    }
}
