


public class func {
    int f;
    public static void main(String[] args){
        if(args.length == 0){
            return;
        }
        String out = "";
        for(String s:args){
            float x = Float.parseFloat(s);
            float result = (float)(Math.pow(x,2)-0.05);
            out = out+result+" ";
        }
        System.out.println(out);
    }
}
