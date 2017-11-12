import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.awt.*;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "shape")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "col",
        "wid",
        "type",
        "pad",
        "width",
        "height"
})
public class shape extends Paintable{
    String col;
    int wid;
    String type;
    Boolean pad;
    float width;
    float height;


}
