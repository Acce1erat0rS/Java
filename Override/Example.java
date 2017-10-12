class Example_A{
    protected double x=10,y=12.5;
    public void speak(){
        System.out.println("A Speak");
    }
    public void cry(){
        y+=x;
        System.out.println("y="+y);
    }
}

class Example_B extends Example_A{
    int y=100,z;
    public void speak(){
        z=2*y;
        System.out.println("B speak");
        System.out.println(("y="+y +"z="+z));
    }

}

public class Example {
    public static void main(String[] args){
        Example_B b = new Example_B();
        b.cry();
        b.speak();
    }
}
