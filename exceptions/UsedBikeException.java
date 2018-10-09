package exceptions;

public class UsedBikeException extends RuntimeException implements CustomException  {
    public UsedBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta ja foi utilizada.";
    }
}
