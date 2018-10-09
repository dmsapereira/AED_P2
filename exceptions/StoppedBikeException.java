package exceptions;

public class StoppedBikeException extends RuntimeException implements CustomException  {
    public StoppedBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta parada.";
    }
}
