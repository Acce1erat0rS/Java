public class demo {
	public static int numRow;
	public static int numCol;
	public static void main(String[] args){
		demo.numCol = Integer.parseInt(args[0]);
		demo.numRow = Integer.parseInt(args[1]);
		long[] arr= new long[demo.numRow];
		for(int i=0; i<demo.numRow;i++)
			arr[i] = ~0L;
		Command[] cmd = new Command[10];
		for(int commandID = 0;commandID < args.length-2;commandID++){
			cmd[commandID] = new Command(args[commandID+2]);
			int prev = cmd[commandID].I;
			if(cmd[commandID].F == 0){
				for(int i=0;i<demo.numRow;i++){
					arr[i] = turn(arr[i],prev);
					prev = next(prev, cmd[commandID]);
				}
			}
			else{
				for(int i=demo.numRow-1;i>=0;i--){
					arr[i] = turn(arr[i], prev);
					prev = next(prev,cmd[commandID]);
				}
			}
		}
		System.out.println(determine(arr));
	}

	public static int next(int prev, Command cmd){
		return (int)(cmd.C*Math.pow(prev,cmd.P)+cmd.S)%demo.numCol;
	}
	public static long turn(long bit, int n){
		long a = 1;
		return bit^(a<<n);
	}

	public static int determine(long bit[]){
		int mk = 1;
		int result = 0;
		int n = 0;
		for(int j = 0;j<64;j++){
			result = 0;
			for(int i=0;i<demo.numRow;i++){
				if(((bit[i]>>j)&1)==1)
					if(result == 0)
						result = 1;
					else
						result = 0;
			}
			n += result;
		}
	return n;
	}
}

class Command{
	int F,I,C,P,S;
	public Command(String in){
		this.F = cut(in,'F');
		this.I = cut(in,'I');
		this.C = cut(in,'C');
		this.P = cut(in,'P');
		this.S = cut(in,'S');
	}
	
	public int cut(String in, char id){
		int start,end;
		for(start = 0; start<in.length(); start++)
			if(in.charAt(start) == id)
				break;
		for(end=start+1; end<in.length(); end++)
			if(!Character.isDigit(in.charAt(end)))
				break;
		start++;
		return Integer.valueOf(in.substring(start,end));
	}

}
