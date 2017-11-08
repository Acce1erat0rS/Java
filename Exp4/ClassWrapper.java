import java.lang.reflect.*;

public class ClassWrapper {
    private String className;
    private Class<?> c;
    private Method[] methods;
    private Field[] fields;
    private Member[] members;
    private Method[] constructionMethod;
    Constructor[] constructors;
    String indent = "        ";



    public ClassWrapper(String className){
        this.className = className;
        try {
            c = Class.forName(this.className);
            methods = c.getDeclaredMethods();
            fields = c.getDeclaredFields();
        }
        catch (ClassNotFoundException e) {
            this.wrapperErr(e);
        }
    }

    @Override
    public String toString(){
        System.out.println(Modifier.toString(c.getModifiers())+" class "+c.getName()+"{\n");
        prConstructor();
        for(Method m :methods){
            System.out.println(indent+getMehod(m)+"\n");
        }
        System.out.println("\n");
        for(Field f : fields){
            System.out.println(indent+getField(f)+"\n");
        }
        System.out.println("}\n");
        return "";
    }

    private String getField(Field f){
        return Modifier.toString(f.getModifiers())+" "+f.getType().getTypeName()+" "+f.getName()+";";
    }


    private String getParaList(Method m){
        StringBuffer buffer = new StringBuffer("");
        int flag = 0;
        for(Class s : m.getParameterTypes()){
            buffer.append(s.getName()+',');
        }
        if(m.getParameterTypes().length>0)
            buffer.deleteCharAt(buffer.length()-1);
        return buffer.toString();
    }

    private String getMehod(Method m){
        StringBuffer buffer = new StringBuffer("");
        buffer.append(Modifier.toString(m.getModifiers())+" ");
        buffer.append(m.getReturnType().toString()+" "+m.getName());
        buffer.append("("+getParaList(m)+");");
        return buffer.toString();
    }

    public void prConstructor(){

        this.constructors = c.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println(indent+constructor.toString()+";\n");
        }
    }

    private void wrapperErr(Exception e){
        System.out.println("Exception Found: "+e.toString());
        System.out.println("Exception Message: "+e.getMessage());
        System.out.println("---------- Stace Trace ----------");
        for(StackTraceElement ste :e.getStackTrace())
            System.out.println(ste.toString());
        System.out.println("---------------------------------");
    }
}
