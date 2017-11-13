import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class lines implements Paintable {
    @XmlJavaTypeAdapter(ColorAdapter.class)
    Color col;

    int wid;

    @XmlJavaTypeAdapter(ListAdapter.class)
    ArrayList<MPair> list;


    public void paint(Graphics g){


    }
}
