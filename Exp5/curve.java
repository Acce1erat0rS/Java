import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;

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

    public void paint(Graphics g){

    }
}
