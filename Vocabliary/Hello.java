//import javax.swing.*;
//import java.awt.*;
//
//public class Hello extends JFrame{
//    Container con = this.getContentPane();
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setBounds(600,400,400,200);
//    setVisible(true);
//}


class A{
    protected double y = 12.56; }
class B extends A{
    int y = 0;
    void g(){
        y += 100; System.out.println("y=" + y);}
}
class Hello{
    public static void main(String[] args){
        B b = new B();
        A a = b;
        System.out.println(a.y);
        b.g();
    }
}
