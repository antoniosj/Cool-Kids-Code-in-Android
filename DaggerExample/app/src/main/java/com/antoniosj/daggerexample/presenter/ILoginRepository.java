package com.antoniosj.daggerexample.presenter;

import com.antoniosj.daggerexample.model.User;

public interface ILoginRepository {

    User getUser();

    void saveUser(User user);
}
