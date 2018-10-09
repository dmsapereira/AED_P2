package exceptions;

public class UsedBikeException extends RuntimeException {
    public UsedBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta ja foi utilizada.";
    }
}
