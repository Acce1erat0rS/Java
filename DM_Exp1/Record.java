import com.sun.org.apache.regexp.internal.RE;

import java.security.interfaces.RSAKey;

/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 12:34 PM 2018/4/27
 * @Modified By:
 */

public class Record {
    int []fid;
    int MainValue;

    public Record(String RecordString,String delimiter,Tree []trees)throws Exception{

        /**
         * @Author: TianyuLiu
         * @Description:
         * @Date: 12:48 PM 2018/4/27
         * @param RecordString
         * @param delimiter
         * @param trees
         */

        String []fields = RecordString.split(delimiter);
        if(fields.length!=trees.length+1){
            throw new Exception(
                    "特征数目与特征树数目不符," +
                    "特征数为"+fields.length+
                    "特征树数目为"+trees.length+"。"
            );
        }

        fid = new int[fields.length-1];

        for(int i=0;i<fields.length-1;i++){
            fid[i] = trees[i].FindNoByName(fields[i]);
        }
        MainValue = Integer.parseInt(fields[fields.length-1].trim());
    }

}
