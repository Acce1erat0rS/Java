import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PairAdapter extends XmlAdapter<String, MPair>{
    @Override
    public String marshal(MPair pair) throws Exception {
        if(null == pair) {
            return null;
        }
        return pair.toString();
    }

    @Override
    public MPair unmarshal(final String string) throws Exception {
        if(null == string) {
            return null;
        }
        return MPair.getInstance(string);
    }
}
