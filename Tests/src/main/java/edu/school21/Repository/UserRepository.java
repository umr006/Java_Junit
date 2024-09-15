package edu.school21.Repository;

import edu.school21.Models.User;

public interface UserRepository {
    User findByLogin(String login);
    void update(User user);
}
