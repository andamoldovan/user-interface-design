package com.example.anda.colocviu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username = findViewById(R.id.editTextUsername);
        final EditText password = findViewById(R.id.editTextPassword);

        Button loginBtn = findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                TextView test = findViewById(R.id.test);
                test.setText(username.getText().toString().equals("anda") + "  " + password.getText().toString().equals("11"));

                if(username.getText().toString().equals("anda") && password.getText().toString().equals("11")){

                    Intent intent = new Intent(MainActivity.this, ListActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }

    private void loginAction(EditText username, EditText password) {
    }
}
