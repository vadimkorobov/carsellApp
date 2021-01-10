package edu.vadimkorobov.carsell.services;

import edu.vadimkorobov.carsell.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User addAccount(User user);
    void delete(long id);
    User getByLogin(String login);
    User editAccount(User user);
    List<User> getAll();

}