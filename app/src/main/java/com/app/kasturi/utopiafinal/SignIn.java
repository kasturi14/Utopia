package com.app.kasturi.utopiafinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignIn extends AppCompatActivity
{

    private Button login_one;
    private ImageButton go_back;
    DatabaseHelper mydb;
    EditText uname;
    EditText upass;
    String uname1;
    String upass1;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mydb = new DatabaseHelper(this);
        login_one= (Button) findViewById(R.id.btn_login_wel);
        login_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        go_back = (ImageButton) findViewById(R.id.etback);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_mainactivity();
            }
        });

    }
    public void initialize()
    {
        uname = (EditText) findViewById(R.id.etlusername);
        upass = (EditText) findViewById(R.id.etlpassword);
        uname1 = uname.getText().toString();
        upass1 = upass.getText().toString();
        password = mydb.searchPass(uname1);
    }
    public void register()
    {
        initialize();
        if (!validate())
        {
            Toast.makeText(this, "SignUp Has Failed! Try Again.", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validate()
    {
        boolean valid =true;
        if(uname1.isEmpty())
        {
            uname.setError("The field cannot be empty");
          //  Toast.makeText(getApplicationContext(),"Enter a valid username or password.",Toast.LENGTH_LONG).show();
            valid=false;
        }
        if(upass1.isEmpty())
        {
            upass.setError("The field cannot be empty");
           // Toast.makeText(getApplicationContext(),"Enter a valid username or password.",Toast.LENGTH_LONG).show();
            valid=false;
        }

        if(password.equals(upass1) && !upass1.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Welcome "+ uname1,Toast.LENGTH_LONG).show();

            Intent intent1 = new Intent(this, WelcomePage.class);
            intent1.putExtra("username",uname1);
            startActivity(intent1);
            finish();
        }
        else
        {
          //  Toast.makeText(getApplicationContext(),"Enter a valid username or password.",Toast.LENGTH_LONG).show();
            valid=false;
        }
        return valid;
    }

    public void open_mainactivity()
    {
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        open_mainactivity();
    }
}
