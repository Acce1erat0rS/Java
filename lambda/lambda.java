import javax.swing.*;
import java.awt.*;

public class lambda extends JFrame{
    JButton Banana = new JButton("Banana");
    JTextArea jta = new JTextArea();

    public static void main(String[] args){
        lambda la = new lambda();

    }

    public lambda(){
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        con.add(BorderLayout.NORTH,Banana);
        con.add(BorderLayout.CENTER,jta);

        int a = 0;

        Banana.addActionListener((action)->{

            jta.append("Banana!\n");
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(20,20,300,500);
        setVisible(true);
    }

}

interface add{
    public int addOn(int a);
}
