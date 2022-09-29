package cn.org.bjca.greendao.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Author: wutengfei
 * Date: 2022/9/28
 * Description:
 */
@Entity
public class UserBean {

    @Id()
    private String userId;
    private String name;


    @Generated(hash = 487073308)
    public UserBean(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }


    @Generated(hash = 1203313951)
    public UserBean() {
    }


    public String toString() {
        return "userId:" + userId + "   name:" + name;
    }


    public String getUserId() {
        return this.userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
