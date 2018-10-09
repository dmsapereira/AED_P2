package exceptions;

public class DuplicateBikeException extends RuntimeException implements CustomException {
    public DuplicateBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta existente.";
    }
}
