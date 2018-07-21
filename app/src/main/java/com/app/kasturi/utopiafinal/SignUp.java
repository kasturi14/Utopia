package com.app.kasturi.utopiafinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    private EditText first;
    private EditText last;
    private EditText email1;
    private EditText user1;
    private EditText phone1;
    private EditText password1;
    private EditText c_password;
    private String s_first;
    private String s_last;
    private String s_email;
    private String s_user;
    private String s_password;
    private String s_c_password;
    private String s_phone;
    DatabaseHelper mydb;
    Button register1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mydb=new DatabaseHelper(this);
        first = (EditText) findViewById(R.id.firstName);
        last = (EditText) findViewById(R.id.lastName);
        email1 = (EditText) findViewById(R.id.email);
        user1 = (EditText) findViewById(R.id.username);
        password1 = (EditText) findViewById(R.id.password);
        c_password = (EditText) findViewById(R.id.confirmPass);
        phone1 = (EditText) findViewById(R.id.phoneNumber);
        register1 = (Button) findViewById(R.id.btn_signin_wel);
        ImageButton back = (ImageButton) findViewById(R.id.etback);

        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
                AddData();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });
    }
    public  void AddData()
    {

        boolean isInserted = mydb.insertData(first.getText().toString(),last.getText().toString(),email1.getText().toString(),
                phone1.getText().toString(),user1.getText().toString(),password1.getText().toString() );
       // if(isInserted == true)
        //    Toast.makeText(SignUp.this,"Signed In",Toast.LENGTH_LONG).show();
      //  else
          //  Toast.makeText(SignUp.this,"Sign up Failed",Toast.LENGTH_LONG).show();
    }

    public void register()
    {
        initialize();
        if (!validate() || !validatePass()) {
            Toast.makeText(this, "SignUp Has Failed! Try Again.", Toast.LENGTH_SHORT).show();
        } else {
            onSignUpSuccess();
        }
    }
    public void openHome()
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }

    public void onSignUpSuccess()
    {
        Intent intent = new Intent(this,WelcomePage.class);
        startActivity(intent);
        finish();
    }
    public boolean validate()
    {
        boolean valid =true;
        if(s_first.isEmpty())
        {
            first.setError("The field cannot be empty");
            valid=false;
        }
        if(s_first.length()>10)
        {
            first.setError("Maximum 10 characters allowed");
        }
        if(s_last.isEmpty())
        {
            first.setError("The field cannot be empty");
            valid=false;
        }
        if(s_last.length()>15)
        {
            first.setError("Maximum 15 characters allowed");
        }
        if(s_user.isEmpty())
        {
            user1.setError("The field cannot be empty");
            valid=false;
        }
        if( s_user.length()>32)
        {
            user1.setError("Maximum 32 characters allowed");
        }
        if(s_phone.isEmpty())
        {
            phone1.setError("The field cannot be empty");
            valid=false;
        }

        if(s_phone.length()!=10)
        {
            phone1.setError("Enter a valid phone number");
            valid=false;
        }
        if(s_email.isEmpty())
        {
            email1.setError("The field cannot be empty");
            valid=false;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(s_email).matches())
        {
            email1.setError("Enter a valid Email Address");
            valid=false;
        }
        if(s_password.isEmpty() || s_password.length()<8)
        {
            password1.setError("Your password should contain a minimum of 8 characters");
            valid=false;
        }
        if(s_c_password.isEmpty())
        {
            c_password.setError("The field cannot be empty");
            valid=false;
        }

        if(s_c_password.isEmpty() || !s_c_password.equals(s_password))
        {
            c_password.setError("Your password is not matchin");
            valid=false;
        }
        return valid;
    }

    public boolean validatePass()
    {
        boolean valid = true;
        Pattern uppercase = Pattern.compile("[A-Z]");
        Pattern lowercase = Pattern.compile("[a-z]");
        Pattern digit = Pattern.compile("[0-9]");
        if(!lowercase.matcher(s_password).find() || !uppercase.matcher(s_password).find()|| !digit.matcher(s_password).find())
        {
            password1.setError("Your password should a contain uppercase and lowercase characters and digits");
            valid = false;
        }
        return  valid;
    }
    public void initialize()
    {
        s_first = first.getText().toString().trim();
        s_last = last.getText().toString().trim();
        s_email = email1.getText().toString().trim();
        s_user = user1.getText().toString().trim();
        s_password = password1.getText().toString().trim();
        s_c_password = c_password.getText().toString().trim();
        s_phone = phone1.getText().toString().trim();
    }

    @Override
    public void onBackPressed()
    {
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
        finish();
    }

}
