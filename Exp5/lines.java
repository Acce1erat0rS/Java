import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class lines extends BaseShape implements Paintable {
    @XmlJavaTypeAdapter(ColorAdapter.class)
    Color col;

    int wid;

    @XmlJavaTypeAdapter(ListAdapter.class)
    ArrayList<MPair> list;


    public void paint(Graphics g,bg background){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(col);
        g2d.setStroke(new BasicStroke(wid));
        Rectangle rect = g2d.getClipBounds();
        int prevx = (int)(background.reletiveConvertX(list.get(0).x)*rect.width);
        int prevy = rect.height-(int)(background.reletiveConvertY(list.get(0).y)*rect.height);
        for(MPair mp:this.list){
            int curx = (int)(background.reletiveConvertX(mp.x)*rect.width);
            int cury = rect.height-(int)(background.reletiveConvertY(mp.y)*rect.height);

            g2d.drawLine(prevx,prevy,curx,cury);

            prevx = curx;
            prevy = cury;
        }

    }
}
