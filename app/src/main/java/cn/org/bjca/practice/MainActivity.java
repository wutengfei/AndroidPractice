package cn.org.bjca.practice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("这是master");
        System.out.println("this is master001");

    }


    private void newFun01() {
        System.out.println("新方法");
    }
}
