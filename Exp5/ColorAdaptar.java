import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.awt.*;
import java.lang.reflect.Field;

class ColorAdapter extends XmlAdapter<String, Color> {
    public Color unmarshal(String s) {
        //Default
        s = s.replaceAll("\\s","");
        Color color = new Color(0,0,0);
        try {
            Field field = Class.forName("java.awt.Color").getField(s);
            color = (Color)field.get(null);
        } catch (Exception e) {
            try{
                String[] sl = s.split(",");
                color = new Color(Integer.parseInt(sl[0]),
                        Integer.parseInt(sl[1]),
                        Integer.parseInt(sl[2]));
            }catch(Exception e2){}
        }
        return color;
    }

    public String marshal(Color color) {
        String rgb = Integer.toHexString(color.getRGB());
        return "#" + rgb.substring(2, rgb.length());
    }
}
