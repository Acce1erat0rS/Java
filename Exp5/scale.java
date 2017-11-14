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
    @XmlElement(name = "col")
    @XmlJavaTypeAdapter(ColorAdapter.class)
    private Color col;

    @XmlElement(name = "wid")
    private int wid;

    @XmlElement(name = "direction")
    private char direction;

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

    }
}
