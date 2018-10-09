package exceptions;

public class UnusedBikeException extends RuntimeException {
    public UnusedBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta nao foi utilizada.";
    }
}
