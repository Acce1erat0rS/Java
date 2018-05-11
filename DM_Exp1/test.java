/**
 * @Author: TianyuLiu
 * @Description:
 * @Date: Created at 9:48 PM 2018/5/8
 * @Modified By:
 */
public class test {

    public static void main(String[] args){
        int n = 5;
        int[] arr = {0,0,0,0,0};
//        arr = {0,0,0,0,0};
        int[] remains = {0,1,2,3,4};

        int all = 5*4*3*2*1;





        for(int i=0;i<all;i++){

        }

        F:for(int i=0;i<n;i++){
            if(arr[i] == i){
                getNext(arr[i]);
            }

        }
    }

    static public int getNext(int x){
        if(x==4)
            return 0;
        else
            return x+1;
    }
}
