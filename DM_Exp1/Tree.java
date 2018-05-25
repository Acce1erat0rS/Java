/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 12:32 PM 2018/4/27
 * @Modified By:
 */


import java.util.ArrayList;

public class Tree {
    public ArrayList<Node> node = new ArrayList<>();
    private boolean childInUse = false;
    private int iter;
    private int nulledIter;

    private class Node{
        int number;
        int father;
        String name;
        float CombinedValue;
        boolean nulled;

        private Node(String s,String delimiter)throws Exception{
            CombinedValue = 0;
            try{
                String ss[] = s.split(delimiter);

                number = Integer.parseInt(ss[0].trim());
                father = Integer.parseInt(ss[1].trim());
                name = ss[2].trim();
                nulled = false;
                iter = 0;
                nulledIter = 0;
            }
            catch (Exception e){
                throw new Exception("构建节点时文件格式有误");
            }
        }

        private Node(){
            number = -1;
            father = -2;
            name = "";
        }
    }

    public Tree(String s,String TreeDelimiter,String NodeDelimiter) throws Exception{
        /**
         * @Author: TianyuLiu
         * @Description:
         * @Date: 12:30 PM 2018/4/27
         * @param s
         * @param TreeDelimiter
         * @param NodeDelimiter
         */
        if(TreeDelimiter == null || TreeDelimiter.equals("")){
            TreeDelimiter = "\n";
        }
        if(NodeDelimiter == null || NodeDelimiter.equals("")){
            NodeDelimiter = "##";
        }
        String []nodes = s.split(TreeDelimiter);
        for(int i = 0;i<nodes.length;i++){
            try{
                Node n = new Node(nodes[i],NodeDelimiter);
                node.add(n);
            }catch (Exception e){
                throw e;
            }
        }

    }

    public int FindNoByName(String name){
        /**
         * @Author: TianyuLiu
         * @Description: Get name and return the corresponding node number,
         * returns -1 if does not exist; This function will automatically re-
         * move spaces at the end of the string.
         * @Date: 12:38 PM 2018/4/27
         * @param name
         */
//        Node n = new Node();
        for(Node n:node){
           if(name.trim().equals(n.name)){
               return n.number;
           }
        }
        return -1;
    }

    public int getDistance(int father, int child){
        /**
         * @Author: TianyuLiu
         * @Description: This function will return the distance between father and
         * child. If there is no father-child relationship, this function will generate
         * an error(or return -1)到底怎么样才是更好的做法。
         * @Date: 2:45 PM 2018/5/3
         * @param father
         * @param child
         */

        int count = 0;
        int cur = child;
        while(cur!=father){
            int result = findFather(cur);
            if(result == -1){
                return -1;
            }
            count++;
            cur = result;
        }
        return count;
    }

    public int findChild(int parentId){
        /**
         * @Author: TianyuLiu
         * @Description: 判断是否实现了child节点功能，分别不同处理。接受一个节点，返回其子节点。
         * @Date: 2:48 PM 2018/5/3
         * @param parentId
         */
        if(childInUse){
//            TODO: 加入child field 加速查表。在构建树的时候加入
            return -1;
        }
        else{
            for(Node n:node){
                if(n.father == parentId){
                    return n.number;
                }
            }
            return -1;
        }
    }

    public int findFather(int childId){
        /**
         * @Author: TianyuLiu
         * @Description:
         * @Date: 2:43 PM 2018/5/8
         * @param childId
         */
        if (childId < 0) {
            System.out.println("ERRRRRRRRRRRRRR");
            return -1;
        }
        return node.get(childId).father;
    }

    public void addValue(int nodeID,float MainVal){
        int cur = nodeID;
        while(cur != -1){
            //TODO:是不是应该验证一下树结构的编号是不是正常的编号
            node.get(cur).CombinedValue+=MainVal;
            cur = node.get(cur).father;
        }
    }

    public int getNext(){
        /**
         * @Author: TianyuLiu
         * @Description: get next item
         * @Date: 5:29 PM 2018/5/4
         * @param
         */
        if(iter<node.size()){
            return node.get(iter++).number;

        }
        else return -1;
    }

    public int getNotNulledNext(){
        /**
         * @Author: TianyuLiu
         * @Description: get next item
         * @Date: 5:29 PM 2018/5/4
         * @param
         */
        while(nulledIter<node.size()){
            if(node.get(nulledIter).nulled){
                nulledIter++;
                continue;
            }
            return node.get(nulledIter++).number;

        }
        return -1;
    }

    public void setNull(int index){
        node.get(index).nulled = true;
    }

    public void reset(){
        /**
         * @Author: TianyuLiu
         * @Description: Reset the iterator
         * @Date: 5:29 PM 2018/5/4
         * @param
         */
        iter = 0;
    }

    public void prene(float TotalMainVal, double threshold){

        /**
         * @Author: TianyuLiu
         * @Description: Prene the search tree with the mainVal
         * Support value ratio.
         * @Date: 10:21 AM 2018/5/7
         * @param TotalMainVal
         * @param threshold
         */

        while(true){
            int item = this.getNext();
            if(item==-1){
                break;
            }
            float x = node.get(item).CombinedValue;
            x = x/TotalMainVal;
            if(x<threshold){
                setNull(item);
            }

        }
        this.reset();

    }

    public int GetNulledLength(){

        /**
         * @Author: TianyuLiu
         * @Description: Get the lenth of avaliable nodes.
         * @Date: 10:24 AM 2018/5/7
         * @param
         */


        int temp = nulledIter;
        nulledIter = 0;
        int count = 0;
        while(this.getNotNulledNext() !=-1){
            count++;
        }
        nulledIter = temp;
        return count;
    }

    public String getName(int index) {
        return node.get(index).name;
    }
    public static void main(String []args){

    }
}
