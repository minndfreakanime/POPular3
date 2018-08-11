package com.popular.popular;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;

public class Fullscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);


        int i = getIntent().getIntExtra("tom",0);
        //get id
        imageView.setImageResource(id[i]);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            Intent i1 = new Intent(Fullscreen.this,Gallery.class);
            startActivity(i1);
            finish();
            return true;
        }
        return false;
    }
    private Integer[] id = {

            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10,
            R.drawable.img11,
            R.drawable.img12,
            R.drawable.img13,
            R.drawable.img14,
            R.drawable.img15,
            R.drawable.img16,
            R.drawable.img17,
            R.drawable.img18,
            R.drawable.img19,
            R.drawable.img20,
            R.drawable.img21,
            R.drawable.img22,
            R.drawable.img23,
            R.drawable.img24,
            R.drawable.img25,
            R.drawable.img26,
            R.drawable.img27,
            R.drawable.img28,
            R.drawable.img29,
            R.drawable.img30,
            R.drawable.img31,
            R.drawable.img32,
            R.drawable.img33,
            R.drawable.img34,
            R.drawable.img35,
            R.drawable.img36,
            R.drawable.img37,
            R.drawable.img38,
            R.drawable.img39,
            R.drawable.img40,
            R.drawable.img41,
            R.drawable.img42,
            R.drawable.img43,
            R.drawable.img44,
            R.drawable.img45,
            R.drawable.img46,
            R.drawable.img47,
            R.drawable.img48,
            R.drawable.img49,
            R.drawable.img50,
            R.drawable.img51,
            R.drawable.img52,
            R.drawable.img53,
            R.drawable.img54,
            R.drawable.img55,
            R.drawable.img56,
            R.drawable.img57,
            R.drawable.img58,
            R.drawable.img59,
            R.drawable.img60,
            R.drawable.img61,
            R.drawable.img62,
            R.drawable.img63,
            R.drawable.img64,
            R.drawable.img65,
            R.drawable.img66,
            R.drawable.img67,
            R.drawable.img68,
            R.drawable.img69,
            R.drawable.img70,
            R.drawable.img71,
            R.drawable.img72,
            R.drawable.img73,
            R.drawable.img74,
            R.drawable.img75,
            R.drawable.img76,
            R.drawable.img77,
            R.drawable.img78,
            R.drawable.img79,
            R.drawable.img80,
            R.drawable.img81,
            R.drawable.img82,
            R.drawable.img83,
            R.drawable.img84,
            R.drawable.img85,
            R.drawable.img86,
            R.drawable.img87,
            R.drawable.img88,
            R.drawable.img89,
            R.drawable.img90,




    };



}
