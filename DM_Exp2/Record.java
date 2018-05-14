import com.sun.org.apache.regexp.internal.RE;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 8:38 AM 2018/5/11
 * @Modified By:
 */
public class Record {
    Date time;
    Long UnixTime;
    int cat;
    int atm;
    String stu;
    Long deltaNext;

    public Record(String s){
        String pattern = "yyyy-MM-dd_hh:mm:ss";
        String []ss = s.split(",");
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
//        time =  sdf.parse(ss[0],dateTimeFormatter);
        try{
            time = sdf.parse(ss[0]);
            UnixTime = sdf.parse(ss[0]).getTime() / 1000;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        stu = ss[1];

        cat = Integer.parseInt(ss[2]);
        cat = Integer.parseInt(ss[3]);



    }

    public static void main(String [] args){
        String r = "2017-01-01_12:06:15,420,0,0";
        Record rec = new Record(r);
        System.out.println(rec);
    }
}
