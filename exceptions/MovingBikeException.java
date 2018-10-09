package exceptions;

public class MovingBikeException extends RuntimeException {
    public MovingBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta em movimento.";
    }
}
