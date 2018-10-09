package exceptions;

public class MovingBikeException extends RuntimeException implements CustomException  {
    public MovingBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta em movimento.";
    }
}
