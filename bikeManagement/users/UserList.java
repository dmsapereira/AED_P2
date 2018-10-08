package bikeManagement.users;

import exceptions.DuplicateUserException;
import exceptions.VeteranUserException;
import exceptions.VoidUserException;

public interface UserList {

    void addUser(String idUser, String nif, String email, String phone, String name) throws DuplicateUserException;

    void removeUser(String idUser) throws VoidUserException, VeteranUserException;
}
