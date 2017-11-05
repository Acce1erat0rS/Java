//package java_git.Exp4;
import java.lang.reflect.Parameter;
import java.lang.reflect.Array;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;


class Gum {
    static { System.out.println("Loading Gum"); }
}

public class Exp4{
    public static void main(String[] args){
        //Array a;
        //System.out.println("apple");
        //Class c = Class.forName("Array");
        //c.newInstance();
        //String s = "ArrayList";
        //Class c = s.
        //c.newInstance();

        try {
            Class<?> c = Class.forName("java.util.List");
            Method[] m = c.getDeclaredMethods();
            for(Method mm:m)
                System.out.println(mm.toGenericString());
        }
        catch (ClassNotFoundException e) { // catch divide-by-zero error
            System.out.println("ClassNotFoundException");
        }

    }
}

