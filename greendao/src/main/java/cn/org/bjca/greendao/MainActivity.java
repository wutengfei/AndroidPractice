package cn.org.bjca.greendao;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import cn.org.bjca.greendao.bean.UserBean;
import cn.org.bjca.greendao.dbhelper.GreenDaoHelper;


public class MainActivity extends AppCompatActivity {

    private GreenDaoHelper greenDaoHelper;
    private UserBean lily;
    private UserBean bob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greenDaoHelper = GreenDaoHelper.getInstance(this);

    }

    public void btnInsert(View view) {
        bob = new UserBean("1", "Bob");
        lily = new UserBean("2", "Lily");
        greenDaoHelper.insert(bob);
        greenDaoHelper.insert(lily);
        queryAll();
    }

    public void btnDelete(View view) {
//        List<UserBean> query = greenDaoHelper.query("2");
//        if (query != null)
//            for (int i = 0; i < query.size(); i++) {
//                greenDaoHelper.deleteUser(query.get(i));
//            }
        greenDaoHelper.deleteUserById("2");
        queryAll();
    }

    public void btnUpdate(View view) {
        lily = new UserBean("1", "LilyGood");
        greenDaoHelper.update(lily);
        queryAll();
    }

    public void btnQuery(View view) {
        querySomeone("1");
    }

    public void querySomeone(String userId) {
        List<UserBean> query = greenDaoHelper.query(userId);
        if (query != null) {
            for (int i = 0; i < query.size(); i++) {
                Log.e("greendao", query.get(i).toString());
            }
        }
        Log.e("greendao", "-------------------------------");
    }

    private void queryAll() {
        List<UserBean> list = greenDaoHelper.queryAll();
        for (int i = 0; i < list.size(); i++) {
            Log.e("greendao", "query--->" + list.get(i).toString());
        }
        Log.e("greendao", "-------------------------------");
    }

    public void btnDeleteAll(View view) {
        greenDaoHelper.deleteAll();
    }
}
