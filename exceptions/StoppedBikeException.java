package exceptions;

public class StoppedBikeException extends RuntimeException {
    public StoppedBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta parada.";
    }
}
