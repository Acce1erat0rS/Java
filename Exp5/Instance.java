import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "Instance")
public class Instance {

    List<bg> bg;
    List<curve> curve;
    List<line> line;
    List<lines> lines;
    List<points> points;
    List<shape> shape;
    List<scale> scale;

    public Instance(){}

    public List<bg> getbg() {
        return this.bg;
    }

    public void setbg(List<bg> bg) {
        this.bg = bg;
    }

    public List<Paintable> getPaintable(){
        List<Paintable> lp = new ArrayList<>();
        for(bg b: bg){
            lp.add(b);
        }
        for(curve c: curve){
            lp.add(c);
        }
        for(line l:line){
            lp.add(l);
        }
        for(lines lns:lines){
            lp.add(lns);
        }
        for(points pts:points){
            lp.add(pts);
        }
        return lp;
    }
}
