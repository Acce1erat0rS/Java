import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
public class Interface extends JFrame{
    JButton bt = new JButton("绘图");
    JButton bt2 = new JButton("配置样例");
    JTextArea jta = new JTextArea();
    JTextArea jtin = new JTextArea();

    public Interface(){
        Container con = this.getContentPane();

        JPanel leftCanvas=new JPanel();

        JPanel p2=new JPanel();

        JPanel interactionPanel = new JPanel();

        interactionPanel.setLayout(new BorderLayout());
        interactionPanel.add(BorderLayout.CENTER,bt);
        interactionPanel.add(BorderLayout.EAST,bt2);


        //leftCanvas.setLayout(new BorderLayout());

        p2.setLayout(new BorderLayout());

        p2.add(BorderLayout.NORTH,interactionPanel);
        p2.add(BorderLayout.CENTER,new JScrollPane(jta));


        //leftCanvas.add(new JButton("Hello" ));
        //for(int i=0;i<4;i++)
        //    p2.add(new JButton("Hello" ));
        //p2.add(new JButton("Hello" ));

        int count =0;
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Object obj = e.getSource();
                String all = jta.getText();
                System.out.println(all);
            }
        });

        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("/Users/sp1ca/IdeaProjects/java_git/Exp5/layout.xml");
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(file));
                    String tempString;
                    while ((tempString = reader.readLine()) != null) {
                        jta.append(tempString+"\n");
                    }
                    reader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e1) {
                        }
                    }
                }
            }
        });

        JSplitPane splitPane = new JSplitPane ();

        //splitPane.setOneTouchExpandable (true);
        splitPane.setContinuousLayout (true);

        splitPane.setPreferredSize (new Dimension (800,600));

        splitPane.setOrientation (JSplitPane.HORIZONTAL_SPLIT);

        splitPane.setLeftComponent (leftCanvas);
        splitPane.setRightComponent (p2);

        con.add(splitPane);
        int width = con.getWidth();
        splitPane.setDividerSize (8);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(20,20,1200,700);
        setVisible(true);
        splitPane.setDividerLocation(0.8);
        //leftCanvas.setBackground(Color.BLACK);


        leftCanvas.setLayout(new BorderLayout());

        leftCanvas.add(BorderLayout.CENTER, new ShapesPanel());
        leftCanvas.add(BorderLayout.CENTER, new tallPanel());



        setVisible(true);

        
        paintComponents(this.getGraphics());
        setResizable(false);

        setContentPane (splitPane);
    }
    public static void main(String[] args){
        new Interface();

    }
}


class ShapesPanel extends JPanel{
      public ShapesPanel(){
      setBackground(null);
      setOpaque(true);
      }
      public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(Color.YELLOW);
      g.fillRect(200, 200, 600, 100);

      }
}


class tallPanel extends JPanel{
    public tallPanel(){
        //setBackground(Color.white);
        setBackground(null);
        setOpaque(true);
    }

    @Override
    public void paint(Graphics g){
        super.paintComponent(g);
        paintWide(g);
        painttall(g);
    }

    private void paintWide(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(200, 200, 400, 400);
    }
    private void painttall(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(200, 200, 200, 500);
    }

}
