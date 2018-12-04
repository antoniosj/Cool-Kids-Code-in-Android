package com.antoniosj.daggerexample.model;

import javax.inject.Inject;

public class User {

    @Inject
    public User(String login, String password) {
        this.login=login;
        this.password=password;
    }

    public String login;
    public String password;
}
