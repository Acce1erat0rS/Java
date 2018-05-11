///**
// * @Author: TianyuLiu
// * @Description:
// * @Date: Created at 10:40 AM 2018/5/7
// * @Modified By:
// */
//public class Cluster {
//
//    public static void main(String []args){
////        HierarchicalClustering clustering = new HierarchicalClustering();
//
//        Tree []trees = null;
//        String []treeStrings = {
//                "0##-1##日期\n" +
//                        "1##0##工作日\n" +
//                        "2##0##休息日\n" +
//                        "3##1##周一\n" +
//                        "4##1##周二\n" +
//                        "5##1##周三\n" +
//                        "6##1##周四\n" +
//                        "7##1##周五\n" +
//                        "8##2##周六\n" +
//                        "9##2##周日\n"
//                ,
//                "0##-1##时间\n" +
//                        "1##0##休闲时\n" +
//                        "2##0##劳作时\n" +
//                        "3##1##早休闲\n" +
//                        "4##1##午休闲\n" +
//                        "5##1##晚休闲\n" +
//                        "6##2##上午劳作时\n" +
//                        "7##2##下午劳作时\n"
//                ,
//                "0 ## -1 ## 老人类型\n"+
//                        "1 ## 0 ## 活力老人\n"+
//                        "2 ## 0 ## 行动老人\n"+
//                        "3 ## 0 ## 心动老人\n"+
//                        "4 ## 3 ## 地上心动老人\n"+
//                        "5 ## 3 ## 床上心动老人\n"
//        };
//
//        String 记录Demo字符串 = "（周一，上午劳作时，行动老人，80）\n" +
//                "（周二，上午劳作时，行动老人，90）\n" +
//                "（周六，上午劳作时，活力老人，120）\n" +
//                "（周日，下午劳作时，活力老人，100）\n" +
//                "（周五，晚休闲，地上行动老人，70）\n";
//
//        /**
//         * --------------------------------------
//         *               构建特征树
//         * --------------------------------------
//         */
//
//        int featureCount = treeStrings.length;
//        double MainValThreash = 0.3;
//        double SparsityThreash = 0.8;
//
//        try{
//            trees = new Tree[treeStrings.length];
//            int i = 0;
//            for(String treeString:treeStrings){
//                trees[i] = new Tree(treeString,"","");
//                i++;
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//
//        /**
//         * --------------------------------------
//         *              第一次入记录
//         * --------------------------------------
//         */
//
//        //TODO: 这里只是在demo的时候使用，在真正的应用中，正则匹配的速度非常慢，无论是trim还是replace都不应该使用
//
//        int TotalMainVal=0;
//        RecordFeeder rf = new RecordFeeder();
//        String s;
//        while(true){
//            s = rf.getNext();
//            if(s==null||s.equals("")){
//                break;
//            }
//            s = s.replace("（","");
//            s = s.replace("）","");
//            try{
//                Record r = new Record(s,"，",trees);
//                TotalMainVal+=r.MainValue;
//                int count = 0;
//                for(int i:r.fid){
//                    trees[count].addValue(i,r.MainValue);
//                    count++;
//                }
//            }catch (Exception e){
//                System.out.println("记录读取失败\nERRMSG:\n"+e.getMessage());
//            }
//        }
//        System.out.println("特征树构建成功");
//
//        /**
//         * --------------------------------------
//         *              特征树剪枝
//         * --------------------------------------
//         */
//
//        for(Tree t:trees){
//            t.prene(TotalMainVal,MainValThreash);
//        }
//
//        System.out.println("基于MainVal剪枝完成");
//
//        /**
//         * --------------------------------------
//         *           遍历剪枝后特征空间
//         * --------------------------------------
//         */
//        int vector[] = new int[trees.length];
//        for(int i=0;i<trees.length;i++){
//            vector[i] = 0;
//        }
//
////        for(int i=0;i<trees.length;i++){
////            while(true){
////                if(trees[i].getNext())
////            }
////        }
//
//        long searchSpace = 1;
//        int[] NLength = new int[trees.length];
//        for(int i=0;i<trees.length;i++){
//            NLength[i] = trees[i].GetNulledLength();
//            searchSpace*=NLength[i];
//        }
//
//        for(int i=0;i<searchSpace;i++){
//            int temp = i;
//            for(int j=0;j<vector.length;j++){
//                vector[j] = temp%NLength[j];
//                temp/=NLength[j];
//            }
//
//            if(check(vector)){
//                System.out.println("Success in one blah blah blah");
//            }
//        }
//
//
//
//
//
//
//
//
//    }
//
//    public static boolean check(int[] vector){
//
//    }
//}
