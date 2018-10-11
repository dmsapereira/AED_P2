package exceptions;

/**
 * <code>Exception</code> for when there's an attempt at listing a <code>User</code>'s <code>PickUp</code>s but he's never used the service
 */
public class VoidPickupsException extends CustomException  {
    public VoidPickupsException(){}

    @Override
    public String toString() {
        return "Utilizador nao utilizou o sistema.";
    }
}
