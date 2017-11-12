import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class ListAdapter extends XmlAdapter<String, List<MPair>> {
    @Override
    public String marshal(List<MPair> pairs) throws Exception {
        if(null == pairs) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for(MPair mp:pairs)
            sb.append(sb.toString()+"\n");
        return sb.toString();
    }

    @Override
    public List<MPair> unmarshal(final String string) throws Exception {
        if(null == string) {
            return null;
        }
        List<MPair> lmp = new ArrayList<>();
        String str = string.replaceAll("\\s","");
        String[] ss = str.split("\n");
        for(String s:ss){
            lmp.add(MPair.getInstance(s));
        }
        return lmp;
    }
}
