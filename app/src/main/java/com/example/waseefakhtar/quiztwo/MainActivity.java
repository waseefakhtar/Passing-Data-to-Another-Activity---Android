package com.example.waseefakhtar.quiztwo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String firstNameString, lastNameString, genderString, countryString, educationString, emptyString;
    String[] countryArray = {"Pakistan", "UAE", "US", "UK"};
    String[] educationArray = {"Bachelors", "Masters", "PHD"};
    EditText firstName, lastName;
    RadioButton maleButton, femaleButton;
    AutoCompleteTextView countryEdit;
    Spinner educationEdit;
    Button showButton, clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        maleButton = (RadioButton) findViewById(R.id.maleBtn);
        femaleButton = (RadioButton) findViewById(R.id.femaleBtn);
        countryEdit = (AutoCompleteTextView) findViewById(R.id.countryEdit);
        educationEdit = (Spinner) findViewById(R.id.educationEdit);
        showButton = (Button) findViewById(R.id.showButton);
        clearButton = (Button) findViewById(R.id.clearButton);

        firstName.setOnClickListener(this);
        lastName.setOnClickListener(this);
        maleButton.setOnClickListener(this);
        femaleButton.setOnClickListener(this);
        countryEdit.setOnClickListener(this);
        showButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);

        ArrayAdapter<String> countryAdaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countryArray);
        countryEdit.setAdapter(countryAdaptor);

        ArrayAdapter<String> educationAdaptor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, educationArray);
        educationEdit.setAdapter(educationAdaptor);

        educationString = educationEdit.getSelectedItem().toString();
    }

    @Override
    public void onClick(View v) {
        firstNameString = firstName.getText().toString();
        lastNameString = lastName.getText().toString();
        countryString = countryEdit.getText().toString();
        emptyString = "";

        switch (v.getId()) {
            case R.id.maleBtn:
                genderString = "Male";
                break;
            case R.id.femaleBtn:
                genderString = "Female";
                break;
        }

        if(v.equals(showButton)) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("firstName", firstNameString);
            intent.putExtra("lastName", lastNameString);
            intent.putExtra("gender", genderString);
            intent.putExtra("country", countryString);
            intent.putExtra("education", educationString);
            startActivity(intent);
        }

        if(v.equals(clearButton)) {
            startActivity(new Intent(getBaseContext(), MainActivity.class));
        }
    }
}
