package com.ecommerce.blooms.service;

import com.ecommerce.blooms.exception.EntityNotFoundException;
import com.ecommerce.blooms.model.User;
import com.ecommerce.blooms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " does not exist!")));
    }

    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("User with id " + id + " does not exist!");
        }
        userRepository.deleteById(id);
    }

    public Optional<User> updateUser(User user, Long id) {
        Optional<User> userToUpdate = userRepository.findById(id);
        if (userToUpdate.isEmpty()) {
            throw new EntityNotFoundException("User with id " + id + " does not exist!");
        }
        User updatedUser = userToUpdate.get();

        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(user.getPassword());

        return Optional.of(userRepository.save(updatedUser));
    }
}
