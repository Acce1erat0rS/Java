import javafx.scene.control.RadioButton;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Font extends JFrame{
    JTextArea jta = new JTextArea();
    JTextArea jtin = new JTextArea();
    JRadioButton rb1 = new JRadioButton("Large");
    JRadioButton rb2 = new JRadioButton("Small");
    java.awt.Font large = new java.awt.Font("arial",java.awt.Font.ITALIC,30);

    java.awt.Font small = new java.awt.Font("arial",java.awt.Font.ITALIC,10);


    public void actionPerformed(ActionEvent ae){

    }

    public Font() {
        JPanel up = new JPanel();
        up.setLayout(new FlowLayout());
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        con.add(BorderLayout.NORTH,up);
        up.add(rb1);
        up.add(rb2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);

        con.add(BorderLayout.CENTER,jta);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50,50,500,400);
        setVisible(true);
        rb1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(rb1.isSelected())
                    jta.setFont(large);
                else
                    jta.setFont(small);
            }
        });

        setContentPane (con);
    }

    public static void main(String[] args){
        new Font();

    }
}
