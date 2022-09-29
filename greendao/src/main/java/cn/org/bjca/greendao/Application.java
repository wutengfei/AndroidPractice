package cn.org.bjca.greendao;

import cn.org.bjca.greendao.bean.DaoMaster;
import cn.org.bjca.greendao.bean.DaoSession;

/**
 * Author: wutengfei
 * Date: 2022/9/28
 * Description:
 */
public class Application extends android.app.Application {
    private DaoMaster daoMaster;
    private static DaoSession daoSession;
    private DaoMaster.DevOpenHelper devOpenHelper = null;

    @Override
    public void onCreate() {
        super.onCreate();
        devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "databaseName.db", null);
        //实例化DaoMaster对象
        daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        //实例化DaoSession对象
        daoSession = daoMaster.newSession();
    }


    //通过此方法,进行增删改查
    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
