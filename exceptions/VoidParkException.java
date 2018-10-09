package exceptions;

public class VoidParkException extends RuntimeException implements CustomException  {
    public VoidParkException(){}

    @Override
    public String toString() {
        return "Parque inexistente.";
    }
}
