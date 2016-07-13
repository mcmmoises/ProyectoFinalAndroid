package com.software.moisesc.proyfinalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.software.moisesc.proyfinalandroid.model.PostRegister;

public class RegisterActivity extends AppCompatActivity {
    private EditText titleEditText;
    private EditText contentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        titleEditText = (EditText)findViewById(R.id.title_text);
        contentEditText = (EditText)findViewById(R.id.content_text);
    }

    public void savePost(View view) {
        PostRegister post = new PostRegister();

        post.setTitle(titleEditText.getText().toString());
        post.setContent(contentEditText.getText().toString());

        post.save();

        finish();
    }

    public void cancelPost(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
