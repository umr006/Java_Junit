package edu.school21.Models;

import java.util.Objects;

public class User {
    private long id;
    private String login;
    private String password;
    private boolean authSuccessStatus;

    public User(long id, String login, String password, boolean authSuccessStatus) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.authSuccessStatus = authSuccessStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthSuccessStatus() {
        return authSuccessStatus;
    }

    public void setAuthSuccessStatus(boolean authSuccessStatus) {
        this.authSuccessStatus = authSuccessStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && authSuccessStatus == user.authSuccessStatus && Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, authSuccessStatus);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", authSuccessStatus=" + authSuccessStatus +
                '}';
    }
}
