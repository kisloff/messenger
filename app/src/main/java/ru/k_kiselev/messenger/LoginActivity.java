package ru.k_kiselev.messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Кирилл on 21.06.2015.
 */
public class LoginActivity extends Activity implements View.OnClickListener{

    EditText editEmail, editPassword;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        editEmail = (EditText)findViewById(R.id.et_editEmail);
        editPassword = (EditText)findViewById(R.id.et_editPassword);
        login = (Button)findViewById(R.id.btn_login);

        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(this, ContactList.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
    }

}
