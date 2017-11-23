import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "shape")
// 控制JAXB 绑定类中属性和字段的排序
public class shape implements Paintable{

    @XmlJavaTypeAdapter(ColorAdapter.class)
    private Color col;

    private int wid;

    private String type;

    private Boolean pad;

    @XmlJavaTypeAdapter(PairAdapter.class)
    private MPair center;

    private float width;

    private float height;

    public void paint(Graphics g,bg background){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(wid));
        Rectangle rect = g2d.getClipBounds();
        g2d.setColor(col);
        type = type.replaceAll("\\s","");
        if(type.equals("oval")){
            int x = (int)(background.reletiveConvertX(center.x)*rect.width);
            int y = rect.height-(int)(background.reletiveConvertY(center.y)*rect.height);
            if(pad){
                int Pwid = (int)(width*rect.width);
                int Phig = (int)(int)(height*rect.height);
                g2d.fillOval(x-Pwid/2, y-Phig/2, Pwid, Phig);

            }
            else{
                int Pwid = (int)(width*rect.width);
                int Phig = (int)(int)(height*rect.height);
                g2d.drawOval(x-Pwid/2, y-Phig/2, Pwid, Phig);

            }
        }
        else{
            int x = (int)(background.reletiveConvertX(center.x)*rect.width);
            int y = rect.height-(int)(background.reletiveConvertY(center.y)*rect.height);
            if(pad){
                g2d.fillRect(x-(int)(width*rect.width/background.getHorizontalLen()/2),
                        y- (int)(height*rect.height/background.getVerticalLen()/2), (int)(width*rect.width/background.getHorizontalLen()), (int)(height*rect.height/background.getVerticalLen()));

            }
            else{
                g2d.drawRect(x-(int)(width*rect.width/background.getHorizontalLen()/2),
                        y- (int)(height*rect.height/background.getVerticalLen()/2), (int)(width*rect.width/background.getHorizontalLen()), (int)(height*rect.height/background.getVerticalLen()));

            }
        }
    }

}
