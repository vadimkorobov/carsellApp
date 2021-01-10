package edu.vadimkorobov.carsell.services.impl;

import edu.vadimkorobov.carsell.entity.User;
import edu.vadimkorobov.carsell.repository.UserRepository;
import edu.vadimkorobov.carsell.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User addAccount(User user) {
        User savedUser = userRepository.saveAndFlush(user);

        return savedUser;
    }


    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User editAccount(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
