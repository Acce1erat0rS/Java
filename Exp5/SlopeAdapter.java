import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.lang.reflect.Field;

public class SlopeAdapter extends XmlAdapter<String, Slope> {
    public Slope unmarshal(String s) {
        //Default
        s = s.replaceAll("\\s","");
        Slope slope = new Slope();


        try {
            if (s.equals("inf")){
                slope.isInfinate = true;
                slope.value= 0;
            }
            else{
                slope.value =  Float.parseFloat(s);
                slope.isInfinate = false;
            }
        } catch (Exception e) {

        }
        return slope;
    }

    public String marshal(Slope slope) {
        if(slope.isInfinate){
            return "inf";
        }
        else
            return ""+slope.value;
    }
}
