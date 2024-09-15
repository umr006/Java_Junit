package edu.school21.Service;

import edu.school21.Exception.AlreadyAuthenticatedException;
import edu.school21.Exception.EntityNotFoundException;
import edu.school21.Models.User;
import edu.school21.Repository.UserRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {

    private UserRepository userRepository;

    public UserRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new EntityNotFoundException("User not found");
        }
        if (user.isAuthSuccessStatus()) {
            throw new AlreadyAuthenticatedException("AlreadyAuthenticatedException");
        }
        if (user.getPassword().equals(password)) {
            user.setAuthSuccessStatus(true);
            userRepository.update(user);
            return user.isAuthSuccessStatus();
        }
        return false;
    }

    @Override
    public User findByLogin(String login) {
       return userRepository.findByLogin(login);
    }

    @Override
    public void update(User user) {

    }


    //    private final Connection connection;
//    private final String FIND_BY_LOGIN_SQL = "select * from users where id= ?";
//    private final String UPDATE_USER_SQL = "UPDATE user set login = ?, password = ?, authSuccessStatus = ?  where id = ?";
//    public UserRepositoryImpl(DataSource dataSource) throws SQLException {
//        connection = dataSource.getConnection();
//    }
    //    @Override
//    public User findByLogin(String login) {
//        return userRepository.findByLogin(login);
//        User user = null;
//        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_LOGIN_SQL)) {
//            preparedStatement.setString(1, login);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if(!resultSet.next()) {
//                throw new EntityNotFoundException("User not found");
//            }
//
//            user = new User(
//              resultSet.getLong("id"),
//              resultSet.getString("login"),
//              resultSet.getString("password"),
//              resultSet.getBoolean("authSuccessStatus")
//            );
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return user;
//    }

//    @Override
//    public void update(User user) {
//        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL)) {
//            preparedStatement.setString(1, user.getLogin());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getPassword());
//            preparedStatement.setBoolean(4, user.isAuthSuccessStatus());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}






















