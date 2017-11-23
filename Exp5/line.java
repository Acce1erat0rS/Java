import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class line extends BaseShape implements Paintable {

    @XmlJavaTypeAdapter(ColorAdapter.class)
    Color col;

    int wid;

    @XmlJavaTypeAdapter(PairAdapter.class)
    MPair point;

    @XmlJavaTypeAdapter(SlopeAdapter.class)
    Slope slope;

    public void paint(final Graphics g,bg background){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(wid));
        Rectangle rect = g2d.getClipBounds();
        g2d.setColor(col);
        if(slope.isInfinate){
            g2d.drawLine((int)(background.reletiveConvertX(point.x)*rect.width),
                    0,
                    (int)(background.reletiveConvertX(point.x)*rect.width)
                    ,rect.height);
        }
        else{
            int wwid = rect.width;
            int x = (int)(background.reletiveConvertX(point.x)*rect.width);
            int y = (int)(background.reletiveConvertY(point.y)*rect.height);
            g2d.drawLine((int)(x-wwid),
                    (int)(x+slope.value*wwid),
                    (int)(x+wwid),
                    (int)(x- slope.value*wwid));
        }
    }
}
