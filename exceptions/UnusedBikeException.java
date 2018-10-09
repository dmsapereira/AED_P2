package exceptions;

public class UnusedBikeException extends RuntimeException implements CustomException  {
    public UnusedBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta nao foi utilizada.";
    }
}
