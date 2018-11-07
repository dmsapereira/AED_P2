package bikeManagement.exceptions.park;

import bikeManagement.exceptions.CustomException;

/**
 * <code>Exception</code> for when there's an attempt at creating an existing <code>Park</code>
 */
public class DuplicateParkException extends CustomException {
    public DuplicateParkException(){}
}
