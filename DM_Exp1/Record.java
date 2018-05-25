import com.sun.org.apache.regexp.internal.RE;

import java.security.interfaces.RSAKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 12:34 PM 2018/4/27
 * @Modified By:
 */

public class Record {
    int []fid;
    float MainValue;

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
//        if(fields.length!=trees.length+1){
//            throw new Exception(
//                    "特征数目与特征树数目不符," +
//                    "特征数为"+fields.length+
//                    "特征树数目为"+trees.length+"。"
//            );
//        }

        LocalDateTime dt = LocalDateTime.parse(fields[0],
                DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss"));
        //2015-01-01T06:03:54
        int dof = dt.getDayOfWeek().getValue();
        int hourOfDay = dt.getHour();
        int age = Integer.parseInt(fields[1]);

        fid = new int[trees.length];

//        for(int i=0;i<trees.length-1;i++){
//            fid[i] = trees[i].FindNoByName(fields[i]);
//        }

        //dof
        fid[0] = trees[0].FindNoByName(dofParse(dof));
        //hod
        fid[1] = trees[1].FindNoByName(hodParse(hourOfDay));
        //age
        fid[2] = trees[2].FindNoByName(ageParse(age));

        MainValue = Float.parseFloat(fields[fields.length-1].trim());
    }

    public String dofParse(int dof){
        switch (dof){
            case (2):
                return"周一";
            case (3):
                return"周二";
            case (4):
                return"周三";
            case (5):
                return"周四";
            case (6):
                return"周五";
            case (7):
                return"周六";
            case (1):
                return"周天";
        }
        return null;
    }

    private String hodParse(int hod){
        if (hod>=0&&hod<8){
            return"早休闲";
        }
        if(hod<12)
            return "上午劳作时";
        if(hod<13)
            return "午休闲";
        if(hod<17)
            return"下午劳作时";
        return "晚休闲";
    }

    private String ageParse(int age){
        if(age<=69)
            return "活力老人";
        if(age<=79)
            return "行动老人";
        if(age<=89)
            return "地上心动老人";
        if(age<=99)
            return "床上心动老人";
        return "";
    }

}
