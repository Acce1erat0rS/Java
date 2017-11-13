import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class line implements Paintable {

    @XmlJavaTypeAdapter(ColorAdapter.class)
    Color col;

    int wid;

    @XmlJavaTypeAdapter(PairAdapter.class)
    MPair point;

    @XmlJavaTypeAdapter(SlopeAdapter.class)
    Slope slope;

    public void paint(Graphics g){

    }
}
