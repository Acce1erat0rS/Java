
import dnl.utils.text.table.TextTable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DB {
    private String url;
    private String password;
    private String user;

    public Connection conn = null;

    public DB() {
        String pwd = System.getProperty("user.dir");
        Properties props = new Properties();
        try{
            props.load(new FileInputStream(pwd+"/Exp6/config.dat"));

        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

        url = "jdbc:mysql://"+props.getProperty("host")+"/"+props.getProperty("db");
        user = props.getProperty("user");
        password = props.getProperty("password");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getColumnList(String table){
        ArrayList<String> res = new ArrayList<>();
        try{
            Statement statement = conn.createStatement();
            String cmd = "SHOW COLUMNS FROM "+table;
            ResultSet rs = statement.executeQuery(cmd);

            String name = "";
            while(rs.next()) {
                name = rs.getString("Field");
                res.add(name);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return res;
    }


    public String getResult(String cmd){
        try {
            String result = ">"+cmd+"\n";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(cmd);

            String name = null;

            ResultSetMetaData rsmt = rs.getMetaData();

            int len = rsmt.getColumnCount();

            for(int i=0;i<len;i++){
                result+="+--------------";
            }
            result+="+\n";

            for(int i=0;i<len;i++){
                String ColName = String.format("%14s",rsmt.getColumnName(i+1));
                result+="|"+ColName;
            }
            result+="|\n";
            for(int i=0;i<len;i++){
                result+="+--------------";
            }
            result+="+\n";

            while(rs.next()) {
                for(int i=0;i<len;i++){
                    String dat = rs.getString(i+1);
                    result+="|"+String.format("%14s",dat);
                    dat = new String(dat.getBytes("UTF-8"),"UTF-8");
                }
                result+="|\n";
            }

            for(int i=0;i<len;i++){
                result+="+--------------";
            }
            result+="+\n\n";



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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
