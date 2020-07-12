package com.ae.users.service;

import com.ae.users.entity.User;
import com.ae.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public User createUser(final User user) {
        User userCreated = getUserByUsername(user.getUsername());
        if (userCreated != null) {
            return userCreated;
        }
        repository.save(user);
        return getUserByUsername(user.getUsername());
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        User userCreated = getUserByUsername(user.getUsername());
        if (userCreated != null) {
            repository.save(user);
            return getUserByUsername(user.getUsername());
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }
}
