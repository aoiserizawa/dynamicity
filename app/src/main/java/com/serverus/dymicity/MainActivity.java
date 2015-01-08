package com.serverus.dymicity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.Color;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Layout
        RelativeLayout dynamicLayout = new RelativeLayout(this);
        dynamicLayout.setBackgroundColor(Color.GREEN);

        //Button
        Button redButton = new Button(this);
        redButton.setText("Login");

        redButton.setBackgroundColor(Color.RED);

        //UserName Input
        EditText userName = new EditText(this);

        redButton.setId(1);
        userName.setId(2);

        //Rules

        // this is like a container for the button like a div in html to position in the layout
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, // width
                RelativeLayout.LayoutParams.WRAP_CONTENT // height
        );

        // username container
        RelativeLayout.LayoutParams userNameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, // width
                RelativeLayout.LayoutParams.WRAP_CONTENT // height
        );

        // the RelativeLayout.ABOVE put the username above of something
        // the redButton.getId() is which element it will be put above
        userNameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        userNameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userNameDetails.setMargins(0,0,0,50);

        // positioning rules of the layout of the button
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        // gets the information about your app ex.screen resolution
        Resources r = getResources();


        //converting DIP to PX because the setWidth only accepts pixels
        //  (int) means typecast the method TypedValue.applyDimension()
        // first parameter the unit we are trying to convert
        // second parameter how many you want to convert = 200
        // third parameter is the information about the screen
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200,
                r.getDisplayMetrics()
        );

        // set the with of the username input
        userName.setWidth(px);


        //Add widget to layout(button is now a child of layout)
        // the second parameter is optional on how you like to rule the button in the layout
        dynamicLayout.addView(redButton, buttonDetails);
        dynamicLayout.addView(userName, userNameDetails);

        //Set this activities to display to this view
        setContentView(dynamicLayout);
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
