import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

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
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(col);
        g2d.setStroke(new BasicStroke(wid));
        Rectangle rect = g2d.getClipBounds();


        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");

        double y = 0D;
        try{
            engine.put("x",0);
            y = (Double)engine.eval(function);
        }catch(ScriptException e){
            e.printStackTrace();
        }

        int prevx = (int)(background.reletiveConvertX(0)*rect.width);
        int prevy = rect.height-(int)(background.reletiveConvertY(y)*rect.height);
        for(float f = this.range.x;f<this.range.y;f+=background.getHorizontalLen()/100){
            try{
                engine.put("x",f);
                y = (Double)engine.eval(function);
            }catch(ScriptException e){
                e.printStackTrace();
            }

            int curx = (int)(background.reletiveConvertX(f)*rect.width);
            int cury = rect.height-(int)(background.reletiveConvertY(y)*rect.height);

            g2d.drawLine(prevx,prevy,curx,cury);

            prevx = curx;
            prevy = cury;
        }

    }



    public double run(float x){

        return 0D;
    }


}