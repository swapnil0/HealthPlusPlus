package com.design.ws.i_know_ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.design.ws.i_know_ui.model.ResObj;
import com.design.ws.i_know_ui.remote.UserService;
import com.design.ws.i_know_ui.remote.ApiUtils;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {


    ImageView back;
    Button submit;
    EditText Password;
    UserService userService;
    public  String check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        back = (ImageView)findViewById(R.id.back);
        Password=(EditText)findViewById(R.id.password);
        submit = (Button) findViewById(R.id.sumbit);
        userService = ApiUtils.getUserService();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(MainActivity2.this,MainActivity.class);
                startActivity(it);
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = getIntent().getExtras();
                String username = b.getString("Email");
                String password = Password.getText().toString();
                Log.i("Email is",username);
                Log.i("passwors is ",password);
                if(validateLogin(username, password)){
                    //do login
                    doLogin(username, password);
                }


//                Intent it = new Intent(MainActivity2.this,Dash3Activity.class);
//                startActivity(it);
            }
        });
    }

    private boolean validateLogin(String username, String password){
        if(username == null || username.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void doLogin(final String email,final String password){
        Call<ResObj> call = userService.login(email,password);
        call.enqueue(new Callback<ResObj>() {

            @Override

            public void onResponse(Call<ResObj> call, Response<ResObj> response) {
                Log.i("Request","Succesful request");
                try {

                    ResObj resObj = response.body();
                    String s= resObj.FirstName.toString();
                  check= resObj.email.toString();

//                    JsonObject post = new JsonObject().get(response.body().toString()).getAsJsonObject();
//                    String s=post.get("FirstName").getAsString();
                    Log.i("name is ",check);
                }
                catch (Exception e){

                }

//                Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
//                intent.putExtra("username", email);
//                startActivity(intent);


                if(email.equals(check)){

                    //login start main activity
                    Intent intent = new Intent(MainActivity2.this, Main3Activity.class);
                   // intent.putExtra("username", email);
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity2.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResObj> call, Throwable t) {
                Toast.makeText(MainActivity2.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
