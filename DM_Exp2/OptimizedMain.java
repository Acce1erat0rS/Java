import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 12:52 PM 2018/5/14
 * @Modified By:
 */
public class OptimizedMain {


    public static void main(String[] args) {
        int recordNum = 2000000; //设置子集的大小
        int MaxCat = 0;          //最大食堂数目
        float [][]relation = null;

        long startTime = System.currentTimeMillis();
        long processTime = 0;
        long readTime = 0;

        ArrayList<Map> FriendCount = new ArrayList<>();
        Map map = new HashMap();
        ArrayList<ArrayList<Record>> stuList = new ArrayList<>();
        ArrayList<Record> records = new ArrayList<>();

        int percent = recordNum/100;

        int minimal = recordNum;
        try {
            // read file content from file
            StringBuffer sb = new StringBuffer("");


            FileReader reader = new FileReader("log.txt");
            BufferedReader br = new BufferedReader(reader);

            String str = null;
            int max = 0;
            int count = 0;
            Record rec = null;

            while ((str = br.readLine()) != null) {
                if(minimal--<0)
                    break;
                String[] ss = str.split(",");
                String no = ss[1];

                //构建学生与内部编号的关系
                if (!map.containsKey(no)) {
                    //若map不包括这个学生
                    ArrayList<Record> rl = new ArrayList<>();
                    stuList.add(rl);
                    map.put(no, max++);
                }

                // 写入下一个什么时候进来
                int kv = (int)map.get(no);
                Record prev = rec;
                rec = new Record(str);
                if(prev!=null){
                    prev.deltaNext = rec.UnixTime-prev.UnixTime;
                }
                stuList.get(kv).add(rec);
                if((count++)%percent==0){
                    System.out.println(count);
                }
                if(rec.cat>=MaxCat){
                    MaxCat=rec.cat;
                }
                records.add(rec);
            }

            Long eTime = rec.UnixTime;

            br.close();
            reader.close();

            int stuCount = stuList.size();
//            Date[]date = new Date[stuCount];
            Long []UTimes = new Long[stuCount];

            readTime = System.currentTimeMillis();


            relation = new float[stuCount][stuCount];

//            String pattern = "yyyy-MM-dd_hh:mm:ss";
//            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//            Date StartDate = sdf.parse("2017-01-01_07:00:00");
            Long uTime=0L;
//            eTime=0L;

//            try{
//                uTime = sdf.parse("2017-01-01_07:00:00").getTime()/1000;
////                eTime = sdf.parse("2017-12-31_17:59:56").getTime()/1000;
//
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }


//            for(Long l:UTimes){
//                l = uTime;
//            }

            int Stu_num = stuList.size();
            int[] remains = new int[Stu_num];
            int[] location = new int[Stu_num];
            for(int i=0;i<Stu_num;i++){
                FriendCount.add(new HashMap());
            }

            int Record_iter = 0;
            Long iter = uTime;
            while(Record_iter<recordNum){
//                System.out.println("iter/etime"+iter+"/"+eTime);
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
                    if(remains[i]>0){
//                        System.out.println(Record_iter);
                        remains[i]=(int)(remains[i]-delta);
                    }
                }
                iter+=delta;
//                Record record =
//                iter+=


            }







        } catch (Exception e) {
            e.printStackTrace();
        }
        processTime = System.currentTimeMillis();

        System.out.println("-------------------------------\n");
        int Count = 0;
        for(int i=0;i<stuList.size();i++){
            int max = (int)FriendCount.get(i).get(i);
            Set keys = FriendCount.get(i).keySet();
            for(Object key :keys){

                int x = (int)FriendCount.get(i).get(key);
                relation[i][(int)key] = (float)x/(float)max;
            }
        }
        for(Map m: FriendCount){
            System.out.print("Student "+(int)(Count++)+" : ");
            Set keys = m.keySet();
            for(Object key :keys){
                System.out.print("key:"+key+"\t "+"value:"+(int)(m.get(key))+"\t");
            }
            System.out.print("\n");
        }
        double threash = 0.5;

        System.out.println("-------------------------------\n");
        System.out.println("---        Friend List      ---\n");
        System.out.println("-------------------------------\n");

        for(int i=0;i<stuList.size();i++){
            System.out.print("Student "+i+" : ");
            for(int j=0;j<stuList.size();j++){
                if(relation[i][j]>threash){
                    System.out.print(j+"\t");
                }
            }
            System.out.print("\n");

        }

        long printTime = System.currentTimeMillis();


        System.out.println("Record Counts         : "+recordNum+" lines");
        System.out.println("Read File Takes       : "+(readTime-startTime)+"ms");
        System.out.println("Process Records Takes : "+(processTime-readTime)+"ms");
        System.out.println("Printing Result Takes : "+(printTime-processTime)+"ms");


    }
}
