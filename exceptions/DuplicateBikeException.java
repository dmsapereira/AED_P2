package exceptions;

public class DuplicateBikeException extends RuntimeException {
    public DuplicateBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta existente.";
    }
}
