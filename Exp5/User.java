import java.awt.*;
import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "User")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "userId",
        "userName",
        "password",
        "birthday",
        "money",
        "n"
})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    // 用户Id
    private int userId;
    // 用户名
    private String userName;
    // 用户密码
    private String password;
    // 用户生日
    private Date birthday;
    // 用户钱包
    private double money;

    public float[] n;

    public User() {
        super();
    }

    public User(int userId, String userName, String password, Date birthday,
                double money) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.birthday = birthday;
        this.money = money;

        n = new float[10];
        for (int i = 0;i<10;i++)
            n[i] = 3.3f;
        //this.s = new shape();
        //s.color = new Color(0,0,0);
        //s.color = Color.MAGENTA;
        //s.width = 30;
    }

    /*
    晚些再来研究这个，这些标签有没有可能使我不需要单独处理点对？
    @XmlElementWrapper
    @XmlElement(name="keyword")
    public List<String> getKeywords() {
        return keywords;
    }
    */

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        for(float i:n)
            System.out.println(i);
        return "User [birthday=" + birthday + ", money=" + money
                + ", password=" + password + ", userId=" + userId
                + ", userName=" + userName + "]";
    }

}
