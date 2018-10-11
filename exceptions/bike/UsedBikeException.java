package exceptions.bike;

import exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at deleting a used <code>Bike</code>
 */
public class UsedBikeException extends CustomException {
    public UsedBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta ja foi utilizada.";
    }
}
