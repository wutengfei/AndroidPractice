package cn.org.bjca.greendao.dbhelper;

import android.content.Context;

import java.util.List;

import cn.org.bjca.greendao.Application;
import cn.org.bjca.greendao.bean.UserBean;
import cn.org.bjca.greendao.bean.UserBeanDao;

/**
 * Author: wutengfei
 * Date: 2022/9/28
 * Description:
 */
public class GreenDaoHelper {
    private Context context;
    private static UserBeanDao userBeanDao;
    private static GreenDaoHelper instance;


    private GreenDaoHelper(Context context) {
        this.context = context;
    }

    public static GreenDaoHelper getInstance(Context context) {
        instance = new GreenDaoHelper(context);
        userBeanDao = Application.getDaoSession().getUserBeanDao();
        return instance;
    }

    public void insert(UserBean userBean) {
        userBeanDao.insert(userBean);
    }

    public void deleteUser(UserBean userBean) {
        userBeanDao.delete(userBean);
    }

    public void deleteAll() {
        userBeanDao.deleteAll();
    }

    public void deleteUserById(Long id) {
//        userBeanDao.deleteByKey(id);
    }

    public void update(UserBean userBean) {
        userBeanDao.update(userBean);
    }

    public List<UserBean> query(String userId) {
        return userBeanDao.queryBuilder().where(UserBeanDao.Properties.UserId.eq(userId)).list();
    }

    public List<UserBean> queryAll() {
        return userBeanDao.loadAll();
    }
}
