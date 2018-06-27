package com.example.lenovo.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String item = editText.getText().toString().toLowerCase();
                editText.setText("");

                if("dialerpad".compareTo(item)==0) {

                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("tel:9478332010"));
                    startActivity(intent);

                } else if("browser".compareTo(item)==0) {

                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.acadview.com"));
                    startActivity(intent);

                } else if("map".compareTo(item)==0) {

                    Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
                    Intent i = new Intent(Intent.ACTION_VIEW, location);
                    startActivity(i);

                }else if("camera".compareTo(item) == 0) {

                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, 1888);

                }else if("gmail".compareTo(item) == 0) {

                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
                    startActivity(intent);

                }else {

                    Intent i = new Intent(getApplicationContext(), ItemList.class);
                    i.putExtra("text", item.toUpperCase());
                    startActivity(i);
                }
            }
        });
    }
}
