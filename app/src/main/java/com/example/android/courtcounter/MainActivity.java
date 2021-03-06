package com.example.android.courtcounter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(pointCountA);
        displayForTeamB(pointCountB);
        //declaration of the edittext
        EditText editTeamA = (EditText) findViewById(R.id.edittext_TeamA);
        EditText editTeamB = (EditText) findViewById(R.id.edittext_TeamB);
        //this enable the focus on the editText, hide also the keyboard
        editTeamA.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        editTeamB.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
    }

    /**
     * reset the value of both of the teams
     */
    public void resetBothTeams(View view) {
        pointCountA = 0;
        pointCountB = 0;
        displayForTeamA(pointCountA);
        displayForTeamB(pointCountB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for buttons for Team A
     */
    public void threePoints(View view) {
        pointCountA = pointCountA + 3;
        displayForTeamA(pointCountA);
    }

    public void twoPoints(View view) {
        pointCountA = pointCountA + 2;
        displayForTeamA(pointCountA);
    }

    public void freeThrow(View view) {
        pointCountA = pointCountA + 1;
        displayForTeamA(pointCountA);
    }


    /**
     * Displays the given score for buttons for Team B
     */
    public void threePointsB(View view) {
        pointCountB = pointCountB + 3;
        displayForTeamB(pointCountB);
    }

    public void twoPointsB(View view) {
        pointCountB = pointCountB + 2;
        displayForTeamB(pointCountB);
    }

    public void freeThrowB(View view) {
        pointCountB = pointCountB + 1;
        displayForTeamB(pointCountB);
    }

    //to change the keyboard setting
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void onResume() {
        super.onResume();
        displayForTeamA(pointCountA);
        displayForTeamB(pointCountB);

    }

    // PRIVATE SCAFFOLDING


    private static final String STATE_TEAMA = MainActivity.class.getName()+ ".BUTTON_CLICK_COUNT_A";
    private static final String STATE_TEAMB = MainActivity.class.getName()+ ".BUTTON_CLICK_COUNT_B";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(STATE_TEAMA, pointCountA);
        outState.putSerializable(STATE_TEAMB, pointCountB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        pointCountA = (Integer)bundle.getSerializable(STATE_TEAMA);
        pointCountB = (Integer)bundle.getSerializable(STATE_TEAMB);

    }

    // BEGIN PRIVATE STATE VARIABLES


    private Integer pointCountA = 0;
    private Integer pointCountB = 0;
    // END PRIVATE STATE VARIABLES


}
