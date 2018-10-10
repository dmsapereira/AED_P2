package exceptions;

public class VoidBikeException extends CustomException  {
    public VoidBikeException(){}

    @Override
    public String toString() {
        return "Bicicleta inexistente.";
    }
}
