public class Exp3 {
    public static void main(String[] args){
        //int m = Integer.parseInt(args[0]);
        long m = 100000000L;//9223372036854774807
        binomialDistribution B = new binomialDistribution(0.5,m);
        System.out.println(B.maximumExpection());
    }
}

class distribution{
}

class binomialDistribution extends distribution{
    long m;
    double p;
    public binomialDistribution(double p,long n){
        this.m = n;
        this.p = p;
    }

    public double maximumExpection(){
        calculator cal = new calculator(1,m);
        cal.do_math();
        return cal.get_result();
    }
}

class calculator{
    long start;
    long end;
    long cur_start;
    long cur_end;
    double result = 1.0;

    public calculator(long start,long end){
        this.start = start;
        this.end = end;
        cur_end = this.end;
        cur_start = this.start;
    }

    public void do_math(){
        while(cur_end>=cur_start){
            if(result>1)
                smaller();
            else
                bigger();
        }
    }

    double appendent(long i){
        return 0.25*(this.end+i)/i;
    }

    public void smaller(){
        this.result*=appendent(cur_end);
        cur_end--;
    }

    public void bigger(){
        this.result*=appendent(cur_start);
        cur_start++;
    }

    public double get_result(){
        return result;
    }
}