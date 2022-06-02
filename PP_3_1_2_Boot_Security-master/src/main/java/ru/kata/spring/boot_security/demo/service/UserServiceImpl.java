package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repo.RoleRepository;
import ru.kata.spring.boot_security.demo.repo.UserRepository;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private RoleRepository roleRepository;

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User findById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {

    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

}
