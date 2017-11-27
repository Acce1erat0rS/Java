import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class mCanvas extends JPanel {
    Ball ball;
    boolean moving = false;

    public mCanvas(Ball ball){
        this.ball = ball;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Rectangle rect =  g.getClipBounds();
        ball.move(rect,moving);
        g.fillOval(ball.x,ball.y,20,20);
        repaint();
    }



}