package com.popular.popular;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.popular.popular.R.layout.activity_gallery;


public class   Gallery extends AppCompatActivity {





    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent i1 = new Intent(Gallery.this,home.class);
                    startActivity(i1);


                    return true;
                case R.id.navigation_gallery:
                    Intent i2 = new Intent(Gallery.this,Gallery.class);
                    startActivity(i2);

                    return true;

                case R.id.navigation_contact:
                    Intent i3 = new Intent(Gallery.this,Contact_Us.class);
                    startActivity(i3);
                    return true;
            }
            return false;
        }
    };
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            Intent i4 = new Intent(Gallery.this,home.class);
            startActivity(i4);
            finish();
            return true;
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_gallery);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent i5 = new Intent(getApplicationContext(), Fullscreen.class);
                i5.putExtra("tom",position);
                startActivity(i5);


            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);


    }


    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageBitmap(decodeImage(mThumbIds[position]));
            return imageView;
        }

        // references to our images
        private Integer[] mThumbIds = {

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

        public Bitmap decodeImage(int resourceId) {
            try {
                // Decode image size
                BitmapFactory.Options o = new BitmapFactory.Options();
                o.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(getResources(), resourceId, o);
                // The new size we want to scale to
                final int REQUIRED_SIZE = 100; // you are free to modify size as your requirement

                // Find the correct scale value. It should be the power of 2.
                int scale = 1;
                while (o.outWidth / scale / 2 >= REQUIRED_SIZE && o.outHeight / scale / 2 >= REQUIRED_SIZE)
                    scale *= 2;

                // Decode with inSampleSize
                BitmapFactory.Options o2 = new BitmapFactory.Options();
                o2.inSampleSize = scale;
                return BitmapFactory.decodeResource(getResources(), resourceId, o2);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return null;

        }
    }

}
