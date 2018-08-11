package com.popular.popular;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Toast;


public class Contact_Us extends AppCompatActivity {

    private static final int Request_call = 1;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent i1 = new Intent(Contact_Us.this, home.class);
                    startActivity(i1);
                    return true;
                case R.id.navigation_gallery:
                    Intent i2 = new Intent(Contact_Us.this, Gallery.class);
                    startActivity(i2);

                    return true;

                case R.id.navigation_contact:
                    Intent i3 = new Intent(Contact_Us.this, Contact_Us.class);
                    startActivity(i3);
                    return true;
            }
            return false;
        }
    };

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            Intent i1 = new Intent(Contact_Us.this, home.class);
            startActivity(i1);
            finish();
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__us);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        Button btnsend = (Button) findViewById(R.id.send);
        btnsend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView mtextto = (TextView) findViewById(R.id.emailid);
                String recipient = mtextto.getText().toString();
                EditText mtextmessage = (EditText) findViewById(R.id.message);
                EditText mname = (EditText)findViewById(R.id.name);
                EditText mcontactno = (EditText)findViewById(R.id.phoneno);
                String message = mtextmessage.getText().toString();
                String name = mname.getText().toString();
                String contactno = mcontactno.getText().toString();


                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", recipient, null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Enquiry through app");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Name :-" +name +"\n" +"Contact No :- "+ contactno +"\n"+ message);
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }



        });


    }
    public void call(String abc) {

        Intent calling = new Intent(Intent.ACTION_DIAL);


        calling.setData(Uri.parse("tel:"+ abc));

        try {
            startActivity(calling);
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Contact_Us.this, "There are no call clients installed.", Toast.LENGTH_SHORT).show();
        }


    }

    public void callNoOne(View view) {
        TextView c1 =(TextView)findViewById(R.id.call_no_1);
        call(c1.getText().toString());
    }

    public void callNoTwo(View view) {
        TextView c2 =(TextView)findViewById(R.id.call_no_2);
        call(c2.getText().toString());
    }

    public void callNoThree(View view) {
        TextView c3 = (TextView) findViewById(R.id.call_no_3);
        call(c3.getText().toString());

    }
    public void callNoFour(View view) {
        TextView c4 = (TextView) findViewById(R.id.call_no_3);
        call(c4.getText().toString());

    }


}






