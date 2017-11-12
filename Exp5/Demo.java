import java.util.*;
import javax.xml.bind.*;

public class Demo {
    public static void main(String[] args){
        String str = "<Instance><bg>\n" +
                "<col> 20,30,140 </col>\n" +
                "<xRange> -0.1, 1.1 </xRange>\n" +
                "<yRange> -0.1, 1.1 </yRange>\n" +
                "</bg>" +
                "" +
                "" +"<bg>\n" +
        "<col> 255,255,255 </col>\n" +
                "<xRange> -0.1, 1.1 </xRange>\n" +
                "<yRange> -0.1, 1.1 </yRange>\n" +
                "</bg>" +
                "</Instance>\n";
        Instance userTest = (Instance) XMLUtil.convertXmlStrToObject(Instance.class, str);
        System.out.println("a");
    }

}
