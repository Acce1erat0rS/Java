import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 11:24 AM 2018/5/25
 * @Modified By:
 */
public class Worker implements Runnable{
    private Thread t;
    private String threadName;
    private int start;
    private int end;
    static ArrayList<Record> records;
    static Map map;
    private int[] remains;
    private int Stu_num;
    private int[] location;
    public int [][]friendCounter;
    boolean FIN = false;

    Worker( String name, int start,int end,int Stu_num) {
        threadName = name;
        System.out.println("Creating " +  threadName );
        this.start = start;
        this.end = end;
        remains = new int[Stu_num];
        this.Stu_num = Stu_num;
        location = new int[Stu_num];
    }

    public void run() {
        friendCounter = new int[Stu_num][Stu_num];
        int Record_iter = start;
        while(Record_iter<end){
            Record record = records.get(Record_iter++);
            int m_stu = (int)map.get(record.stu);
            remains[(int)map.get(record.stu)]=300;
            location[m_stu] = record.cat;
            Long delta = record.deltaNext;


            for(int i=0;i<Stu_num;i++){
                if(remains[i]>0){
            //        if(location[i] == location[m_stu])
                    {
                        friendCounter[m_stu][i]++;
                        friendCounter[i][m_stu]++;
                    }
                }
            }

                /*
                * 更新时间表格
                * */
            for(int i=0;i<remains.length;i++){
                if(remains[i]>0){
                    remains[i]=(int)(remains[i]-delta);
                }
            }
        }
        this.FIN = true;
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

