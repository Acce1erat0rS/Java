/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 1:08 PM 2018/5/29
 * @Modified By:
 */

import java.util.ArrayList;

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
        s+="-------------------------------------------\n";
        s+="---             Prtformance             ---\n";
        s+="-------------------------------------------\n\n";
        for(int i=1;i<millTime.size();i++){
            long time = millTime.get(i)-millTime.get(i-1);
            String ss = String.format("%-20s",records.get(i));
            s+=ss+" time\t\t: "+ time +"\tms \n";
        }

        return s;

    }

    public void doTime(String record){
        millTime.add(System.currentTimeMillis());
        records.add(record);
    }



}
