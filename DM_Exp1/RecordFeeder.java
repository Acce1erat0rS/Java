/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 1:49 PM 2018/4/27
 * @Modified By:
 */
public class RecordFeeder {
    String []tempRecords;
    int iterator=0;
    int viter = 0;
    Tree[] trees;
    String 记录Demo字符串 = "（周一，上午劳作时，行动老人，80）\n" +
            "（周二，上午劳作时，行动老人，90）\n" +
            "（周六，上午劳作时，活力老人，120）\n" +
            "（周日，下午劳作时，活力老人，100）\n" +
            "（周五，晚休闲，地上行动老人，70）\n";
    Record[] vectors;

    public RecordFeeder(){
        tempRecords = 记录Demo字符串.split("\n");
    }

    public void setTrees(Tree[] trees){
        this.trees = trees;
        int count =0;
        vectors = new Record[记录Demo字符串.length()];
        for(String s:记录Demo字符串.split("\n")){
            s = s.replace("（","");
            s = s.replace("）","");
            try{
                vectors[count++] = new Record(s,"，",trees);
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

        if(iterator>=tempRecords.length){
            return null;
        }
        return(tempRecords[iterator++]);
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