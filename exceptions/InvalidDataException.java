package exceptions;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(){}

    @Override
    public String toString() {
        return "Dados invalidos.";
    }
}
