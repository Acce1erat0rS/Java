import java.util.Date;

/**
 *
 * @author Steven
 *
 */
public class Test {
    public static void main(String[] args) {
        // 创建需要转换的对象


        User user = new User(1, "Steven", "@sun123", new Date(), 1000.0);
        //user.s.width = 20;
        //user.s.color = 3;
        System.out.println("---将对象转换成string类型的xml Start---");
        // 将对象转换成string类型的xml
        String str = XMLUtil.convertToXml(user);
        // 输出
        System.out.println(str);
        System.out.println("---将对象转换成string类型的xml End---");
        System.out.println();
        System.out.println("---将String类型的xml转换成对象 Start---");
        User userTest = (User) XMLUtil.convertXmlStrToObject(User.class, str);
        System.out.println(userTest);
        System.out.println("---将String类型的xml转换成对象 End---");
    }
}
