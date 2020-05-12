package com.example.mygridjava;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView mGridView;

    private static final int COLUMNS = 8;
    private static final int DIMENSIONS = COLUMNS * COLUMNS;

    private int mColumnWidth, mColumnHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        display();

    }

    private void init() {
        mGridView = (GridView) findViewById(R.id.grid);
        mGridView.setNumColumns(COLUMNS);
    }

    private void display() {
        List<Button> buttons = new ArrayList<>();
        Button button;

        for (int i = 0; i < DIMENSIONS; i++) {
            button = new Button(this);

            if (i < 15) {
                button.setBackgroundResource(R.drawable.android_blue);
            } else if (i < 30) {
                button.setBackgroundResource(R.drawable.android_green);
            } else if (i < 45) {
                button.setBackgroundResource(R.drawable.android_red);
            } else {
                button.setBackgroundResource(R.drawable.android_yellow);
            }

            buttons.add(button);
        }

        Collections.shuffle(buttons);

        mGridView.setAdapter(new CustomAdapter(this, buttons, mColumnWidth, mColumnHeight));
    }
}
