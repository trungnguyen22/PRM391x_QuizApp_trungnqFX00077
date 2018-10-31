package com.example.dell.prm391x_quizapp_trungnqfx00077;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static String STRING_NAME_EXTRA = "STRING_NAME_EXTRA";
    public static String STRING_AGE_EXTRA = "STRING_AGE_EXTRA";
    public static String STRING_SCHOOL_EXTRA = "STRING_SCHOOL_EXTRA";

    TextView mMinuteTV, mSecondTV;

    RadioButton mFirstAnswerRB3, mFifthAnswerRB2, mNinthAnswerRB2;
    EditText mSecondAnswerEdt, mFourthAnswerEdt, mSixthAnswerEdt, mEightAnswerEdt, mTenthAnswerEdt;
    CheckBox mThirdAnswerCB1, mThirdAnswerCB3, mSeventhAnswerCB3, mSeventhAnswerCB4;

    CountDownTimer mCountDownTimer;

    public static void openOuiz(Activity activity, String name, String age, String school) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.putExtra(MainActivity.STRING_NAME_EXTRA, name);
        intent.putExtra(MainActivity.STRING_AGE_EXTRA, age);
        intent.putExtra(MainActivity.STRING_SCHOOL_EXTRA, school);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.app_name_official));
        initData();
        bindViews();
        runTimer();
    }

    /** Get intent */
    private void initData() {
        String name = getIntent().getStringExtra(STRING_NAME_EXTRA);
        Toast.makeText(this, "Chào bạn " + name + ", chúc bạn làm bài Quiz tối", Toast.LENGTH_LONG).show();
    }


    /** Run a count down timer for the quiz */
    private void runTimer() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mCountDownTimer = new CountDownTimer(900000, 1000) {
                    public void onTick(final long millisUntilFinished) {
                        mMinuteTV.setText(String.format(Locale.getDefault(), "%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                        mSecondTV.setText(String.format(Locale.getDefault(), "%02d", TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                    }

                    public void onFinish() {
                        submitTheQuiz();
                    }
                }.start();
            }
        });
    }

    private void bindViews() {
        findViewById(R.id.mSubmitBtn).setOnClickListener(this);

        mMinuteTV = findViewById(R.id.mMinuteTV);
        mSecondTV = findViewById(R.id.mSecondTV);

        mFirstAnswerRB3 = findViewById(R.id.FirstAnswerRB3);
        mFifthAnswerRB2 = findViewById(R.id.mFifthAnswerRB2);
        mNinthAnswerRB2 = findViewById(R.id.mNinthAnswerRB2);

        mSecondAnswerEdt = findViewById(R.id.mSecondAnswerEdt);
        mFourthAnswerEdt = findViewById(R.id.mFourthAnswerEdt);
        mSixthAnswerEdt = findViewById(R.id.mSixthAnswerEdt);
        mEightAnswerEdt = findViewById(R.id.mEightAnswerEdt);
        mTenthAnswerEdt = findViewById(R.id.mTenthAnswerEdt);

        mThirdAnswerCB1 = findViewById(R.id.mThirdAnswerCB1);
        mThirdAnswerCB3 = findViewById(R.id.mThirdAnswerCB3);
        mSeventhAnswerCB3 = findViewById(R.id.mSeventhAnswerCB3);
        mSeventhAnswerCB4 = findViewById(R.id.mSeventhAnswerCB4);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mSubmitBtn:
                submitTheQuiz();
                break;
        }
    }

    /** When user click on button for submitting, grade for the quiz */
    private void submitTheQuiz() {
        int count = 0;
        if (mFirstAnswerRB3.isChecked()) count += 1;
        if (mFifthAnswerRB2.isChecked()) count += 1;
        if (mNinthAnswerRB2.isChecked()) count += 1;

        if (mThirdAnswerCB1.isChecked() && mThirdAnswerCB3.isChecked()) count += 1;

        if (mSeventhAnswerCB3.isChecked() && mSeventhAnswerCB4.isChecked()) count += 1;

        if (mSecondAnswerEdt.getText().toString().equals("Vulcanizing")) count += 1;
        if (mFourthAnswerEdt.getText().toString().equals("Gravity")) count += 1;
        if (mSixthAnswerEdt.getText().toString().equals("Clouds")
                || mSixthAnswerEdt.getText().toString().equals("Cloud")) count += 1;
        if (mEightAnswerEdt.getText().toString().equals("Wrist")) count += 1;
        if (mTenthAnswerEdt.getText().toString().equals("Smelting")) count += 1;

        // Announcing quiz result
        Toast.makeText(this, getString(R.string.message_result) + count + "/10", Toast.LENGTH_SHORT).show();
    }
}
