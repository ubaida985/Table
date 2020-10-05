package com.example.tables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView tablesListView;
    SeekBar tablesSeekBar;
    public void generateTables(){
        int tableValue = tablesSeekBar.getProgress();
        ArrayList<String> numbers = new ArrayList<String>();
        for( int i = 1; i <= 30; i++ ){
            numbers.add( Integer.toString( i*tableValue ) );
        }

        ArrayAdapter<String> tableNumbers = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbers);
        tablesListView.setAdapter(tableNumbers);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablesSeekBar = (SeekBar)(findViewById(R.id.tablesSeekBar));
        tablesListView = (ListView) (findViewById(R.id.tablesListView));

        tablesSeekBar.setMax(50);
        tablesSeekBar.setProgress(10);

        tablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int tableValue;
                if( i < min ){
                    tableValue = min;
                    tablesSeekBar.setProgress(tableValue);
                }else{
                    tableValue = i;
                }
                generateTables();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTables();
    }
}