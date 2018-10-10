package exceptions;

public class UnusedBikeException extends CustomException  {
    public UnusedBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta nao foi utilizada.";
    }
}
