public class Exp3 {
    public static void main(String[] args){
        long m = Long.parseLong(args[0]);
        binomialDistribution B = new binomialDistribution(0.5,m);
        System.out.println(B.maximumExpection());
    }
}

interface iterable{
    double getSmaller();
    double getBigger();
}

interface calcuatable{
    void do_math();
    double getResult();
}

abstract class distribution{
    public abstract double maximumExpection();
}

class binomialDistribution extends distribution{
    long m;
    double p;
    public binomialDistribution(double p,long n){
        this.m = n;
        this.p = p;
    }

    @Override
    public double maximumExpection(){
        calculator cal = new calculator(1,m);
        cal.do_math();
        return cal.getResult();
    }
}

class calculator implements iterable,calcuatable{
    private long start;
    private long end;
    private long cur_start;
    private long cur_end;
    private double result = 1.0;

    public calculator(long start,long end){
        this.start = start;
        this.end = end;
        cur_end = this.end;
        cur_start = this.start;
    }


    public void do_math(){
        while(cur_end>=cur_start){
            if(result>1)
                result*=getSmaller();
            else
                result*=getBigger();
        }
    }

    double appendent(long i){
        return 0.25*(this.end+i)/i;
    }

    public double getSmaller(){
        return appendent(cur_end--);
    }

    public double getBigger(){
        return appendent(cur_start++);

    }

    public double getResult(){
        return result;
    }
}