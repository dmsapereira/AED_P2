package exceptions;

public class MovingBikeException extends CustomException  {
    public MovingBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta em movimento.";
    }
}
