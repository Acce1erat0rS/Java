import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "shape")
// 控制JAXB 绑定类中属性和字段的排序
public class shape implements Paintable{

    @XmlJavaTypeAdapter(ColorAdapter.class)
    Color col;

    int wid;

    String type;

    Boolean pad;

    @XmlJavaTypeAdapter(PairAdapter.class)
    MPair center;

    float width;
    float height;

    public void paint(Graphics g){

    }

}
