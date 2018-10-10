package exceptions;

public class UsedBikeException extends CustomException  {
    public UsedBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta ja foi utilizada.";
    }
}
