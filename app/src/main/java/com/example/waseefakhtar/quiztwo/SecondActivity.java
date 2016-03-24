package com.example.waseefakhtar.quiztwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by waseefakhtar on 3/24/16.
 */
public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView firstNameShow, lastNameShow, genderShow, countryShow, educationShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firstNameShow = (TextView) findViewById(R.id.firstNameShow);
        lastNameShow = (TextView) findViewById(R.id.lastNameShow);
        genderShow = (TextView) findViewById(R.id.genderShow);
        countryShow = (TextView) findViewById(R.id.countryShow);
        educationShow = (TextView) findViewById(R.id.educationShow);

        firstNameShow.setOnClickListener(this);
        lastNameShow.setOnClickListener(this);
        genderShow.setOnClickListener(this);
        countryShow.setOnClickListener(this);
        educationShow.setOnClickListener(this);

        Intent intent = getIntent();
        intent.getAction();
        intent.getExtras();

        firstNameShow.setText(intent.getStringExtra("firstName"));
        lastNameShow.setText(intent.getStringExtra("lastName"));
        genderShow.setText(intent.getStringExtra("gender"));
        countryShow.setText(intent.getStringExtra("country"));
        educationShow.setText(intent.getStringExtra("education"));
    }

    @Override
    public void onClick(View v) {
    }
}
