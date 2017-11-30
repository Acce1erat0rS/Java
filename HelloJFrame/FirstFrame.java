import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FirstFrame extends JFrame{
    JButton bt = new JButton("Minion");
    JTextArea jta = new JTextArea();
    JTextArea jtin = new JTextArea();

    public void actionPerformed(ActionEvent ae){
    }

    public FirstFrame(){
        Container con = this.getContentPane();
        //con.setLayout(new FlowLayout());
        //con.setLayout(new GridLayout(2,3,5,5));


        JPanel p1=new JPanel();

        JPanel p2=new JPanel();

        p1.setLayout(new BorderLayout());

        p2.setLayout(new GridLayout(2,2));

        p1.add(BorderLayout.NORTH,jtin);
        p1.add(BorderLayout.CENTER,new JScrollPane(jta));
        p2.add(BorderLayout.NORTH,bt);
        //p1.add(new JButton("Hello" ));
        //for(int i=0;i<4;i++)
        //    p2.add(new JButton("Hello" ));
        //p2.add(new JButton("Hello" ));

        int count =0;
        bt.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     Object obj = e.getSource();
                                     while (count < jtin.getLineCount())
                                         for (int i = 0; i < jtin.getRows(); i++) {
                                             try {
                                                 System.out.println(jtin.getText(jtin.getLineStartOffset(count), jtin.getLineEndOffset(i)));
                                             } catch (Exception exception) {
                                             }
                                         }
                                 }
                             });



        JSplitPane splitPane = new JSplitPane ();

        //splitPane.setOneTouchExpandable (true);
        splitPane.setContinuousLayout (true);

        splitPane.setPreferredSize (new Dimension (800,600));

        splitPane.setOrientation (JSplitPane.HORIZONTAL_SPLIT);

        splitPane.setLeftComponent (p1);
        splitPane.setRightComponent (p2);

        splitPane.setDividerSize (10);
        splitPane.setDividerLocation(0.8);

        con.add(splitPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50,50,500,400);
        setVisible(true);

        setContentPane (splitPane);
    }
    public static void main(String[] args){
        new FirstFrame();

    }
}
