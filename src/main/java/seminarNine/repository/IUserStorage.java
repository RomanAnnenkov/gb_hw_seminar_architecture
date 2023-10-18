package seminarNine.repository;

import seminarNine.exceptions.UserNotFountException;
import seminarNine.model.User;

import java.util.List;

public interface IUserStorage {
    User addUser(String userName);
    User deleteUser(int userId) throws UserNotFountException;
    List<User> getUsers();
}
