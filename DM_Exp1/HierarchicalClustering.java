import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;




public class HierarchicalClustering extends JFrame {
    /**
     * @Author: TianyuLiu
     * @Description:
     * @Date: 12:56 PM 2018/4/27
     */





    JTextField jta = new JTextField();
    JTextArea out = new JTextArea();
    JPanel north = new JPanel();
    JButton get = new JButton();
    JButton clear = new JButton();

    public HierarchicalClustering(){
        Container con = this.getContentPane();
        BorderLayout bl = new BorderLayout();
        bl.setHgap(20);
        con.setLayout(bl);
        north.setLayout(new BorderLayout());
        get.setText("查询");
        clear.setText("清空");
        north.add(BorderLayout.EAST,get);
        north.add(BorderLayout.WEST,clear);
        north.add(BorderLayout.CENTER,new JScrollPane(jta));
//        out.setFont(new Font("Courier New",Font.BOLD,12));

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
                String cmd = jta.getText();
                jta.setText("Connecting...");

            }
        });

        /**
         * 对jta即 上部输入 添加一个Listener，当被触发后，
         * 新建连接并取出命令，最终将返回的结果输出到out 的
         * JTextArea。
         */
        jta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //新建一个连接对象
                String cmd = jta.getText();
                jta.setText("Connecting...");
                //将查询结果字符串输出

            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                out.setText("");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(20,20,1200,700);
        setVisible(true);
    }




    public static void main(String []args){

    }

}
