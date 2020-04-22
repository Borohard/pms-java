package pms.api.services;

import pms.api.models.User;

import java.util.List;

public interface UserService {
    void register(User user);

    List<User> getAll();

    User findByLogin(String username);

    User findById(Long id);

    void delete(Long id);
}
