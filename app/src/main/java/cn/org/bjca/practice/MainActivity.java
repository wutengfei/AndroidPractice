package cn.org.bjca.practice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Student student = new Student();
        student.setAge(10);
        student.setName("");
        MClass mClass = new MClass();
        mClass.setBanji("1班");
        mClass.setStudent(student);
        String s = JsonUtil.object2Json(mClass);
        System.out.println(s);
    }
}
