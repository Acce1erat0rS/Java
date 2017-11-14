import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class curve implements Paintable {

    @XmlJavaTypeAdapter(ColorAdapter.class)
    Color col;

    @XmlElement(name = "wid")
    int wid;

    @XmlJavaTypeAdapter(PairAdapter.class)
    MPair range;

    @XmlElement(name = "amount")
    int amount;

    @XmlElement(name = "function")
    String function;

    public void paint(Graphics g,bg background){
        compile();
        for(int i =0;i<20;i++)
            run(i);

    }

    public void compile(){
        try{
            function.replaceAll("\\s","");
            String sh = "./Exp5/compile.sh \'"+function+"\'";
            Process ps = Runtime.getRuntime().exec(sh);
            ps.waitFor();
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }



    public void run(float x){
        try {
            Class c = Class.forName("func");
            Class.forName("func").getMethod("run", new Class[] {}).invoke(null,(Object)x);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}