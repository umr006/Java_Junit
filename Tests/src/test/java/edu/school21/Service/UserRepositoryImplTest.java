package edu.school21.Service;
import edu.school21.Exception.EntityNotFoundException;
import edu.school21.Models.User;
import edu.school21.Exception.*;
import edu.school21.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class UserRepositoryImplTest {
    private final String RIGHT_LOGIN = "right_login";
    private final String RIGHT_PASS = "right_pass";
    private final String WRONG_LOGIN = "wrong_login";
    private final String WRONG_PASS = "wrong_pass";

    private User user;
    private UserRepository usersRepositoryMock = Mockito.mock(UserRepository.class);
    private UserRepositoryImpl usersServiceMock = new UserRepositoryImpl(usersRepositoryMock);

    @BeforeEach
    void beforeEach() {
        user = new User(1, RIGHT_LOGIN, RIGHT_PASS, false);
        Mockito.when(usersRepositoryMock.findByLogin(RIGHT_LOGIN)).thenReturn(user);
        Mockito.when(usersRepositoryMock.findByLogin(WRONG_LOGIN)).thenReturn(null);
    }

    @Test
    void authenticateEntityNotFoundExceptionTest() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> usersServiceMock.authenticate(WRONG_LOGIN, WRONG_PASS));
    }

    @Test
    void authenticateAlreadyAuthenticatedExceptionTest() {
        User authenticateUser = user;
        authenticateUser.setAuthSuccessStatus(true);

        Assertions.assertThrows(AlreadyAuthenticatedException.class, () -> usersServiceMock.authenticate(RIGHT_LOGIN, RIGHT_PASS));
    }

    @Test
    void authenticateFalse() {
        Assertions.assertFalse(usersServiceMock.authenticate(RIGHT_LOGIN, WRONG_PASS));
    }

    @Test
    void authenticateTrue() {
        Assertions.assertTrue(usersServiceMock.authenticate(RIGHT_LOGIN, RIGHT_PASS));
    }
}
