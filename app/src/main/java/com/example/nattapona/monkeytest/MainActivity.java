package com.example.nattapona.monkeytest;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {


    EditText celTF;
    EditText fahTF;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        celTF = (EditText)findViewById(R.id.celTextField);
        fahTF = (EditText)findViewById(R.id.fahTextField);

        celTF.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (fahTF.hasFocus() || !fahTF.hasWindowFocus() || s == null)
                    return;

                final String value = s.toString();
                if ("".equals(value)) {
                    fahTF.setText("");
                    return;
                }

                final double result = (9 / 5.0) * Double.parseDouble(value) + 32;
                fahTF.setText(String.valueOf(result));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });



        fahTF.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (celTF.hasFocus() || !celTF.hasWindowFocus() || s == null)
                    return;

                final String value = s.toString();
                if ("".equals(value)) {
                    celTF.setText("");
                    return;
                }

                final double result = (Double.parseDouble(value) - 32) * (5 / 9.0);
                celTF.setText(String.valueOf(result));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
