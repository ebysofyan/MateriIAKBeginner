package iak.app.com.iakapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    EditText tvUsername;
    EditText tvPassword;
    Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    void init() {
        tvUsername = findViewById(R.id.username);
        tvPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lakukanLogin(v);
            }
        });
    }

    User getUser() {
        User user = new User();
        user.setUsername("peserta");
        user.setPassword("iak");
        user.setNama("IAK Batch 3");

        return user;
    }

    void lakukanLogin(View view) {
        String username = tvUsername.getText().toString();
        String password = tvPassword.getText().toString();

        if (username.equals(getUser().getUsername()) && password.equals(getUser().getPassword())) {
            Intent intent = new Intent(this, MainActivity.class);

            Bundle bundle = new Bundle();
            bundle.putParcelable("USER_OBJECT", getUser());
            intent.putExtras(bundle);

            startActivity(intent);
            finish();
        } else {
            Snackbar.make(view, "Gagal Login", Snackbar.LENGTH_LONG).show();
        }
    }
}

