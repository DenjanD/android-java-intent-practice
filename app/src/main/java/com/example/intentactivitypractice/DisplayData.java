package com.example.intentactivitypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        ArrayList<String> appetitesList = new ArrayList<String>();

        TextView nameText = findViewById(R.id.name_text);
        TextView ageText = findViewById(R.id.age_text);
        TextView emailText = findViewById(R.id.email_text);
        TextView appetitesText = findViewById(R.id.appetites_text);
        TextView paymentText = findViewById(R.id.payment_text);

        Button buttBack = findViewById(R.id.butt_back);

        Bundle extras = getIntent().getExtras();

        nameText.setText(extras.getString("name"));
        ageText.setText(extras.getString("age"));
        emailText.setText(extras.getString("email"));

        // Displaying Appetites List Loop
        appetitesList = getIntent().getStringArrayListExtra("appetites");

        appetitesText.setText("");

        for (int i = 0;i<appetitesList.size();i++) {
            appetitesText.append(appetitesList.get(i)+", ");
        }
        // Displaying Appetites List Loop --

        paymentText.setText(extras.getString("payment"));

        buttBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToHome = new Intent(DisplayData.this, MainActivity.class);
                startActivity(backToHome);
                finish();
            }
        });
    }
}