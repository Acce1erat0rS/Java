import javax.net.ssl.SNIHostName;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 12:52 PM 2018/5/14
 * @Modified By:
 */
public class OptimizedMain {

    /**
     * Record Counts         : 2000000 lines
     * Read File Takes       : 7633ms
     * Process Records Takes : 2676ms
     * Printing Result Takes : 52ms
     *
     *
     *
     *
     *
     *
     *
     Record Counts         : 2000000 lines
     ---------------------------------------
     ---           Prtformance           ---
     ---------------------------------------

     Read File time			        : 7824 ms
     Initialize Var time			: 1 ms
     Process Data time			    : 2335 ms
     Output Result  time			: 48 ms
     */


    public static void main(String[] args) {

        /**
         * @Author: TianyuLiu
         * @Description:
         * @Date: 3:36 PM 2018/5/15
         * @param args
         */

        int recordNum = 2000000;          // 设置子集的大小
        int MaxCat = 0;                   // 最大食堂数目
        float [][]relation = null;        // 关系比例矩阵
        double thresh = 0.001;              // 筛选好友的比例门限值
        int [][]friendCounter = null;     // 好友计数器


        long startTime = System.currentTimeMillis();
        long processTime = 0;
        long readTime = 0;

        ArrayList<Map> FriendCount = new ArrayList<>();
        Map map = new HashMap();
        ArrayList<ArrayList<Record>> stuList = new ArrayList<>();
        ArrayList<Record> records = new ArrayList<>();

        int percent = recordNum/100;

        int minimal = recordNum;
        Timer timer = new Timer();

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

            timer.doTime("Read File");

            Long eTime = rec.UnixTime;

            br.close();
            reader.close();

            int stuCount = stuList.size();
            Long []UTimes = new Long[stuCount];
            readTime = System.currentTimeMillis();
            relation = new float[stuCount][stuCount];
            friendCounter = new int[stuCount][stuCount];


            Long uTime=0L;


            int Stu_num = stuList.size();
            int[] remains = new int[Stu_num];
            int[] location = new int[Stu_num];
//            for(int i=0;i<Stu_num;i++){
//                FriendCount.add(new HashMap());
//            }

            timer.doTime("Initialize Var");


            int Record_iter = 0;
            Long iter = uTime;

            Worker.map = map;
            Worker.records = records;

            Worker w = new Worker("Only",0,recordNum,Stu_num);
            w.run();

            Worker []workers = new Worker[4];
            //TODO: TIME BASED
            int Step = recordNum/4;
            for(int i=0;i<4;i++){
                workers[i] = new Worker("Worker "+i,i*Step,(i+1)*Step,Stu_num);
            }
            for(int i=0;i<4;i++){
                workers[i].run();
            }

            for(int k=0;k<4;k++){
                for(int i=0;i< Stu_num;i++){
                    for(int j=0;j<Stu_num;j++){
                        friendCounter[i][j]+=workers[k].friendCounter[i][j];
                    }
                }
            }


//            while(Record_iter<recordNum){
//                Record record = records.get(Record_iter++);
//                int m_stu = (int)map.get(record.stu);
//                remains[(int)map.get(record.stu)]=300;
//                location[m_stu] = record.cat;
//                Long delta = record.deltaNext;
//
//
//                for(int i=0;i<Stu_num;i++){
//                    if(remains[i]>0){
//                        if(location[i] == location[m_stu])
//                        {
//                            friendCounter[m_stu][i]++;
//                            friendCounter[i][m_stu]++;
//                        }
//                    }
//                }
//
//                /*
//                * 更新时间表格
//                * */
//                for(int i=0;i<remains.length;i++){
//                    if(remains[i]>0){
//                        remains[i]=(int)(remains[i]-delta);
//                    }
//                }
//                iter+=delta;
//            }

            timer.doTime("Process Data");

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------------\n");
        int Count = 0;
        for(int i=0;i<stuList.size();i++){
            int max = 0;
            for(int k=0;k<friendCounter[i].length;k++){
                max+=friendCounter[i][k];
            }
            for(int j=0;j<friendCounter[i].length;j++){
                relation[i][j] = (float)friendCounter[i][j]/max;
            }
        }




//
//        for(Map m: FriendCount){
//            System.out.print("Student "+(int)(Count++)+" : ");
//            Set keys = m.keySet();
//            for(Object key :keys){
//                System.out.print("key:"+key+"\t "+"value:"+(int)(m.get(key))+"\t");
//            }
//            System.out.print("\n");
//        }
        System.out.println("-------------------------------\n");
        System.out.println("---        Friend List      ---\n");
        System.out.println("-------------------------------\n");

        for(int i=0;i<stuList.size();i++){
            System.out.print("Student "+i+" : ");
            for(int j=0;j<stuList.size();j++){
                if(relation[i][j]>thresh){
                    System.out.print(j+"\t");
                }
            }
            System.out.print("\n");

        }


        timer.doTime("Output Result ");


        System.out.println("Record Counts         : "+recordNum+" lines");
        System.out.println(timer);
    }
}
