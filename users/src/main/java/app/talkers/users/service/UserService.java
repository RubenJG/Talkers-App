package app.talkers.users.service;

import app.talkers.users.exception.UserException;
import app.talkers.users.model.dao.User;

import java.util.List;

public interface UserService {

    List<User> getAll() throws UserException;

    List<User> findByEmail(String email) throws UserException;

    User getById(Integer id) throws UserException;

    User create(User user) throws UserException;
}
