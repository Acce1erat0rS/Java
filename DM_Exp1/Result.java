import org.jetbrains.annotations.NotNull;

/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 3:42 PM 2018/5/28
 * @Modified By:
 */
public class Result implements Comparable<Result>{
    @Override
    public int compareTo(@NotNull Result o) {

        if(this.Sparsity > o.Sparsity){
            return 1;
        }
        else return 0;
    }

    int[] resNodes;
    String[] resStrings;
    double Sparsity;
    double MainValue;

    @Override
    public String toString(){
        String s = "";
        for(String ss : resStrings){
            s=s+ss+" ";
        }
        return ""+s+"Sparsity:"+ Sparsity+" Total MainValue: "+ MainValue;
    }

}
