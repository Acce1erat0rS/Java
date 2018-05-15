import java.sql.Time;
import java.util.ArrayList;

/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 4:01 PM 2018/5/15
 * @Modified By:
 */
public class Timer {
    ArrayList<Long> millTime = null;
    ArrayList<String> records = null;

    public Timer(){
        millTime = new ArrayList<>();
        records = new ArrayList<>();
        millTime.add(System.currentTimeMillis());
        records.add("StartTime");
    }

    @Override
    public String toString(){
        String s="";
        s+="--------------------------------\n";
        s+="---        Prtformance       ---\n";
        s+="--------------------------------\n\n";
        for(int i=1;i<millTime.size();i++){
            long time = millTime.get(i)-millTime.get(i-1);
            s+=records.get(i)+" time\t\t: "+ time +"\n";
        }

        return s;

    }

    public void doTime(String record){
        millTime.add(System.currentTimeMillis());
        records.add(record);
    }



}
