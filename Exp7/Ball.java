import java.awt.geom.Rectangle2D;

public class Ball extends Thread{
    int x = 5;
    int y = 5;

    int Vspeed = 10;
    int Hspeed = 10;

    public void move(Rectangle2D bounds, boolean flagStop){
        ////// 该方法可以让小球在包含它的面板上移动，
        //////是否移动要看flagStop的设置。
        if(flagStop){
            return;
        }

        if(x>bounds.getMaxX()){
            Hspeed = -Hspeed;
            x = (int)bounds.getMaxX()-(x-(int)bounds.getMaxX());
        }
        if(y>bounds.getMaxY()){
            Vspeed = -Vspeed;
            y = (int)bounds.getMaxY()-(y-(int)bounds.getMaxY());

        }
        if(x<bounds.getMinX()){
            Hspeed = -Hspeed;
            x = (int)bounds.getMinX()+((int)bounds.getMinX()-x);
        }
        if(y<bounds.getMinY()){
            Vspeed = -Vspeed;
            y = (int)bounds.getMinY()+((int)bounds.getMinY()-y);

        }

        x+=Hspeed;
        y+=Vspeed;

        try{
            Thread.sleep(20);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){

    }
}
