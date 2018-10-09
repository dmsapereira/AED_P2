package exceptions;

public class VoidBikeException extends RuntimeException {
    public VoidBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta inexistente.";
    }
}
