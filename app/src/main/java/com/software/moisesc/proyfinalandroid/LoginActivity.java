package com.software.moisesc.proyfinalandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameEditText = (EditText)findViewById(R.id.username);
        passwordEditText = (EditText)findViewById(R.id.password);
    }

    public void onLogin(View view) {
        Log.d("LoginActivity", "You clicked me!");
        Log.d("LoginActivity", "Username: " + usernameEditText.getText());
        Log.d("LoginActivity", "Password: " + passwordEditText.getText());

        //Toast.makeText(this, R.string.login_success, Toast.LENGTH_LONG).show();
        // SharedPreferences hace referencia a un archivo
        // de configuracion
        SharedPreferences preferences =
                getSharedPreferences(getString(R.string.app_name), // Nombre archivo
                        Context.MODE_PRIVATE); // Solo nuestra app puede leer esto
        SharedPreferences.Editor editor = preferences.edit(); // Abrir el archivo para escritura
        editor.putString("username", usernameEditText.getText().toString()); // Almacenar el valor
        editor.commit(); // Guardar cambios

            ///////////////

                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                RequestUsersAsyncTask task = new RequestUsersAsyncTask();
                task.execute();
                task.equals(username);


            //////////

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);


    }
}
