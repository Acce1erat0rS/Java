//package java_git.Exp4;
import java.lang.reflect.Parameter;
import java.lang.reflect.Array;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class Exp4{
    public static void main(String[] args){
        for(String className : args){
            ClassWrapper cw = new ClassWrapper(className);
            cw.printString();
        }
    }
}



