public class Test {
    public static void main(String []args) {
        Integer a = 100;//此处若使用new，则==值必为false
        Integer b = 100;
        System.out.println(a==b);//true
        Integer c = 150;
        Integer d = 150;
        System.out.println(c==d);//false



        Class ca = new java.util.ArrayList<Integer>();

    }
}