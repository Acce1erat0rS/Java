import java.util.*;
import javax.xml.bind.*;

public class Demo {
    public static void main(String[] args){
        String str = "<Instance><bg>\n" +
                "<col> 255,255,255 </col>\n" +
                "<xRange> -0.1, 1.1 </xRange>\n" +
                "<yRange> -0.1, 1.1 </yRange>\n" +
                "</bg>\n" +
                "\n" +
                "<points>\n" +
                "<pad> true </pad>\n" +
                "<col> red </col>\n" +
                "<wid> 2 </wid>\n" +
                "<radius> 6 </radius>\n" +
                "<list>\n" +
                "0.2, 0.2\n" +
                "0.2, 0.5\n" +
                "0.2, 0.8\n" +
                "0.5, 0.8\n" +
                "0.8, 0.8\n" +
                "0.8, 0.5\n" +
                "0.8, 0.2\n" +
                "0.5, 0.2\n" +
                "</list>\n" +
                "</points>\n" +
                "\n" +
                "<lines>\n" +
                "<col> orange </col>\n" +
                "<wid> 3 </wid>\n" +
                "<list>\n" +
                "0.2, 0.2\n" +
                "0.2, 0.5\n" +
                "0.2, 0.8\n" +
                "0.5, 0.8\n" +
                "0.8, 0.8\n" +
                "0.8, 0.5\n" +
                "0.8, 0.2\n" +
                "0.5, 0.2\n" +
                "0.5, 0.5\n" +
                "</list>\n" +
                "</lines>\n" +
                "\n" +
                "<line>\n" +
                "<col>  </col>\n" +
                "<wid> 1 </wid>\n" +
                "<point> 0.3, 0.3 </point>\n" +
                "<slope> inf </slope>\n" +
                "</line>\n" +
                "\n" +
                "<curve>\n" +
                "<col> 0,0,255 </col>\n" +
                "<wid> 3 </wid>\n" +
                "<range> 0, 1 </range>\n" +
                "<amount> 500 </amount>\n" +
                "<function> Math.pow(x,2)-0.05 </function>\n" +
                "</curve>\n" +
                "\n" +
                "<shape>\n" +
                "<col> 180,180,180 </col>\n" +
                "<wid> 1 </wid>\n" +
                "<type> oval </type>\n" +
                "<!-- type includes oval & rect -->\n" +
                "<pad> true </pad>\n" +
                "<center> 0.6, 0.8 </center>\n" +
                "<width> 0.3 </width>\n" +
                "<height> 0.2 </height>\n" +
                "</shape>\n" +
                "\n" +
                "<shape>\n" +
                "<col> 180,180,180 </col>\n" +
                "<wid> 5 </wid>\n" +
                "<type> rect </type>\n" +
                "<!-- type includes oval & rect -->\n" +
                "<pad> false </pad>\n" +
                "<center> 0.3, 0.4 </center>\n" +
                "<width> 0.3 </width>\n" +
                "<height> 0.2 </height>\n" +
                "</shape>\n" +
                "\n" +
                "<scale>\n" +
                "<col> black </col>\n" +
                "<wid> 1 </wid>\n" +
                "<direction> x </direction>\n" +
                "<pos> 0.0 </pos>\n" +
                "<from> 0 </from>\n" +
                "<step> 0.1 </step>\n" +
                "<amount> 10 </amount>\n" +
                "<precision> 1 </precision>\n" +
                "</scale>\n" +
                "\n" +
                "<scale>\n" +
                "<col> black </col>\n" +
                "<wid> 1 </wid>\n" +
                "<direction> y </direction>\n" +
                "<pos> 0 </pos>\n" +
                "<from> 0 </from>\n" +
                "<step> 0.1 </step>\n" +
                "<amount> 10 </amount>\n" +
                "<precision> 1 </precision>\n" +
                "</scale>\n</Instance>" +
                "\n";
        Instance userTest = (Instance) XMLUtil.convertXmlStrToObject(Instance.class, str);
        System.out.println("a");

        String code= "Math.pow(x,2)-0.05";

        try {
            //run(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
