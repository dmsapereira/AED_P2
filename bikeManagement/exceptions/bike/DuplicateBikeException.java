package bikeManagement.exceptions.bike;

import bikeManagement.exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at adding an existing <code>Bike</code>
 */
public class DuplicateBikeException extends CustomException {
    public DuplicateBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta existente.";
    }
}
