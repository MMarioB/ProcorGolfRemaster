package com.example.procorgolfremaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText email = findViewById(R.id.edEmail);
        EditText password = findViewById(R.id.edPassword);
        Button loginBtn = findViewById(R.id.btnLogin);

        mAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String pass = password.getText().toString();
                boolean validarEmail = isValidEmail(mail);
                if (!validarEmail){
                    showAlertValidationEmail();
                } else {
                    if (TextUtils.isEmpty(pass)){
                        showAlertValidationPass();
                    } else {
                        validar(mail, pass);
                    }
                }
            }
        });
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void validar(String mail, String pass) {
        mAuth.signInWithEmailAndPassword(mail, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            showLoginCorrecto();
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Mensaje", "signInWithEmail:success");
                        } else {
                            showErrorLogin();
                            // If sign in fails, display a message to the user.
                            Log.w("Mensaje", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    public void showAlertValidationEmail() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this);
        alertDialog.setTitle("Error");
        alertDialog.setMessage("Email incorrecto");
        alertDialog.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void showAlertValidationPass() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this);
        alertDialog.setTitle("Error");
        alertDialog.setMessage("Password vacia");
        alertDialog.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void showErrorLogin() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this);
        alertDialog.setTitle("Error");
        alertDialog.setMessage("Email o contraseña incorrecta");
        alertDialog.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void showLoginCorrecto() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this);
        alertDialog.setTitle("Bienvenido");
        alertDialog.setMessage("Bienvenido!!");
        alertDialog.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Intent i = new Intent(getApplicationContext(), ElegirTorneoActivity.class);
                startActivity(i);
            }
        });
        alertDialog.show();
    }
}