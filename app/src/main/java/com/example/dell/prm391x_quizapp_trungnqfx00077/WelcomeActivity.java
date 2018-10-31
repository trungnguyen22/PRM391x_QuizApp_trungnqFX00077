package com.example.dell.prm391x_quizapp_trungnqfx00077;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {

    Button mStartQuizBtn;
    EditText mUserNameEdt, mAgeEdt, mSchoolEdt;

    String name;
    String age;
    String school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        bindViews();

        mStartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFormData();
                MainActivity.openOuiz(WelcomeActivity.this, name, age, school);
            }
        });
    }

    private void getFormData() {
        name = mUserNameEdt.getText().toString();
        age = mAgeEdt.getText().toString();
        school = mSchoolEdt.getText().toString();
    }

    private void bindViews() {
        mStartQuizBtn = findViewById(R.id.mStartQuizBtn);
        mUserNameEdt = findViewById(R.id.mUserNameEdt);
        mAgeEdt = findViewById(R.id.mAgeEdt);
        mSchoolEdt = findViewById(R.id.mSchoolEdt);
    }
}
