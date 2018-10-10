package exceptions;

public class DuplicateBikeException extends CustomException {
    public DuplicateBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta existente.";
    }
}
