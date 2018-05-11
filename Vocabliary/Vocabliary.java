import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.*;
public class Vocabliary extends JFrame{
    JButton a = new JButton("我会了");
    JButton b = new JButton("再出现一次吧");
    JButton c = new JButton("多出现一些");
    JButton d = new JButton("完全不会");

    JTextArea jta = new JTextArea();
    JTextArea jtin = new JTextArea();

    ArrayList<Word> dat = new ArrayList<>();


    public Vocabliary(){
        this.init();
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        JPanel interactionPanel = new JPanel();
        JPanel area = new JPanel();
        area.setLayout(new GridLayout());
        area.add(jta);
        area.add(jtin);

        interactionPanel.setLayout(new GridLayout());

        interactionPanel.add(d);
        interactionPanel.add(c);
        interactionPanel.add(b);
        interactionPanel.add(a);
        con.add(interactionPanel,BorderLayout.SOUTH);
        con.add(area,BorderLayout.CENTER);

        //jta.setText();

        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


//        BufferedWriter bw=new BufferedWriter(new FileWriter(f));
//        for(int i=0;i<al.size();i++){
//            bw.write(al.get(i));
//            bw.newLine();
//        }
//        bw.close();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,400,400,200);
        setVisible(true);


    }

    private void init(){
        StringBuffer sb= new StringBuffer("");

        try{
            FileReader reader = new FileReader("/Users/sp1ca/IdeaProjects/java_git/Vocabliary/a");
            BufferedReader br = new BufferedReader(reader);

            String str = null;

            while((str = br.readLine()) != null) {
                sb.append(str+"/n");

                Word wd = new Word();
                wd.rate =20;
                wd.A = str;
                wd.CE = str.replaceAll("[A-Z]", "*");
                wd.CE = wd.CE.replaceAll("[a-z]", "*");;

                wd.EC = str.replaceAll("[\\u4e00-\\u9fa5]", "**");
                dat.add(wd);

                System.out.println(str);
            }

            br.close();
            reader.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        new Vocabliary();

    }
}

class Word{
    String CE;
    String EC;
    String A;
    int rate;
}
