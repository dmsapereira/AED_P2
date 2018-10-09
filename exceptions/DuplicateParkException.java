package exceptions;

public class DuplicateParkException extends RuntimeException {
    public DuplicateParkException(){}

    @Override
    public String toString() {
        return "Parque existente.";
    }
}
