package pms.api.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pms.api.models.User;
import pms.api.repositories.RolesRepository;
import pms.api.repositories.UsersRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UsersRepository userRepository;
    private final RolesRepository rolesRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl
            (UsersRepository userRepository, RolesRepository rolesRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(User user) {
        user.setRole(rolesRepository.findByName("ROLE_USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        return result;
    }

    @Override
    public User findByLogin(String login) {
        User result = userRepository.findByLogin(login);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findOne(id);
        return result;
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException();
    }
}
