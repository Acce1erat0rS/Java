import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class bg implements Paintable{

    @XmlJavaTypeAdapter(ColorAdapter.class)
    private Color col;

    @XmlJavaTypeAdapter(PairAdapter.class)
    private MPair xRange;

    @XmlJavaTypeAdapter(PairAdapter.class)
    private MPair yRange;

    public String getxRange() {
        return xRange.toString();
    }
    public void setxRange(String s) {
        xRange.x =20;
        xRange.y = 3.3f;
    }

    public void paint(Graphics g,bg background){
        g.setColor(this.col);
    }

    public Color getcol() {
        return this.col;
    }

    public void setcol(Color col) {
        this.col = col;
    }

    public float reletiveConvertX(float x){
        return (x-xRange.x)/(xRange.y-xRange.x);
    }
    public float reletiveConvertY(float y){
        return (y-yRange.x)/(yRange.y-yRange.x);
    }

    public double reletiveConvertX(double x){
        return (x-xRange.x)/(xRange.y-xRange.x);
    }
    public double reletiveConvertY(double y){
        return (y-yRange.x)/(yRange.y-yRange.x);
    }

    public float getVerticalLen(){return  yRange.y-yRange.x;};
    public float getHorizontalLen(){return  xRange.y-xRange.x;}
}
