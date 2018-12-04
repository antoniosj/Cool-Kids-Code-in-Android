package com.antoniosj.daggerexample.presenter;

import android.widget.Toast;

import com.antoniosj.daggerexample.MainActivity;
import com.antoniosj.daggerexample.model.User;

public class LoginPresenter implements ILoginPresenter {

    MainActivity view;
    ILoginRepository repository;

    public LoginPresenter(ILoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void setView(MainActivity view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        User user = getCurrentUser();
        if (view != null && user != null) {
            if (user.login.isEmpty() || user.password.isEmpty()) {
                Toast.makeText(view, "error", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(view, "saving", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(view, "error", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public User getCurrentUser() {
        return repository.getUser();
    }

    @Override
    public void createUser(String login, String password) {
        User user = new User(login, password);
        repository.saveUser(user);
    }
}
