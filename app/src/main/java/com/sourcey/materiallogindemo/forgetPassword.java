package com.sourcey.materiallogindemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;

public class forgetPassword extends AppCompatActivity {

    private static final String TAG = "forgetPassword";

    TextView _loginLink;
    EditText _emailText;
    Button sifirlamabtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        sifirlamabtn=(Button)findViewById(R.id.btn_sifirlama);
        _emailText=(EditText)findViewById(R.id.forget_email);
        _loginLink=(TextView)findViewById(R.id.link_loginn);
        sifirlamabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgetPassword();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(forgetPassword.this ,LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });


    }
    public void forgetPassword() {
        Log.d(TAG, "forgetPassword");

        if (!validate()) {
            onforgetPasswordFailed();
            return;
        }

        sifirlamabtn.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(forgetPassword.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();


        String email = _emailText.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onforgetPasswordSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    public void onforgetPasswordSuccess() {
        sifirlamabtn.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onforgetPasswordFailed() {
        Toast.makeText(getBaseContext(), "Mail Gönderilmedi!", Toast.LENGTH_LONG).show();

        sifirlamabtn.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("Mailinizi Giriniz");
            valid = false;
        } else {
            _emailText.setError(null);
        }


        return valid;
    }
}
