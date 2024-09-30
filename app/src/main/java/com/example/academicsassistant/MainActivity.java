package com.example.yourapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput;
    private Button submitButton;
    private CheckBox checkboxAgree;
    private RadioGroup radioGroup;
    private RatingBar ratingBar;
    private SeekBar seekBar;
    private Switch switchToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        submitButton = findViewById(R.id.submitButton);
        checkboxAgree = findViewById(R.id.checkboxAgree);
        radioGroup = findViewById(R.id.radioGroup);
        ratingBar = findViewById(R.id.ratingBar);
        seekBar = findViewById(R.id.seekBar);
        switchToggle = findViewById(R.id.switchToggle);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();
                boolean isChecked = checkboxAgree.isChecked();
                int selectedGenderId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedGenderId);
                String gender = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "Not selected";
                float rating = ratingBar.getRating();
                int seekBarValue = seekBar.getProgress();
                boolean notificationsEnabled = switchToggle.isChecked();

                String message = "Email: " + email + "\nPassword: " + password +
                        "\nAgreed: " + isChecked + "\nGender: " + gender +
                        "\nRating: " + rating + "\nSeekBar Value: " + seekBarValue +
                        "\nNotifications: " + notificationsEnabled;

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
