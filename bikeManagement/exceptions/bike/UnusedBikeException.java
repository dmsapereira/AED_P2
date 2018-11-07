package bikeManagement.exceptions.bike;

import bikeManagement.exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at listing a <code>Bike</code>'s <code>PickUp</code>s when it's never been used
 */
public class UnusedBikeException extends CustomException {
    public UnusedBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta nao foi utilizada.";
    }
}
