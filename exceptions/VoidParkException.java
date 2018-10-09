package exceptions;

public class VoidParkException extends RuntimeException {
    public VoidParkException(){}

    @Override
    public String toString() {
        return "Parque inexistente.";
    }
}
