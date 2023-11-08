package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class logintest extends AppCompatActivity {

    EditText phone, otp;
    Button btngenOTP, btnverify;
    FirebaseAuth mAuth;
    String verificationID;
    Spinner countryCodeSpinner;
    ProgressBar loadingProgressBar;
    TextView loadingText;
    LinearLayout mainlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if the user is already logged in
        if (isUserLoggedIn()) {
            // If logged in, move to the main activity
            startActivity(new Intent(this, MainActivity.class));
            finish(); // Close the login activity
            return;
        }
        setContentView(R.layout.activity_logintest);
        phone = findViewById(R.id.phone);
        otp = findViewById(R.id.otp);
        btngenOTP = findViewById(R.id.btngenerateOTP);
        btnverify = findViewById(R.id.btnverifyOTP);
        mAuth = FirebaseAuth.getInstance();
        countryCodeSpinner = findViewById(R.id.countryCodeSpinner);
        mainlay = findViewById(R.id.layoutload1);
        loadingProgressBar = findViewById(R.id.loadingProgressBar);
        loadingText = findViewById(R.id.loadingText);

        // Get the array of Asian country codes with names from resources
        String[] countryCodesWithNames = getResources().getStringArray(R.array.asian_country_codes);

        // Create an ArrayAdapter to populate the Spinner with the country codes and names
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countryCodesWithNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter to the Spinner
        countryCodeSpinner.setAdapter(adapter);

        btngenOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedCountryCodeWithSpace = countryCodeSpinner.getSelectedItem().toString();
                String phoneNumber = phone.getText().toString();

                if (TextUtils.isEmpty(phoneNumber)) {
                    Toast.makeText(logintest.this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();
                } else {
                    // Show loading indicator
                    loadingProgressBar.setVisibility(View.VISIBLE);
                    loadingText.setVisibility(View.VISIBLE);
                    mainlay.setVisibility(View.VISIBLE);
                    // Split the selected item to get the country code part
                    String[] parts = selectedCountryCodeWithSpace.split(" ");
                    String selectedCountryCode = parts[0];
                    // Concatenate the selected country code with the user's input
                    String fullPhoneNumber = selectedCountryCode + phoneNumber;
                    sendVerificationCode(fullPhoneNumber);
                }
            }
        });

        btnverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = otp.getText().toString();
                if (!TextUtils.isEmpty(code)) {
                    // Show loading indicator
                    loadingProgressBar.setVisibility(View.VISIBLE);
                    loadingText.setVisibility(View.VISIBLE);
                    mainlay.setVisibility(View.VISIBLE);

                    verifyCode(code);
                } else {
                    Toast.makeText(logintest.this, "Enter the OTP code", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Define a method to check if the user is logged in based on SharedPreferences
    private boolean isUserLoggedIn() {
        SharedPreferences sharedPreferences = getSharedPreferences("login_prefs", MODE_PRIVATE);
        return sharedPreferences.getBoolean("isLoggedIn", false);
    }

    // Define a method to set the user as logged in
    private void setUserLoggedIn() {
        SharedPreferences sharedPreferences = getSharedPreferences("login_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
    }

    // Define a method to hide the loading indicator and text
    private void hideLoadingIndicator() {
        loadingProgressBar.setVisibility(View.GONE);
        loadingText.setVisibility(View.GONE);
        mainlay.setVisibility(View.GONE);
    }

    private void sendVerificationCode(String phoneNumber) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,    // Unit of timeout
                this,               // Activity (context) for callbacks
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                        // This callback will be invoked in case of auto-verification or instant verification.
                        // You can proceed with signing in the user here.
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        Toast.makeText(logintest.this, "Verification failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        // Hide loading indicator on failure
                        hideLoadingIndicator();
                    }

                    @Override
                    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        verificationID = s;
                        Toast.makeText(logintest.this, "Verification code sent", Toast.LENGTH_SHORT).show();
                        // Hide loading indicator after code is sent
                        hideLoadingIndicator();
                    }
                });
    }

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(logintest.this, "Authentication successful", Toast.LENGTH_SHORT).show();
                        // You can proceed with the user's authenticated session here.
                        // Mark the user as logged in
                        setUserLoggedIn();
                        // Redirect to the main activity
                        Intent intent = new Intent(logintest.this, MainActivity.class);
                        startActivity(intent);
                        finish(); // Close the current activity to prevent going back to the login screen
                    } else {
                        Toast.makeText(logintest.this, "Authentication failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        // Hide loading indicator on failure
                        hideLoadingIndicator();
                    }
                });
    }

    public void pika(View view) {
        Intent intent = new Intent(logintest.this, MainActivity.class);
        startActivity(intent);
    }
}
