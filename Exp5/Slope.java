public class Slope {
    float value;
    boolean isInfinate;

    @Override
    public String toString(){
        if(isInfinate)
            return "inf";
        else
            return ""+value;
    }
}
