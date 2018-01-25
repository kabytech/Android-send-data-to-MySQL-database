package com.example.kamere.senddatatomysqldatabaseusingvolly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
EditText username,useremail,userpass;
Button btnRegister;
String URL = "http://192.168.43.254/tutorial/insert.php";
RequestQueue rq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username= findViewById(R.id.editName);
        useremail = findViewById(R.id.editEmail);
        userpass = findViewById(R.id.editPassword);
        btnRegister = findViewById(R.id.btnregister);

        rq = Volley.newRequestQueue(getApplicationContext());

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                    }

                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                       Map<String, String> parameter = new HashMap<String, String>();
                       parameter.put("username",username.getText().toString());
                       parameter.put("useremail",useremail.getText().toString());
                       parameter.put("password",userpass.getText().toString());

                       return  parameter;
                    }
                };
                rq.add(stringRequest);
            }
        });

    }

}
