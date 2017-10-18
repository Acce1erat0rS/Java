import java.util.Arrays;

public class SortTwo{
	public static void sort(int[] a1,int[] a2){
		class Pair implements Comparable{
			int v1,v2;
			Pair(int v1,int v2){
				this.v1=v1;
				this.v2=v2;
			}
			public int compareTo(Object obj){
				Pair that = (Pair)obj;
				return(this.v2+this.v1-that.v2-that.v1);
			}
		}			int len=a1.length;
		Pair[] pairs = new Pair[len];
		for(int i=0;i<len;i++)
			pairs[i] = new Pair(a1[i],a2[i]);
		Arrays.sort(pairs);
		for(Pair pair:pairs)
			System.out.println(pair.v1 + " "+pair.v2);
	}
	
	public static void main(String[] args){
		int[] a1 = {2,3,1,2,2};
		int[] a2 = {5,6,5,5,6};
		SortTwo.sort(a1,a2);
	}
}
