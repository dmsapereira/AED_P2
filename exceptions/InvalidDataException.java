package exceptions;

public class InvalidDataException extends RuntimeException implements CustomException  {
    public InvalidDataException(){}

    @Override
    public String toString() {
        return "Dados invalidos.";
    }
}
