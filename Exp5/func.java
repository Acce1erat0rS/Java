public class func {
    int f;
    public static void main(String[] args){

        float x = Float.parseFloat(args[0]);
        float result = (float)(2*x);
        System.out.println(result);
    }

    public float getResult(float x){
        f = 30;
        System.out.println("done!");
        return (float)(2*x);
    }
}
