package app.talkers.users.service.impl;

import app.talkers.users.exception.UserException;
import app.talkers.users.model.dao.User;
import app.talkers.users.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private Map<Integer, User> usersMap = new HashMap();
    private Integer count = 1;

    @Override
    public List<User> getAll() throws UserException {
        return new ArrayList<>(usersMap.values());
    }

    @Override
    public List<User> findByEmail(String email) throws UserException {
        return usersMap.values()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .collect(Collectors.toList());
    }

    @Override
    public User getById(Integer id) throws UserException {
        return Optional.ofNullable(usersMap.get(id))
                .orElseThrow(() -> new UserException(String.format("User with id %d was not found!", id)));
    }

    @Override
    public User create(User user) throws UserException {
        int id = count++;
        usersMap.put(id, user);
        user.setId(id);
        return user;
    }
}
