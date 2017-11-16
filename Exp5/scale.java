import java.awt.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class scale implements Paintable{

/*    <scale>
        <col> black </col>
        <wid> 1 </wid>
        <direction> x </direction>
        <pos> 0.0 </pos>
        <from> 0 </from>
        <step> 0.1 </step>
        <amount> 10 </amount>
        <precision> 1 </precision>
    </scale>*/

    @XmlElement(name = "col")
    @XmlJavaTypeAdapter(ColorAdapter.class)
    private Color col;

    @XmlElement(name = "wid")
    private int wid;

    @XmlElement(name = "direction")
    private String direction;

    @XmlElement(name = "pos")
    private float pos;

    @XmlElement(name = "from")
    private int from;

    @XmlElement(name = "step")
    private float step;

    @XmlElement(name = "amount")
    private int amount;

    @XmlElement(name = "precision")
    private int precision;

    public void paint(Graphics g, bg background){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(wid));
        Rectangle rect = g2d.getClipBounds();
        g2d.setColor(col);

        direction = direction.replaceAll("\\s","");
        if(direction.equals("y")||direction.equals("Y")){
            float rpos = background.reletiveConvertY(pos);
            int rfrom = (int)(background.reletiveConvertY(from)*rect.height);
            int rto = (int)(background.reletiveConvertY(from+step*amount)*rect.height);
            g2d.drawLine((int)(rpos*rect.width),
                           rect.height - rfrom,
                           (int)(rpos*rect.width),
                    rect.height - rto);

            int count = 0;
            while (count<this.amount){
                g2d.drawLine();


                count++;
            }
        }
        else{
            float rpos = background.reletiveConvertX(pos);
            int rfrom = (int)(background.reletiveConvertX(from)*rect.width);
            int rto = (int)(background.reletiveConvertX(from+step*amount)*rect.width);
                g2d.drawLine(rfrom,rect.height-(int)(rpos*rect.height),
                    rto,rect.height-(int)(rpos*rect.height));

        }


    }
}
