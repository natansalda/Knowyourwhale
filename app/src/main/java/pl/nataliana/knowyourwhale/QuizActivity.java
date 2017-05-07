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

import static android.graphics.Color.GREEN;

//This is an app for Whale Quiz - after answering all questions you will know how much do you know about whales.
public class QuizActivity extends AppCompatActivity {

    // variables
    private int score = 0;
    public String introMessage;
    public TextView intro;
    public RadioButton trueQ1;
    public RadioButton falseQ1;
    public RadioButton trueQ2;
    public RadioButton falseQ2;
    public RadioButton poland;
    public RadioButton island;
    public CheckBox A3a;
    public CheckBox A3b;
    public CheckBox A3c;
    public CheckBox A3d;
    public EditText textAnswer;


    //this method is called when Start Quiz button is clicked
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        intro = (TextView) findViewById(R.id.intro);
        trueQ1 = (RadioButton) findViewById(R.id.trueQ1);
        falseQ1 = (RadioButton) findViewById(R.id.falseQ1);
        trueQ2 = (RadioButton) findViewById(R.id.trueQ2);
        falseQ2 = (RadioButton) findViewById(R.id.falseQ2);
        poland = (RadioButton) findViewById(R.id.Poland);
        island = (RadioButton) findViewById(R.id.Island);
        A3a = (CheckBox) findViewById(R.id.A3a);
        A3b = (CheckBox) findViewById(R.id.A3b);
        A3c = (CheckBox) findViewById(R.id.A3c);
        A3d = (CheckBox) findViewById(R.id.A3d);
        introMessage = getString(R.string.Hello) + " " + name + getString(R.string.initial);
        intro.setText(introMessage);
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

    //those methods are called when the user answers 3rd question
    public void onCheckboxClickedA(View view) {
        if (A3a.isChecked()) {
            score++;
        }
    }

    public void onCheckboxClickedB(View view) {
        if (A3b.isChecked()) {
            score++;
        }
    }

    public void onCheckboxClickedC(View view) {
        if (A3c.isChecked()) {
            //wrong answer - do nothing
        }
    }

    public void onCheckboxClickedD(View view) {
        if (A3d.isChecked()) {
            score++;
        }
    }

    //this method is called to check 4th question
    public void freeWilly() {
        EditText textAnswer = (EditText) findViewById(R.id.textAnswer);
        String willy = textAnswer.getText().toString();
        Boolean booleanWilly = willy.equalsIgnoreCase(getString(R.string.Willy));
        if (booleanWilly) {
            score++;
        }
    }

    //this method is called when the user answers 5th question
    public void clickQ5(View view) {
        if (island.isChecked()) {
            score++;
        }
    }

    //this method is called when the user clicks submit button
    public void submit(View view) {
        freeWilly();
        if (score > 5) {
            Toast.makeText(this, getString(R.string.score) + " " + score + getString(R.string.for7) + " " + getString(R.string.goodScore), Toast.LENGTH_LONG).show();
        }
        else if (score > 3){
            Toast.makeText(this, getString(R.string.score) + " " + score + getString(R.string.for7) + " " + getString(R.string.mediumScore), Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, getString(R.string.score) + " " + score + getString(R.string.for7) + " " + getString(R.string.badScore), Toast.LENGTH_LONG).show();
        }
        score = 0;
    }

    //this method is called when the user clicks answers button
    public void answers(View view) {
        trueQ1 = (RadioButton) findViewById(R.id.trueQ1);
        falseQ1 = (RadioButton) findViewById(R.id.falseQ1);
        trueQ2 = (RadioButton) findViewById(R.id.trueQ2);
        falseQ2 = (RadioButton) findViewById(R.id.falseQ2);
        A3a = (CheckBox) findViewById(R.id.A3a);
        A3b = (CheckBox) findViewById(R.id.A3b);
        A3c = (CheckBox) findViewById(R.id.A3c);
        A3d = (CheckBox) findViewById(R.id.A3d);
        poland = (RadioButton) findViewById(R.id.Poland);
        island = (RadioButton) findViewById(R.id.Island);
        textAnswer = (EditText) findViewById(R.id.textAnswer);
        trueQ1.setTextColor(GREEN);
        falseQ1.setTextColor(Color.RED);
        trueQ2.setTextColor(GREEN);
        falseQ2.setTextColor(Color.RED);
        A3a.setTextColor(GREEN);
        A3b.setTextColor(GREEN);
        A3c.setTextColor(Color.RED);
        A3d.setTextColor(GREEN);
        poland.setTextColor(Color.RED);
        island.setTextColor(GREEN);
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
