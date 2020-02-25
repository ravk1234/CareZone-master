package com.ujjwalsingh.carezone;

//import android.support.v7.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Signup extends AppCompatActivity {

    FirebaseAuth mAuth;
    Button button_register;
    boolean val;
    EditText fullname, email,password;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        fullname =findViewById(R.id.fullname);
        email =findViewById(R.id.email);
        password =findViewById(R.id.password);
        button_register = findViewById(R.id.signup);


        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String u_username = fullname.getText().toString();
                    String u_email = email.getText().toString();
                    String u_password = password.getText().toString();
                    //String u_password = rpassword.getText().toString();
                    if (TextUtils.isEmpty(u_username) || TextUtils.isEmpty(u_email) || TextUtils.isEmpty(u_password)) {
                        Toast.makeText(Signup.this, "All credentials are required!", Toast.LENGTH_SHORT).show();
                    }  else {
                        register(u_username, u_email, u_password);
                    }
                    /*if(u_email.isEmpty()){
                        email.setError("Please Enter Email Id");
                        email.requestFocus();
                    }
                    else if (u_password.isEmpty()){
                        password.setError("Please enter your password");
                        password.requestFocus();
                    }
                    else if(u_email.isEmpty() && u_password.isEmpty() && username.isEmpty()){
                        Toast.makeText(Signup.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                    }
                    else if(!(u_email.isEmpty() && u_password.isEmpty() && username.isEmpty())){

                    }*/
                    

                }
                    //button_register.setEnabled(false);

        });
    }

    public void register(final String username, String email, String password){
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    //FirebaseUser firebaseUser = mAuth.getCurrentUser();
                    //assert firebaseUser != null;
                    //String userUId = firebaseUser.getUid();
                    /*reference = FirebaseDatabase.getInstance().getReference("Users").child(userUId);
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("id",userUId);
                    hashMap.put("fullname",username);
                    //hashMap.put("imgUrl","default");
                    //hashMap.put("status","offline");
                    hashMap.put("search",username.toLowerCase());

                    reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(Signup.this,MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });*/
                    Toast.makeText(Signup.this,"Registered Successfully",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(Signup.this, "Unable to Register with this username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}




