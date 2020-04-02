package pms.api.services;

import pms.api.models.User;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByLogin(String username);

    void delete(Long id);
}
