package com.example.mytom.projectprm391;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytom.projectprm391.Database.DBHelper;
import com.example.mytom.projectprm391.Item.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mLoginBtn, mRegisterBtn;
    private EditText mUsernameEdt, mPasswordEdt;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLoginBtn = (Button) findViewById(R.id.btn_login);
        mRegisterBtn = (Button) findViewById(R.id.btn_register);
        mUsernameEdt = (EditText) findViewById(R.id.edt_username);
        mPasswordEdt = (EditText) findViewById(R.id.edt_password);
        mLoginBtn.setOnClickListener(this);
        mRegisterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id_view = v.getId();
        switch (id_view){
            case R.id.btn_login:
                Intent intent = new Intent(this, HomeActivity.class);
                dbHelper = new DBHelper(getApplicationContext(), DBHelper.DB_NAME, null, DBHelper.DB_VERSION);
            {
                EditText edtUserName = (EditText) findViewById(R.id.edt_username);
                EditText edtUserPwd = (EditText) findViewById(R.id.edt_password);

                if ((edtUserName.getText().toString() == null || edtUserName.getText().toString().isEmpty() ) ||
                        (edtUserPwd.getText().toString() == null || edtUserPwd.getText().toString().isEmpty()) ) {
                    Toast.makeText(this, "Input username or password", Toast.LENGTH_SHORT).show();
                    break;
                }

                User user = dbHelper.getUserByName(edtUserName.getText().toString());

                if (user.getUserName() != null && user.getUserName().compareTo(edtUserName.getText().toString()) == 0 &&
                        user.getPassword().compareTo(edtUserPwd.getText().toString()) == 0) {
                    finish();
                    startActivity(intent);
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Wrong account entry, try again or register!", Toast.LENGTH_SHORT).show();
                }

            }

            break;

            case R.id.btn_register:
                intent = new Intent(this, RegisterActivity.class);
                finish();

                startActivity(intent);
                break;
        }
    }
}
