package bikeManagement.exceptions;

/**
 * <code>Exception</code> for when some parameter is invalid
 */
public class InvalidDataException extends CustomException  {
    public InvalidDataException(){}

    @Override
    public String toString() {
        return "Dados invalidos.";
    }
}
