package exceptions;

public class VoidParkException extends CustomException  {
    public VoidParkException(){}

    @Override
    public String toString() {
        return "Parque inexistente.";
    }
}
