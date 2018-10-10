package exceptions;

public class InvalidDataException extends CustomException  {
    public InvalidDataException(){}

    @Override
    public String toString() {
        return "Dados invalidos.";
    }
}
