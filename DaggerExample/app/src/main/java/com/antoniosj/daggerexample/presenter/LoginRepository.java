package com.antoniosj.daggerexample.presenter;

import com.antoniosj.daggerexample.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class LoginRepository implements ILoginRepository {

    User user;
    List users = new ArrayList<User>();

    @Override
    public User getUser() {
        if (user != null) {
         //   user = new User();
        }
        return user;
    }

    @Override
    public void saveUser(User user) {

        if (user == null) {
            user = getUser();
        }

        users.add(user);
    }
}
