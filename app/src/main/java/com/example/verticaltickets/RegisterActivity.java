package com.example.verticaltickets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterActivity extends AppCompatActivity {

    EditText Mname, Msurname, MphoneNumber, Mmail, Mpassword, Mpassword2;
    ProgressBar progressBar;
    TextView goToLogin, alreadyHave;
    Button mRegisterBtn;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        // nesnelerimizi bağladık.

        Mname =       findViewById(R.id.editTextTextName);
        Msurname =    findViewById(R.id.editTextTextSurName);
        Mmail =       findViewById(R.id.editTextTextEmailAddress);
        Mpassword=    findViewById(R.id.editTextNumberPassword);
        Mpassword2 =  findViewById(R.id.editTextNumberPassword2);
        MphoneNumber= findViewById(R.id.editTextPhoneNumber);
        progressBar=  findViewById(R.id.progressBar);
        goToLogin =   findViewById(R.id.textVGoToLogin);
        alreadyHave=  findViewById(R.id.textVAlreadyHave);
        mRegisterBtn= findViewById(R.id.register_registerButton);

        // kullanıcı kayıtlı mı değil mi öğrenmek için;

        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = Mname.getText().toString().trim();
                String password2 = Mpassword2.getText().toString().trim();
                String surname = Msurname.getText().toString().trim();
                String mail = Mmail.getText().toString().trim();
                String password = Mpassword.getText().toString().trim();


                if (TextUtils.isEmpty(mail)) {
                    Mmail.setError("E-mail is required.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Mpassword.setError("Password is required.");
                    return;
                }

                if (password.length() < 6) {
                    Mpassword.setError("Password must be at least 6 characters!");

                    return;
                }
                if(!password.equals(password2)){
                    Mpassword2.setError("Passwords do not matches!");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);


                //kullanıcıyı firebase e kaydettirme kısmı

                mAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "User is created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    } });



            }
        });
        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });
    }


    /* public void createUser(View view){

        EditText editTextEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        String mail = editTextEmail.getText().toString();

        EditText editTextPassword = (EditText) findViewById(R.id.editTextNumberPassword);
        String password = editTextPassword.getText().toString();

        EditText editTextPassword2 = (EditText) findViewById(R.id.editTextNumberPassword2);
        String password2 = editTextPassword2.getText().toString();

        EditText editName = (EditText) findViewById(R.id.editTextTextName);
        String name = editName.getText().toString();

        EditText editSurname = (EditText) findViewById(R.id.editTextTextSurName);
        String surname = editSurname.getText().toString();

        EditText editPhone = (EditText) findViewById(R.id.editTextPhoneNumber);
























        Intent mainIntent = new Intent(this, MainPageActivity.class);
        startActivity(mainIntent);

        if (!password.equals(password2)) {
            Toast.makeText(RegisterActivity.this, "Password or Confirm password must be the same.", Toast.LENGTH_SHORT).show();
        }
        else{
            mAuth.createUserWithEmailAndPassword(mail, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                FirebaseUser user = mAuth.getCurrentUser();
                                startActivity(mainIntent);
                                System.out.println(user.getEmail());

                            }
                            else{
                                Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
        }
    }

    public void Transfer_Log(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    } */


}