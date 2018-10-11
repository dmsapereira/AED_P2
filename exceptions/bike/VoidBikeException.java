package exceptions.bike;

import exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at using an inexistent <code>Bike</code>
 */
public class VoidBikeException extends CustomException {
    public VoidBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta inexistente.";
    }
}
