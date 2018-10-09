package exceptions;

public class VoidBikeException extends RuntimeException implements CustomException  {
    public VoidBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta inexistente.";
    }
}
