public class Exp3Solution {
    public static void main(String[] args){
        RepSingleSide rss = new RepSingleSide(0.5,3);
        RepSingleSide rss2 = new RepSingleSide(2,4);
        BothSides bs = new BothSides();
        bs.add(rss);
        bs.add(rss2);
        double product = bs.getProduct();
        System.out.println(product);
    }
}
