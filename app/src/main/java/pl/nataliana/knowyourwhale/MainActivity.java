package pl.nataliana.knowyourwhale;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView TV_English,TV_Polish;
    Locale mylocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TV_English=(TextView)findViewById(R.id.TVEnglish);
        TV_Polish=(TextView)findViewById(R.id.TVPolish);

        //Set English Language
        TV_English.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"English Language",Toast.LENGTH_SHORT).show();
                setLanguage("en");
            }
        });

        //Set Polish Language
        TV_Polish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Język polski",Toast.LENGTH_SHORT).show();
                setLanguage("pl");
            }
        });
    }

    //Change language Method
    protected void setLanguage(String language){
        mylocale=new Locale(language);
        Resources resources=getResources();
        DisplayMetrics dm=resources.getDisplayMetrics();
        Configuration conf= resources.getConfiguration();
        conf.locale=mylocale;
        resources.updateConfiguration(conf,dm);
        Intent refreshIntent=new Intent(MainActivity.this,MainActivity.class);
        finish();
        startActivity(refreshIntent);
    }

    //This method opens QuizActivity
    public void startQuiz(View view) {
        Intent mainIntent = new Intent(this, pl.nataliana.knowyourwhale.QuizActivity.class);
        startActivity(mainIntent);
        EditText txtname = (EditText) findViewById(R.id.textName);
        String name = txtname.getText().toString();
        Intent i = new Intent(this, pl.nataliana.knowyourwhale.QuizActivity.class);
        i.putExtra("name", name);
        startActivity(i);
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, R.string.exit_press_back_twice_message, Toast.LENGTH_SHORT).show();
    }
}
