import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    public static final String url = "jdbc:mysql://www.liutianyu.cn/EDUCATION";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "acce1erat0r";

    public Connection conn = null;
    public PreparedStatement pst = null;

    public DB() {
        String pwd = System.getProperty("user.dir");
        Properties props = new Properties();
        try{
            props.load(new FileInputStream(pwd+"/config.dat"));

        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);//获取连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getResult(String cmd){
        try {
            String result = "";
            Statement statement = conn.createStatement();


            // 结果集
            ResultSet rs = statement.executeQuery(cmd);

            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");
            System.out.println(" 学号" + "\t" + " 姓名");
            System.out.println("-----------------");

            String name = null;

            while(rs.next()) {

                // 选择sname这列数据
                name = rs.getString("SN");

                // 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
                // 然后使用GB2312字符集解码指定的字节数组
                name = new String(name.getBytes("UTF-8"),"UTF-8");

                // 输出结果
                System.out.println(rs.getString("sno") + "\t" + name);
                result+=rs.getString("sno") + "\t" + name+'\n';
            }

            rs.close();
            conn.close();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
