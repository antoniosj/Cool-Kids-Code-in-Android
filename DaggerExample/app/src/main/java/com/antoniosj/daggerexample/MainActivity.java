package com.antoniosj.daggerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.antoniosj.daggerexample.modules.ApplicationComponent;
import com.antoniosj.daggerexample.modules.ApplicationModule;
import com.antoniosj.daggerexample.modules.DaggerApplicationComponent;
import com.antoniosj.daggerexample.presenter.ILoginPresenter;
import com.antoniosj.daggerexample.presenter.ILoginRepository;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText password;
    Button btLogin;

    @Inject
    ILoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ApplicationComponent component = DaggerApplicationComponent.builder().build();
        component.inject(this);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.createUser(login.toString(), password.toString());
            }
        });
    }

    void initViews() {
        login = findViewById(R.id.et_login);
        password = findViewById(R.id.et_password);
        btLogin = findViewById(R.id.bt_login);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }
}
