import java.io.IOException;

class Example_A{
    protected double x=10,y=12.5;
    public void speak() // throws Exception{
    {
        System.out.println("A Speak");
    }
    public void cry(){
        y+=x;
        System.out.println("y="+y);
    }
}

class Example_B extends Example_A{
    int y=100,z;
    // 复写方法时，要保证参数完全一样
    // 否则则是过载
    //
    // 同时要求@Override的函数的范围要变大或不变
    // throw出的异常也要更具体，因为不可能父类的错误可捕获，子类不可以
    @Override public void speak() // throws IOException{
    {
        z=2*y;
        System.out.println("B speak");
        System.out.println(("y="+y +" z="+z));
    }

}

public class Example {
    public static void main(String[] args){

        System.out.println("Ptr to A");
        Example_A a = new Example_A();
        a.cry();
        a.speak();

        System.out.println("\nPtr to B");
        Example_B b = new Example_B();
        b.cry();//b.cry()中的x和y是继承和隐藏的两个变量
        b.speak();
    }
}
