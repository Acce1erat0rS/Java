import javax.net.ssl.SNIHostName;
import java.io.*;
import java.util.*;

/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 12:52 PM 2018/5/14
 * @Modified By:
 */
public class OptimizedMain {

    /**
     ---------------------------------------
     ---           Prtformance           ---
     ---------------------------------------

     Record Counts         : 2000000 lines
     Student Counts        : 1036

     RUN 1
     Read File Takes       : 7633ms
     Process Records Takes : 2676ms
     Printing Result Takes : 52ms

     RUN2
     Read File time			        : 7824 ms
     Initialize Var time			: 1 ms
     Process Data time			    : 2335 ms
     Output Result  time			: 48 ms




     Record Counts         : 2000000 lines
     StudentCount          : 1996

     Read File time			        : 7745 ms
     Initialize Var time			: 2 ms
     Process Data time		    	: 9647 ms
     Output Result  time			: 42 ms

     ---------------------------------------
     ---          Threaded Ver           ---
     ---------------------------------------

     8 Thread on i7-5930X with a standard SATA SSD.
     Read File time			        : 7745 ms
     Initialize Var time			: 2 ms
     Process Data time		    	: 2159 ms
     Output Result  time			: 45 ms
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
        double thresh = 0.25;            // 筛选好友的比例门限值
        int [][]friendCounter = null;     // 好友计数器

        boolean serialize = false;         //序列化文件内容
        boolean serialized = false;       //从文件中读取


        long startTime = System.currentTimeMillis();
        long processTime = 0;
        long readTime = 0;

        long[] stuTimes = new long[2000];
        for(long l: stuTimes){
            l=0;
        }

        ArrayList<Map> FriendCount = new ArrayList<>();
        Map map = new HashMap();
        ArrayList<ArrayList<Record>> stuList = new ArrayList<>();
        ArrayList<Record> records = new ArrayList<>();

        int percent = recordNum/100;

        int minimal = recordNum;
        Timer timer = new Timer();
        if(serialized){
            timer.doTime("ReadObjectFromFile");
            stuList = (ArrayList<ArrayList<Record>>)readObjectFromFile("StuList");
            records = (ArrayList<Record>) readObjectFromFile("Records");
        }


        try {
            // read file content from file
            StringBuffer sb = new StringBuffer("");
            FileReader reader = new FileReader("/Users/sp1ca/IdeaProjects/java_git/DM_Exp2/log.txt");
            BufferedReader br = new BufferedReader(reader);

            String str = null;
            int max = 0;
            int count = 0;
            Record rec = null;
            if(!serialized){
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
                stuTimes[kv]++;
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
            }

            if(serialize){
                timer.doTime("Read File");
                writeObjectToFile(stuList,"StuList");
                writeObjectToFile(records,"Records");
            }
            timer.doTime("Write File");

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


            int WorkerCount = 8;
            System.out.println("Creating Workers");
            Worker []workers = new Worker[WorkerCount];
            //TODO: TIME BASED
            int Step = recordNum/WorkerCount;
            for(int i=0;i<WorkerCount;i++){
                workers[i] = new Worker(
                        "Worker "+i,
                        i*Step,
                        (i+1)*Step,Stu_num);
            }
            System.out.println("Init Workers");
            for(int i=0;i<WorkerCount;i++){
                workers[i].start();
            }
            boolean FLAG=false;
            while (!FLAG){
                for(int i=0;i<WorkerCount;i++){
                    if(!workers[i].FIN){
                        Thread.sleep(50);
                        i--;
                    }
                }
                FLAG=true;
            }

            System.out.println("Combining Results");



            for(int k=0;k<WorkerCount;k++){
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
//                if((i!=k)&&(friendCounter[i][k]>80))
////                    System.out.println(friendCounter[i][k]);
            }
            for(int j=0;j<friendCounter[i].length;j++){
                relation[i][j] = (float)friendCounter[i][j]/stuTimes[j];
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



    public static void writeObjectToFile(Object obj,String fileName)
    {
        File file =new File(fileName+".dat");
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream objOut=new ObjectOutputStream(out);
            objOut.writeObject(obj);
            objOut.flush();
            objOut.close();
            System.out.println("write object success!");
        } catch (IOException e) {
            System.out.println("write object failed");
            e.printStackTrace();
        }
    }

    public static Object readObjectFromFile(String fileName)
    {
        Object temp=null;
        File file =new File(fileName+".dat");
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(in);
            temp=objIn.readObject();
            objIn.close();
            System.out.println("read object success!");
        } catch (IOException e) {
            System.out.println("read object failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
