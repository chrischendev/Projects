package com.chris.base.scanloginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin, btnScan;
    private EditText etUsername,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnLogin = findViewById(R.id.btn_app_login);
        btnScan = findViewById(R.id.btn_scan);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        etUsername.setText("chenfabao");
        etPassword.setText("123456");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                //SharedPreferences sp = getSharedPreferences("loginUser",MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                String username = etUsername.getText().toString().trim();
                edit.putString("username", username);
                String password = etPassword.getText().toString().trim();
                edit.putString("password", password);
                edit.commit();
                //setTitle(username + " : " + password);
                Toast.makeText(MainActivity.this, "APP登录成功", Toast.LENGTH_SHORT).show();
            }
        });

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ScanActivity.class));
            }
        });

    }
}
