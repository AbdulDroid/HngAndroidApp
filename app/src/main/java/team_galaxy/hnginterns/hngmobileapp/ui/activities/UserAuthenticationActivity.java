package team_galaxy.hnginterns.hngmobileapp.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import team_galaxy.hnginterns.hngmobileapp.R;
import team_galaxy.hnginterns.hngmobileapp.ui.fragments.LoginFragment;

public class UserAuthenticationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_authentication);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_user_authentication,new LoginFragment())
                .commit();
    }
}

