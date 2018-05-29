import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 5:00 PM 2018/5/27
 * @Modified By:
 */

public class FileRecordFeeder {
//    String []tempRecords;
    int iterator=0;
    int viter = 0;
    Tree[] trees;
    public Record[] vectors;
    ArrayList<String> raw_data = new ArrayList<>();

    FileReader reader;
    BufferedReader br;

    public FileRecordFeeder(String fileDir){
        try {
            reader = new FileReader(fileDir);
            br = new BufferedReader(reader);

            String s;
            while((s = br.readLine())!=null){
//                System.out.println(s);
                raw_data.add(s);
            }

            br.close();
            reader.close();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void setTrees(Tree[] trees){
        this.trees = trees;
        int count =0;
        vectors = new Record[raw_data.size()];
        for(String s:raw_data){
//            s = s.replace("（","");
//            s = s.replace("）","");
            try{
                vectors[count++] = new Record(s,", ",trees);
            }catch (Exception e){
                e.printStackTrace();
                System.err.println("生成记录失败");
            }

        }
    }

    public Record getNextVector(){
        /**
         * @Author: TianyuLiu
         * @Description:
         * @Date: 2:05 PM 2018/5/8
         * @param
         */

        if(viter>=vectors.length){
            return null;
        }
        return(vectors[viter++]);
    }

    public String getNext(){
        /**
         * @Author: TianyuLiu
         * @Description:
         * @Date: 3:11 PM 2018/4/27
         * @param
         */

        if(iterator>=raw_data.size()){
            return null;
        }
        return(raw_data.get(iterator++));
    }

    public void ResetIterator(){
        /**
         * @Author: TianyuLiu
         * @Description:
         * @Date: 2:05 PM 2018/5/8
         * @param
         */

        iterator = 0;
    }

    public void ResetViter(){
        /**
         * @Author: TianyuLiu
         * @Description:
         * @Date: 2:06 PM 2018/5/8
         * @param
         */

        viter =0;
    }
}

