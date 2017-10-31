import java.util.*;

class Animal{}

class Cat extends Animal{
    public void cry(){
        System.out.println("Meow");
    }
}

public class Generic{
    public static void main(String[] args){
        //这就叫泛型
        //如果前面已经指定<>内类型，后面可以用"<>"代替
        ArrayList<Cat> list = new ArrayList<>();

        for(int i =0;i<3;i++){
            Cat c = new Cat();
            list.add(c);
            //list.add(new Animal());
            //list.add("Plll");

        }

        for(Object obj :list){
            Cat cat = (Cat)obj;
            cat.cry();
        }
    }
}