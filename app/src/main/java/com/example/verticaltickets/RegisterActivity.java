package com.example.verticaltickets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
    }

    public void createUser(View view){
        EditText editTextEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        String mail = editTextEmail.getText().toString();

        EditText editTextPassword = (EditText) findViewById(R.id.editTextNumberPassword);
        String password = editTextPassword.getText().toString();

        EditText editTextPassword2 = (EditText) findViewById(R.id.editTextNumberPassword2);
        String password2 = editTextPassword2.getText().toString();

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

    }
}