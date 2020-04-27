package cn.org.bjca.practice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        System.out.println("main2 add master003");
    }

    private void main2Master() {
        System.out.println("hello");
    }

    private void main2Master001() {
        System.out.println("hello001");
    }

    private void main2Master002() {
        System.out.println("hello002");
    }
}
