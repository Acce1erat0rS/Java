import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exp7 extends JFrame{
    JButton vadd = new JButton("增加纵向速度");
    JButton vmin = new JButton("减小纵向速度");
    JButton hadd = new JButton("增加横向速度");
    JButton hmin = new JButton("减小横向速度");
    JButton start = new JButton("移动");
    JButton stop = new JButton("停止");
    mCanvas mc;

    public static void main(String[] args){
        Exp7 ex = new Exp7();

    }

    public Exp7(){
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(1,6));
        this.setTitle("弹球动画 ———— 151002110 刘天禹");


        menu.add(start);
        menu.add(stop);
        menu.add(hadd);
        menu.add(hmin);
        menu.add(vadd);
        menu.add(vmin);

        con.add(menu,BorderLayout.SOUTH);

        Ball ball = new Ball();
        mc = new mCanvas(ball);
        con.add(mc,BorderLayout.CENTER);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mc.moving = false;
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mc.moving = true;
            }
        });

        vadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ball.Vspeed>0)
                    ball.Vspeed ++;
                else
                    ball.Vspeed--;
            }
        });

        vmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ball.Vspeed>0)
                    ball.Vspeed--;
                else
                    ball.Vspeed++;
            }
        });

        hadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ball.Hspeed>0)
                    ball.Hspeed++;
                else
                    ball.Hspeed--;
            }
        });

        hmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ball.Hspeed>0)
                    ball.Hspeed--;
                else
                    ball.Hspeed++;
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(20,20,1200,700);
        setVisible(true);
    }
}
