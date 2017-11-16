import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "shape")
// 控制JAXB 绑定类中属性和字段的排序
public class shape implements Paintable{

    @XmlJavaTypeAdapter(ColorAdapter.class)
    Color col;

    int wid;

    String type;

    Boolean pad;

    @XmlJavaTypeAdapter(PairAdapter.class)
    MPair center;

    float width;
    float height;

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
                //TODO:change the width and height relative to bg's width and height
                g2d.fillOval(x, y, (int)(width*rect.width), (int)(height*rect.height));

            }
            else{
                g2d.drawOval(x, y, (int)(width*rect.width), (int)(height*rect.height));

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
