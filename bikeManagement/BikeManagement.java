package bikeManagement;
import dataStructures.Queue;
import exceptions.*;

import java.io.Serializable;

public interface BikeManagement extends Serializable {

    void addUser(String idUser, String nif, String email, String phone, String name) throws DuplicateUserException;

    void removeUser(String idUser) throws VoidUserException, VeteranUserException;

    Queue<String> getUser(String userId) throws VoidUserException;

}
