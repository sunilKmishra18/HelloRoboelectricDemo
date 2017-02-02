package com.sunilmishra.helloroboelectricdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View welcomeText = findViewById(R.id.welcome_text_view);
        welcomeText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                shortToast(getResources().getString(R.string.WELCOME_TOAST));
            }
        });

        final View button = findViewById(R.id.next_screen_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(NewActivity.createIntent(MainActivity.this));
            }
        });

        View image = findViewById(R.id.sun_earth_image);
        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button.setVisibility(View.VISIBLE);
            }
        });
    }
    public void shortToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

}
