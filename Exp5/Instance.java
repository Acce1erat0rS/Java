import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "Instance")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "bg",
        "curve",
        "line",
        "lines",
        "points"
})
public class Instance {

    List<bg> bg;
    List<curve> curve;
    List<line> line;
    List<lines> lines;
    List<points> points;

    public Instance(){}

    public List<bg> getbg() {
        return this.bg;
    }

    public void setbg(List<bg> bg) {
        this.bg = bg;
    }
}
