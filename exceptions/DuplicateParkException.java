package exceptions;

public class DuplicateParkException extends RuntimeException implements CustomException {
    public DuplicateParkException(){}

    @Override
    public String toString() {
        return "Parque existente.";
    }
}
