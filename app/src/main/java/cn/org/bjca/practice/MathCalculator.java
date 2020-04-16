package cn.org.bjca.practice;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MathCalculator {
    public void testFanShe() {
        try {
            // 创建对象
            Class<?> mClass = Class.forName("cn.org.bjca.practice.Student");
            Object object = mClass.newInstance();
            Student student = (Student) object;
            student.setAge(19);
            student.setName("Lucy");
            Log.e("student", student.toString());

            // 反射私有的构造方法
            Constructor<?> constructor1 = mClass.getDeclaredConstructor(String.class, int.class);
            constructor1.setAccessible(true);
            Object stu2 = constructor1.newInstance("Bob", 13);
            Student student2 = (Student) stu2;
            Log.e("student", student2.toString());
            // 反射私有属性
            Field field = mClass.getDeclaredField("name");
            field.setAccessible(true);
            String name = (String) field.get(stu2);
            Log.e("name", name);

            // 反射私有方法
            Method method = mClass.getDeclaredMethod("setNameAndAge", String.class, int.class);
            method.setAccessible(true);
            method.invoke(object, "Judy", 18);
            Log.e("Student", ((Student) object).toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
