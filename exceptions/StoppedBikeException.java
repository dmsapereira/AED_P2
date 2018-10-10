package exceptions;

public class StoppedBikeException extends CustomException  {
    public StoppedBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta parada.";
    }
}
