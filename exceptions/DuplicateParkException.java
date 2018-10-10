package exceptions;

public class DuplicateParkException extends CustomException {
    public DuplicateParkException(){}

    @Override
    public String toString() {
        return "Parque existente.";
    }
}
