import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
public class MPair {
    float x;
    float y;

    public MPair(){
    };

    @Override
    public String toString(){
        return(""+x+","+y);
    }

    public static MPair getInstance(String str){
        MPair m = new MPair();
        str = str.replaceAll("\\s","");
        m.x = Float.parseFloat(str.split(",")[0]);
        m.y = Float.parseFloat(str.split(",")[1]);
        return m;
    }

    public MPair(String s){
        x = 100;
        y = 250;
    }
}
