package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public String username = "username";
    public String password = "StrongPassword123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText vUsername = findViewById(R.id.et_username);
        EditText vPassword = findViewById(R.id.et_password);
        Button vSignIn = findViewById(R.id.btn_sign_in);

        vSignIn.setOnClickListener(view -> {
            String uUsername = vUsername.getText().toString();
            String uPassword = vPassword.getText().toString();

            if (Objects.equals(this.username, uUsername) && Objects.equals(this.password, uPassword)) {

                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);

            } else
                Toast.makeText(this, "Either the username or password is incorrect", Toast.LENGTH_SHORT).show();
        });

    }
}