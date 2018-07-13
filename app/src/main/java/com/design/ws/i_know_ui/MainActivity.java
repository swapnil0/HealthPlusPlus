package com.design.ws.i_know_ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView signUp;
    Button next;
    EditText Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_main);

        signUp =(TextView)findViewById(R.id.signUp);
        next = (Button)findViewById(R.id.next);
        Email=(EditText)findViewById(R.id.email);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Email.getText().toString();
                Log.i("your message is:-",username);

                Intent it = new Intent(MainActivity.this, MainActivity2.class);
                it.putExtra("Email",username );
                startActivity(it);




            }
        });

    }
}
