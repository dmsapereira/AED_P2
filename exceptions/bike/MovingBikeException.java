package exceptions.bike;

import exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at picking up a <code>Bike</code> that's already been picked up
 */
public class MovingBikeException extends CustomException {
    public MovingBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta em movimento.";
    }
}
