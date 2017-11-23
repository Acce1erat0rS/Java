import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;

public class ListAdapter extends XmlAdapter<String, ArrayList<MPair>> {
    @Override
    public String marshal(ArrayList<MPair> pairs) throws Exception {
        if(null == pairs) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for(MPair mp:pairs)
            sb.append(sb.toString()+"\n");
        return sb.toString();
    }

    @Override
    public ArrayList<MPair> unmarshal(final String string) throws Exception {
        if(null == string) {
            return null;
        }
        ArrayList<MPair> lmp = new ArrayList<>();
        String[] ss = string.split("\\r?\\n");;
        for(int i = 0;i<ss.length;i++){
            ss[i] = ss[i].replaceAll("\\s","");
            if(ss[i].equals(""))
                continue;
            lmp.add(MPair.getInstance(ss[i]));
        }
        return lmp;
    }
}
