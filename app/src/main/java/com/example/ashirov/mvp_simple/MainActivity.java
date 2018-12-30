package com.example.ashirov.mvp_simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashirov.mvp_simple.mvp.mvpView;
import com.example.ashirov.mvp_simple.mvp.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements mvpView {
    private Button button,button2;
    EditText text1,text2;
    Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        text1 = findViewById(R.id.textView1);
        text2 = findViewById(R.id.textView2);
        this.presenter=new Presenter(this);
        this.button.setOnClickListener(this.presenter);
        this.button2.setOnClickListener(this.presenter);
    }

    @Override
    public void setFistrUserName(String name) {
      text1.setText(name);
    }

    @Override
    public void setSecondUserName(String name) {
      text2.setText(name);
    }

    @Override
    public String getFistrUserName() {
        return this.text1.getText().toString();
    }

    @Override
    public String getSecondUserName() {
        return this.text2.getText().toString();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg+"clicked",Toast.LENGTH_SHORT).show();

    }
}
