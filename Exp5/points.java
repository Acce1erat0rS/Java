import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class points extends BaseShape implements Paintable{
    /*<points>
     *<pad> true </pad>
     *<col> red </col>
     *<wid> 2 </wid>
     *<radius> 6 </radius>
     *<list>
     *0.2, 0.2
     *0.2, 0.5
     *0.2, 0.8
     *0.5, 0.8
     *0.8, 0.8
     *0.8, 0.5
     *0.8, 0.2
     *0.5, 0.2
     *</list>
     *</points>
    */


    boolean pad;

    @XmlJavaTypeAdapter(ColorAdapter.class)
    Color col;

    int wid;

    int radius;

    @XmlJavaTypeAdapter(ListAdapter.class)
    ArrayList<MPair> list;

    public void paint(Graphics g,bg background){
        Graphics2D mG = (Graphics2D) g;
        Rectangle rect = mG.getClipBounds();
        mG.setColor(col);
        mG.setStroke(new BasicStroke(wid));

        if(pad){
            for(MPair p : list){
                int x = (int)(background.reletiveConvertX(p.x)*rect.width);
                int y = rect.height-(int)(background.reletiveConvertY(p.y)*rect.height);
                mG.fillOval(x-radius, y-radius, 2*radius, 2*radius);
            }
        }else{
            for(MPair p : list){
                int x = (int)(background.reletiveConvertX(p.x)*rect.width);
                int y = rect.height-(int)(background.reletiveConvertY(p.y)*rect.height);
                mG.drawOval(x-radius, y-radius, 2*radius, 2*radius);
            }
        }

    }


}

/*public void paint(Graphics g,bg background){
        Graphics2D mG = (Graphics2D) g;
        Rectangle rect = g.getClipBounds();
        mG.setColor(col);
        mG.setStroke(new BasicStroke(wid));

        if(pad){
            for(MPair p : list){
                int x = (int)(background.reletiveConvertX(p.x)*rect.width);
                int y = (int)(background.reletiveConvertY(p.y)*rect.height);
                mG.fillOval(x, y, radius, radius);
            }
        }else{
            for(MPair p : list){
                int x = (int)(background.reletiveConvertX(p.x)*rect.width);
                int y = (int)(background.reletiveConvertY(p.y)*rect.height);
                mG.drawOval(x, y, radius, radius);
            }
        }

    }*/
