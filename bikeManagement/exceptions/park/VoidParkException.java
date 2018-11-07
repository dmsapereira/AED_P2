package bikeManagement.exceptions.park;

import bikeManagement.exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at using an inexistent <code>Park</code>
 */
public class VoidParkException extends CustomException {
    public VoidParkException(){}

    @Override
    public String toString() {
        return "Parque inexistente.";
    }
}
