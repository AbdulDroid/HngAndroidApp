package team_galaxy.hnginterns.hngmobileapp.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import team_galaxy.hnginterns.hngmobileapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    @BindView(R.id.email_address)
    EditText emailView;
    @BindView(R.id.password)
    EditText passwordView;
    @BindView(R.id.sign_in_button)
    Button signIn;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);

        emailView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
                    emailView.setError("Invalid Email address");
                } else if (TextUtils.isEmpty(s)) {
                    emailView.setError("This field is required");
                } else {
                    emailView.setError(null);
                }
                showSignInButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        passwordView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().matches("^(?=.*\\d).{6,10}$")) {
                    passwordView.setError("Must have at least 1digit, and must be up to 6 characters");
                } else if (TextUtils.isEmpty(s)) {
                    passwordView.setError("This field cannot be empty");
                } else {
                    passwordView.setError(null);
                }
                showSignInButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        showSignInButton();
        return view;
    }

    private void showSignInButton() {
        if (Patterns.EMAIL_ADDRESS.matcher(emailView.getText().toString()).matches() &&
                passwordView.getText().toString().matches("^(?=.*\\d).{6,10}$")) {
            signIn.setVisibility(View.VISIBLE);
        } else {
            signIn.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.sign_in_button)
    public void clickSignIn() {
        //TODO: Make a call to the API to authenticate user
    }


    @OnClick(R.id.text_forgot_password)
    public void clickForgotPassword() {
        Toast.makeText(getActivity(), "Yet to be implemented", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.text_sign_up)
    public void openSignUpFragment() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_user_authentication, new SignUpFragment())
                .commit();
    }

}
