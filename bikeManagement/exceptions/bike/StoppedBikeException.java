package bikeManagement.exceptions.bike;

import bikeManagement.exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at parking a parked <code>Bike</code>
 */
public class StoppedBikeException extends CustomException {
    public StoppedBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta parada.";
    }
}
