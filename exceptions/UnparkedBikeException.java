package exceptions;

public class UnparkedBikeException extends RuntimeException {
    public UnparkedBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta nao esta em parque.";
    }
}
