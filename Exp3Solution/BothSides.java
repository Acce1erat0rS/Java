import java.util.ArrayList;

public class BothSides {
    private SingleSideArray greater = new SingleSideArray();
    private SingleSideArray less = new SingleSideArray();

    class SingleSideArray{
        ArrayList<SingleSide> ass = new ArrayList<SingleSide>();
        private int pointer = 0;

        void add(SingleSide ss){
            ass.add(ss);
        }

        boolean hasNext(){
            return pointer<ass.size();
        }

        double getNext(){
            SingleSide current = ass.get(pointer);
            double value = current.getNext();
            if(!current.hasNext())
                pointer++;
            return value;
        }

        double getRestProduct(){
            double product = 1.0d;
            while(hasNext()){
                product*=getNext();
            }
            return product;
        }
    }

    public void add(SingleSide ss){
        if(ss.isGreater())
            greater.add(ss);
        else
            less.add(ss);
    }

    public double getProduct(){
        double product = 1.0d;
        while(true){
            if(product>=1){
                if(less.hasNext()){
                    double lessValue = less.getNext();
                    product *= lessValue;
                }
                else
                    break;
            }
            else{
                if(greater.hasNext()){
                    double greaterValue = greater.getNext();
                    product *= greaterValue;
                }
                else
                    break;
            }
        }
        return product;
    }
}
