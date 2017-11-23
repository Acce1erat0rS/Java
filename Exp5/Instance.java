import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Instance")
public class Instance {

    public List<bg> bg;
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
        if(this.bg!=null)
            for(bg b: bg)
                lp.add(b);
        if(this.curve!=null)
            for(curve c: curve)
                lp.add(c);
        if(this.line!=null)
            for(line l:line)
                lp.add(l);
        if(this.lines!=null)
            for(lines lns:lines)
                lp.add(lns);
        if(this.points!=null)
            for(points pts:points)
                lp.add(pts);
        if(this.shape!=null)
            for(shape shap:shape)
                lp.add(shap);
        if(this.scale!=null)
            for(scale shap:scale)
                lp.add(shap);
        return lp;
    }
}
