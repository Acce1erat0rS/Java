import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class points implements Paintable{
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

    public void paint(Graphics g){

    }


}
