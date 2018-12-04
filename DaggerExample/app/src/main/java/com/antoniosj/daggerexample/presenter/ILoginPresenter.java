package com.antoniosj.daggerexample.presenter;

import com.antoniosj.daggerexample.MainActivity;
import com.antoniosj.daggerexample.model.User;

public interface ILoginPresenter {

    void setView(MainActivity view);
    void loginButtonClicked();
    User getCurrentUser();
    void createUser(String login, String password);
}
