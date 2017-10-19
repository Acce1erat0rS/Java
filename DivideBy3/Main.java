import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while(num!=0){
			int count = 0;
			int out = num;
			num = 0;
			while(num!=out){
				num = out;
				out = next(num);
				count++;
			}
			System.out.println(count-1);
			count = 0;
			num = sc.nextInt();
		}
	}

	public static int next(int num){
		System.out.println("    "+num);
		int count =0;
		while(num>0){
			int c = num%10;
			System.out.println("    C: "+c);
			count+=c*c*c;
			num/=10;
		}
		System.out.println("    "+count);
		return count;
	}
}

class number{
	int[] num;
	int times;
	number(){
		times = 0;
		num = new int[4];
		for(int i=0;i<4;i++)
			num[i] = 0;
	}

	public number(int init){
		num = new int[4];
		times = 0;
		for(int i = 0;i<4;i++)
			num[i] = 0;
		int count = 0;
		while(init>0){
			num[count] = init%10;
			count++;
			init/=10;
		}
	}

	public int next(){
		int sum = 0;
		for(int i = 0;i<4;i++)
			sum += num[i]*num[i]*num[i];
		return sum;
	}
}
