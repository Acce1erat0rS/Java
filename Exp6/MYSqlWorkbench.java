import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

//import com.mysql.jdbc.*;

public class MYSqlWorkbench extends JFrame {
    JTextArea jta = new JTextArea();
    JTextArea out = new JTextArea();
    JPanel north = new JPanel();
    JButton get = new JButton();
    JButton clear = new JButton();


    public MYSqlWorkbench(){
        Container con = this.getContentPane();
        BorderLayout bl = new BorderLayout();
        bl.setHgap(20);
        con.setLayout(bl);
        north.setLayout(new BorderLayout(10,10));
        get.setText("查询");
        clear.setText("清空");
        north.add(BorderLayout.EAST,get);
        north.add(BorderLayout.WEST,clear);
        north.add(BorderLayout.CENTER,new JScrollPane(jta));

        //设置上下滑动分割条
        JSplitPane splitPane = new JSplitPane ();
        splitPane.setContinuousLayout (true);
        splitPane.setPreferredSize (new Dimension (800,100));
        splitPane.setOrientation (JSplitPane.VERTICAL_SPLIT);
        splitPane.setRightComponent(new JScrollPane(out));
        splitPane.setLeftComponent(north);

        con.add(splitPane);

        get.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DB db = new DB();
                out.setText(db.getResult("Select * from Student"));
                db.close();
                //System.out.println();)
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(20,20,1200,700);
        setVisible(true);
    }

    public void Connect(){
        Properties props = new Properties();
        //props.load(new FileInputStream(userDir + “/” + paraFile));
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException CFE){
            System.out.println(CFE.getStackTrace());
        }
        //String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
        //Connection con = DriverManager.getConnection(url, user, password);

    }


    public static void main(String[] args){
        MYSqlWorkbench bench = new MYSqlWorkbench();

    }

}




