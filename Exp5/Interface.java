import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Interface extends JFrame{
    JButton bt = new JButton("绘图");
    JButton bt2 = new JButton("配置样例");
    JTextArea jta = new JTextArea();
    JTextArea jtin = new JTextArea();
    String context = "";
    JPanel leftCanvas;

    public Interface(){
        Container con = this.getContentPane();

        JPanel leftCanvas=new JPanel();

        JPanel p2=new JPanel();

        this.leftCanvas = new JPanel();

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
                context = jta.getText();
                Instance ins = (Instance) XMLUtil.convertXmlStrToObject(Instance.class, context);
                leftCanvas.add(BorderLayout.CENTER, new mCanvas(ins));
                setVisible(true);
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
        //int width = con.getWidth();
        splitPane.setDividerSize (8);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(20,20,1200,700);
        setVisible(true);
        splitPane.setDividerLocation(0.8);
        //leftCanvas.setBackground(Color.BLACK);


        leftCanvas.setLayout(new BorderLayout());

        setVisible(true);

        
        paintComponents(this.getGraphics());
        setResizable(false);

        setContentPane (splitPane);
    }
    public static void main(String[] args){
        new Interface();

    }
}


class mCanvas extends JPanel{

    Instance instance;


    public mCanvas(Instance instance){
        setBackground(instance.bg.get(0).getcol());
        this.instance = instance;
    }

    @Override
    public void paint(Graphics g){

        instance.bg.get(0).getxRange();
        super.paintComponent(g);
        ArrayList<Paintable>lsp = new ArrayList<>();
        lsp = (ArrayList<Paintable>) instance.getPaintable();
        for(Paintable shape:lsp){
            shape.paint(g,instance.bg.get(0));
        }


    }



}
