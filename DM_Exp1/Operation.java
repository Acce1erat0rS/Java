/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 10:48 AM 2018/5/7
 * @Modified By:
 */
public class Operation {
    Tree []trees;
    float TotalMainVal=0;
    int featureCount;
    double MainValThreash = 0.3;
    double SparsityThreash = 0.8;
    RecordFeeder rf;

    public Operation(String[] treeStrings){
        /**
         * @Author: TianyuLiu
         * @Description:
         * @Date: 10:56 AM 2018/5/7
         * @param treeStrings
         */

        this.featureCount = treeStrings.length;
        this.MainValThreash = 0.3;
        this.SparsityThreash = 0.8;

        try{
            trees = new Tree[featureCount];
            int i = 0;
            for(String treeString:treeStrings){
                trees[i] = new Tree(treeString,"","");
                i++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void InflateTree(){
        /**
         * @Author: TianyuLiu
         * @Description:
         * @Date: 10:56 AM 2018/5/7
         * @param
         */

        //TODO: 这里只是在demo的时候使用，在真正的应用中，正则匹配的速度非常慢，无论是trim还是replace都不应该使用

        TotalMainVal=0;
        RecordFeeder rf = new RecordFeeder();
        String s;
        while(true){
            s = rf.getNext();
            if(s==null||s.equals("")){
                break;
            }
//            s = s.replace("（","");
//            s = s.replace("）","");
            try{
                Record r = new Record(s,", ",trees);
                TotalMainVal+=r.MainValue;
                int count = 0;
                for(int i:r.fid){
                    trees[count].addValue(i,r.MainValue);
                    count++;
                }
            }catch (Exception e){
                System.out.println("记录读取失败\nERRMSG:\n"+e.getMessage());
            }
        }
        System.out.println("特征树构建成功");
    }

    public boolean check(int[] vector){

        /**
         * @Author: TianyuLiu
         * @Description:
         * @Date: 12:49 PM 2018/5/10
         * @param vector
         */

        rf.ResetViter();
        Record a = null;
        double sum = 0;
        int count = 0;
        while(true){
            a = rf.getNextVector();
            if(a==null)
                break;
            double dist = getDistance(vector,a.fid);
            if(dist>0) {
                sum += dist;
                count++;
            }
        }
        sum/=count;

        if(sum<SparsityThreash){
            String s= "";

            for(int i=0;i<featureCount;i++){
                s += trees[i].getName(vector[i])+", ";
            }

            System.out.println(s);
            return true;
        }
        return false;
    }

    public void doCluster(){

        /**
         * @Author: TianyuLiu
         * @Description:
         * @Date: 10:58 AM 2018/5/7
         * @param
         */


        for(Tree t:trees){
            t.prene(TotalMainVal,MainValThreash);
        }

        System.out.println("基于MainVal剪枝完成");

        int vector[] = new int[trees.length];
        for(int i=0;i<trees.length;i++){
            vector[i] = 0;
        }

//        for(int i=0;i<trees.length;i++){
//            while(true){
//                if(trees[i].getNext())
//            }
//        }

        long searchSpace = 1;
        int[] NLength = new int[trees.length];
        for(int i=0;i<trees.length;i++){
            NLength[i] = trees[i].GetNulledLength();
            searchSpace*=NLength[i];
        }

        for(int i=0;i<searchSpace;i++){
            int temp = i;
            for(int j=0;j<vector.length;j++){
                vector[j] = temp%NLength[j];
                temp/=NLength[j];
            }

            if(check(vector)){
                System.out.println("Success in one blah blah blah");
            }
        }
    }

    public double getDistance(int[] vector1, int[] vector2){
        /**
         * @Author: TianyuLiu
         * @Description: If v1 covers v2, returns distance. Else return
         * -1
         * @Date: 2:10 PM 2018/5/8
         * @param vector1
         * @param vector2
         */
        double sum = 0;
        for(int i=0;i<featureCount;i++){
            int res = trees[i].getDistance(vector1[i],vector2[i]);
            if(res < 0){
                return -1;
            }
            sum+=res;
        }
        sum/=featureCount;

       return sum;
    }


    public static void main(String[] args){
        String []treeStrings = {
                "0##-1##日期\n" +
                        "1##0##工作日\n" +
                        "2##0##休息日\n" +
                        "3##1##周一\n" +
                        "4##1##周二\n" +
                        "5##1##周三\n" +
                        "6##1##周四\n" +
                        "7##1##周五\n" +
                        "8##2##周六\n" +
                        "9##2##周日\n"
                ,
                "0##-1##时间\n" +
                        "1##0##休闲时\n" +
                        "2##0##劳作时\n" +
                        "3##1##早休闲\n" +
                        "4##1##午休闲\n" +
                        "5##1##晚休闲\n" +
                        "6##2##上午劳作时\n" +
                        "7##2##下午劳作时\n"
                ,
                "0 ## -1 ## 老人类型\n"+
                        "1 ## 0 ## 活力老人\n"+
                        "2 ## 0 ## 行动老人\n"+
                        "3 ## 0 ## 心动老人\n"+
                        "4 ## 3 ## 地上心动老人\n"+
                        "5 ## 3 ## 床上心动老人\n"
        };

        /**
         * --------------------------------------
         *               构建特征树
         * --------------------------------------
         */

        Operation op = new Operation(treeStrings);

        /**
         * --------------------------------------
         *              第一次入记录
         * --------------------------------------
         */

        op.InflateTree();

        op.rf = new RecordFeeder();
        op.rf.setTrees(op.trees);


        op.doCluster();


    }
}
