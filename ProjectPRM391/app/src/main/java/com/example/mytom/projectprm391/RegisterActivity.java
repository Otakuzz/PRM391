package com.example.mytom.projectprm391;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytom.projectprm391.Database.DBHelper;

/**
 * Created by Mytom on 3/3/2017.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mCancelbtn, mSubmitbtn;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mCancelbtn = (Button) findViewById(R.id.btnCancel_register);
        mSubmitbtn = (Button) findViewById(R.id.btnSubmit_register);
        mCancelbtn.setOnClickListener(this);
        mSubmitbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnCancel_register:
                Intent intent = new Intent(this, LoginActivity.class);
                finish();
                startActivity(intent);

                break;
            case R.id.btnSubmit_register:
                intent = new Intent(this, LoginActivity.class);
                dbHelper = new DBHelper(getApplicationContext(), DBHelper.DB_NAME, null, DBHelper.DB_VERSION);
            {
                EditText edtUserName = (EditText) findViewById(R.id.edtUsername_register);
                EditText edtUserPwd = (EditText) findViewById(R.id.edtPassword_register);
                EditText edtsecondPwd = (EditText) findViewById(R.id.edtRePass_register);
                EditText edtMail = (EditText) findViewById(R.id.edtEmail_register);

                if ((edtUserName.getText().toString() == null || edtUserName.getText().toString().isEmpty() ) ||
                        (edtUserPwd.getText().toString() == null || edtUserPwd.getText().toString().isEmpty()) ||
                        (edtsecondPwd.getText().toString() == null || edtsecondPwd.getText().toString().isEmpty()) ||
                        (edtMail.getText().toString() == null || edtMail.getText().toString().isEmpty()) ) {
                    Toast.makeText(this, "Please enter all required fields", Toast.LENGTH_SHORT).show();
                    break;
                }

                if (edtUserPwd.getText().toString().compareTo(edtsecondPwd.getText().toString()) != 0) {
                    Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show();
                    break;
                }

                boolean isCreated = dbHelper.insertNewUser(edtUserName.getText().toString(), edtMail.getText().toString(),
                        edtUserPwd.getText().toString());

                if (isCreated) {
                    finish();
                    startActivity(intent);
                    Toast.makeText(this, "Create account successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Create account failed!", Toast.LENGTH_SHORT).show();
                }

            }
            break;
        }
    }
}