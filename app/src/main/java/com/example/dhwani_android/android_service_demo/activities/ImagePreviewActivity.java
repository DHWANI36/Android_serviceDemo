package com.example.dhwani_android.android_service_demo.activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

import com.example.dhwani_android.android_service_demo.R;

/**
 * Created by DHWANI-ANDROID on 08-05-17.
 */

public class ImagePreviewActivity extends Activity {
    private ImageView ivPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        Bitmap bmp = getIntent().getParcelableExtra("bitmap");
        ivPreview = (ImageView) findViewById(R.id.ivPreview);
        ivPreview.setImageBitmap(bmp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.image_view, menu);
        return true;
    }
}
