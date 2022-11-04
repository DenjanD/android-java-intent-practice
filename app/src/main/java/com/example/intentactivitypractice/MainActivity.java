package com.example.intentactivitypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Bundle activityState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        savedInstanceState = activityState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etName = findViewById(R.id.et_name);
        EditText etAge = findViewById(R.id.et_age);
        EditText etEmail = findViewById(R.id.et_email);
        TextView tvApiResponse = findViewById(R.id.tv_apiresponse);

        if (savedInstanceState != null) {
            etName.setText(savedInstanceState.getString("onSaveInstanceVar"));
        }

        CheckBox cbFood = findViewById(R.id.cb_food);
        CheckBox cbDrink = findViewById(R.id.cb_drink);

        RadioButton rbPaylater = findViewById(R.id.rb_paylater);
        RadioButton rbEwallet = findViewById(R.id.rb_ewallet);
        RadioButton rbCash = findViewById(R.id.rb_cash);

        Button buttTestApi = findViewById(R.id.butt_submit);
        Button buttSubmitBundle = findViewById(R.id.butt_reset);
        Button buttWeb = findViewById(R.id.butt_web);
        Button buttTel = findViewById(R.id.butt_tel);
        Button buttExternalStorage = findViewById(R.id.butt_externalstorage);

//        buttSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = etName.getText().toString();
//                Integer age = Integer.parseInt(etAge.getText().toString());
//                String email = etEmail.getText().toString();
//
//                ArrayList<String> appetites = new ArrayList<String>();
//
//                String payment = "";
//
//                if (cbFood.isChecked()) {
//                    appetites.add("Food");
//                }
//                if (cbDrink.isChecked()) {
//                    appetites.add("Drink");
//                }
//
//                if (rbPaylater.isChecked()) {
//                    payment = rbPaylater.getText().toString();
//                }
//                if (rbEwallet.isChecked()) {
//                    payment = rbEwallet.getText().toString();
//                }
//                if (rbCash.isChecked()) {
//                    payment = rbCash.getText().toString();
//                }
//
//                Intent sendMainData = new Intent(MainActivity.this, DisplayData.class);
//                sendMainData.putExtra("name",name);
//                sendMainData.putExtra("age",age.toString());
//                sendMainData.putExtra("email",email);
//                sendMainData.putStringArrayListExtra("appetites",appetites);
//                sendMainData.putExtra("payment",payment);
//
//                MainActivity.this.startActivity(sendMainData);
//            }
//        });

        buttTestApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "my-json-server.typicode.com/user/repo/posts/1";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                tvApiResponse.setText("Response is: " + response.substring(0,500));
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvApiResponse.setText("That didn't work!");
                    }
                });

                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }
        });

        buttSubmitBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer age = Integer.parseInt(etAge.getText().toString());
                String email = etEmail.getText().toString();
                String name = etName.getText().toString();
                ArrayList<String> appetites = new ArrayList<String>();
                String payment = "";

                if (cbFood.isChecked()) {
                    appetites.add("Food");
                }
                if (cbDrink.isChecked()) {
                    appetites.add("Drink");
                }

                if (rbPaylater.isChecked()) {
                    payment = rbPaylater.getText().toString();
                }
                if (rbEwallet.isChecked()) {
                    payment = rbEwallet.getText().toString();
                }
                if (rbCash.isChecked()) {
                    payment = rbCash.getText().toString();
                }

                Intent sendMainData = new Intent(MainActivity.this, DisplayData.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("age",age.toString());
                bundle.putString("email",email);
                bundle.putStringArrayList("appetites",appetites);
                bundle.putString("payment",payment);
                sendMainData.putExtras(bundle);
                startActivity(sendMainData);
                finish();
            }
        });

        buttWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://denjandmuammar.space"));
                startActivity(openBrowser);
            }
        });

        buttTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomor = "6282320482627";

                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.fromParts("tel",nomor,null));
                startActivity(call);
            }
        });

        buttExternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent externalStorageActivity = new Intent(MainActivity.this, ExternalStorage.class);
                startActivity(externalStorageActivity);
            }
        });
    }

//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        savedInstanceState = activityState;
//        savedInstanceState.putString("onSaveInstanceVar", "This value is from onSaveInstaceState");
//        super.onSaveInstanceState(savedInstanceState);
//    }
}