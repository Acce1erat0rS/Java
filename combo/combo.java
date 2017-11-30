import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class combo extends JFrame {
    JTextArea jta = new JTextArea();
    JComboBox<String> jcb = new JComboBox<>();

    public combo() {
        JButton odd = new JButton("ODD");
        JButton even = new JButton("Even");

        JPanel up = new JPanel();
        JPanel bottom  = new JPanel();

        bottom.setLayout(new FlowLayout());
        up.setLayout(new FlowLayout());

        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        con.add(BorderLayout.NORTH,up);
        for(int i=0;i<10;i++){
            jcb.addItem(""+i);
        }
        up.add(jcb);

        con.add(BorderLayout.CENTER,jta);
        con.add(BorderLayout.SOUTH,bottom);
        bottom.add(odd);
        bottom.add(even);

        odd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = (int)(Math.random()*5)*2+1;
                jcb.setSelectedIndex(i);
            }
        });

        even.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = (int)(Math.random()*5)*2;
                jcb.setSelectedIndex(i);
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50,50,500,400);
        setVisible(true);
        setContentPane (con);
    }

    public static void main(String[] args){
        new combo();

    }
}
