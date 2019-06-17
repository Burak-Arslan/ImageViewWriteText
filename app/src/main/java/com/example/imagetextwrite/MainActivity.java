package com.example.imagetextwrite;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgview;
    Canvas canvas;
    Bitmap jungle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        Events();
    }

    private void Events() {
        try {

            imgview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Init();
                    Paint paint = new Paint();
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(getResources().getColor(android.R.color.black)); // Text Color
                    paint.setTextSize(getResources().getDimension(R.dimen.my_value)); //Text Size

                    int[] posXY = new int[2];
                    imgview.getLocationOnScreen(posXY);

//                  int touchX = (int) event.getX();
                    //int touchY = (int) event.getY();
//
                    //int imageX = touchX - posXY[0]; // posXY[0] is the X coordinate
                    //int imageY = touchY - posXY[1];

                    canvas.drawText("TEST", posXY[0], posXY[1], paint);
//                    canvas.drawText("Created by AndroidClarified", 0, jungle.getHeight() - 50, paint);

                    imgview.setImageBitmap(jungle);


                }
            });
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void Init() {
        try {
            imgview = findViewById(R.id.imgview);
            jungle = BitmapFactory.decodeResource(getResources(), R.drawable.winwos).copy(Bitmap.Config.ARGB_8888, true);
            Bitmap dino = BitmapFactory.decodeResource(getResources(), R.drawable.winwos);
            canvas = new Canvas(jungle);

//            canvas.drawBitmap(dino, (jungle.getWidth()) / 4, 250, new Paint());
            imgview.setImageBitmap(jungle);
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
