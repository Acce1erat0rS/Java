import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 8:52 AM 2018/5/11
 * @Modified By:
 */
public class main {
    public static void main(String[] args) {
        ArrayList<Map> FriendCount = new ArrayList<>();
        Map map = new HashMap();
        ArrayList<ArrayList<Record>> stuList = new ArrayList<>();
        ArrayList<Record> records = new ArrayList<>();
        try {
            // read file content from file
            StringBuffer sb = new StringBuffer("");


            FileReader reader = new FileReader("/Users/sp1ca/IdeaProjects/java_git/DM_Exp2/log.txt");
            BufferedReader br = new BufferedReader(reader);

            String str = null;
            int max = 0;
            int count = 0;
            Record rec = null;

            int minimal = 5000;

            while ((str = br.readLine()) != null) {
                if(minimal--<0)
                    break;
                String[] ss = str.split(",");
                String no = ss[1];
                if (!map.containsKey(no)) {
                    ArrayList<Record> rl = new ArrayList<>();
                    stuList.add(rl);

                    map.put(no, max++);
                }

                int kv = (int)map.get(no);
                Record prev = rec;
                rec = new Record(str);
                if(prev!=null){
                    prev.deltaNext = rec.UnixTime-prev.UnixTime;
                }
                stuList.get(kv).add(rec);
                if((count++)%100==0){
                    System.out.println(count);
                }
                records.add(rec);
            }

            Long eTime = rec.UnixTime;

            br.close();
            reader.close();

            int stuCount = stuList.size();
            Date []date = new Date[stuCount];
            Long []UTimes = new Long[stuCount];

            String pattern = "yyyy-MM-dd_hh:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Date StartDate = sdf.parse("2017-01-01_07:00:00");
            Long uTime=0L;
//            eTime=0L;

            try{
                uTime = sdf.parse("2017-01-01_07:00:00").getTime()/1000;
//                eTime = sdf.parse("2017-12-31_17:59:56").getTime()/1000;

            }
            catch (Exception e){
                e.printStackTrace();
            }


            for(Long l:UTimes){
                l = uTime;
            }

            int Stu_num = stuList.size();
            int[] remains = new int[Stu_num];
            int[] location = new int[Stu_num];
            for(int i=0;i<Stu_num;i++){
                FriendCount.add(new HashMap());
            }

            int Record_iter = 0;
            Long iter = uTime;
            while(iter<eTime){
                System.out.println("iter/etime"+iter+"/"+eTime);
                Record record = records.get(Record_iter++);
                int m_stu = (int)map.get(record.stu);
                remains[(int)map.get(record.stu)]=300;
                location[m_stu] = record.cat;
                Long delta = record.deltaNext;

                for(int i=0;i<Stu_num;i++){
                    if(remains[i]>0){
                        if(location[i]==location[m_stu])
                        {
                            if(FriendCount.get(m_stu).containsKey(i)){
                                FriendCount.get(m_stu).replace(i,(int)FriendCount.get(i).get(i)+1);
                            }
                            else{
                                FriendCount.get(m_stu).put(i,1);
                            }
                        }
                    }
                }

//                Let Time PASS~~~~~~~~

                for(int i=0;i<remains.length;i++){
                    if(remains[i]>0)
                        remains[i]-=delta;
                }
                iter+=delta;
//                Record record =
//                iter+=


            }






        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("xx");
    }
}

