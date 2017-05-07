package pl.nataliana.knowyourwhale;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.graphics.Color.GREEN;

//This is an app for Whale Quiz - after answering all questions you will know how much do you know about whales.
public class QuizActivity extends AppCompatActivity {

    // variables
    private int score;
    public String introMessage;
    @BindView(R.id.intro) TextView intro;
    @BindView(R.id.trueQ1) RadioButton trueQ1;
    @BindView(R.id.falseQ1) RadioButton falseQ1;
    @BindView(R.id.trueQ2) RadioButton trueQ2;
    @BindView(R.id.falseQ2) RadioButton falseQ2;
    @BindView(R.id.poland) RadioButton poland;
    @BindView(R.id.iceland) RadioButton iceland;
    @BindView(R.id.A3a) CheckBox A3a;
    @BindView(R.id.A3b) CheckBox A3b;
    @BindView(R.id.A3c) CheckBox A3c;
    @BindView(R.id.A3d) CheckBox A3d;
    @BindView(R.id.textAnswer) EditText textAnswer;

    //this method is called when Start Quiz button is clicked
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        introMessage = getString(R.string.Hello) + " " + name + getString(R.string.initial);
        intro.setText(introMessage);
        // recovering the instance state
        if (savedInstanceState != null) {
            score = savedInstanceState.getInt("SCORE");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("SCORE", score);
        // call superclass
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        savedInstanceState.getInt("SCORE");
    }

    //this method is called when the user answers 1st question
    public void clickQ1(View view) {
        if (trueQ1.isChecked()) {
            score++;
        }
    }

    //this method is called when the user answers 2nd question
    public void clickQ2(View view) {
        if (trueQ2.isChecked()) {
            score++;
        }
    }

    //this method is called to check 4th question
    public void freeWilly() {
        String willy = textAnswer.getText().toString();
        Boolean booleanWilly = willy.equalsIgnoreCase(getString(R.string.Willy));
        if (booleanWilly) {
            score++;
        }
    }

    //this method is called when the user answers 5th question
    public void clickQ5(View view) {
        if (iceland.isChecked()) {
            score++;
        }
    }

    //this method is called when the user clicks submit button
    public void submit(View view) {
        freeWilly();
        if (A3a.isChecked() && A3b.isChecked() && !A3c.isChecked() && A3d.isChecked()) {
            score++;
        }
        if (score > 4) {
            Toast.makeText(this, getString(R.string.score) + " " + score + getString(R.string.for7) + " " + getString(R.string.goodScore), Toast.LENGTH_LONG).show();
        } else if (score > 2) {
            Toast.makeText(this, getString(R.string.score) + " " + score + getString(R.string.for7) + " " + getString(R.string.mediumScore), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.score) + " " + score + getString(R.string.for7) + " " + getString(R.string.badScore), Toast.LENGTH_LONG).show();
        }
        score = 0;
    }

    //this method is called when the user clicks answers button
    public void answers(View view) {
        trueQ1.setTextColor(GREEN);
        falseQ1.setTextColor(Color.RED);
        trueQ2.setTextColor(GREEN);
        falseQ2.setTextColor(Color.RED);
        A3a.setTextColor(GREEN);
        A3b.setTextColor(GREEN);
        A3c.setTextColor(Color.RED);
        A3d.setTextColor(GREEN);
        poland.setTextColor(Color.RED);
        iceland.setTextColor(GREEN);
        textAnswer.setText(R.string.Willy);
        textAnswer.setTextColor(GREEN);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(QuizActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
