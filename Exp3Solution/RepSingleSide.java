import sun.security.rsa.RSASignature;

public class RepSingleSide implements SingleSide {
    private double value;
    private int amount;
    private int pointer = 0;

    public RepSingleSide(double value,int amount){
        this.value = value;
        this.amount = amount;
    }

    public boolean isGreater(){
        return value>=1.0;
    }

    public boolean hasNext(){
        return pointer<amount;
    }

    public double getNext(){
        pointer++;
        return value;
    }
}
