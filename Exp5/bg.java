
import java.awt.*;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class bg {
    //@XmlElement(name = "col")
    @XmlJavaTypeAdapter(ColorAdapter.class)
    private Color col;

    @XmlJavaTypeAdapter(PairAdapter.class)
    private MPair xRange;

    @XmlJavaTypeAdapter(PairAdapter.class)
    public MPair yRange;

    public String getxRange() {
        return xRange.toString();
    }
    public void setxRange(String s) {
        xRange.x =20;
        xRange.y = 3.3f;
    }


    public Color getcol() {
        return this.col;
    }

    public void setcol(Color col) {
        this.col = col;
    }
}
