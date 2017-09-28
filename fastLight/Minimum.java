public class Minimum {
	public static int numRow;
	public static int numCol;
	public static void main(String[] args){
		Minimum.numCol = Integer.parseInt(args[0]);
		Minimum.numRow = Integer.parseInt(args[1]);
		long status = ~0L;
		long bitStatus = 0L;
		Command[] cmd = new Command[10];
		// Input all the command
		for(int commandID = 0;commandID < args.length-2;commandID++)
			cmd[commandID] = new Command(args[commandID+2]);
		// Because all we care is the singularity of every column, Therefor "F" dosen't matter
		for(int i = 0; i < Minimum.numRow; i++)
			for(int j = 0; j < args.length - 2; j++){
				bitStatus = bitStatus^(1<<cmd[j].previous);
				int base = cmd[j].previous;
				for(int count=0;count<cmd[j].P;count++)
					base *= cmd[j].P;
				int T = cmd[j].C*base+cmd[j].S;
				//int T = (int)(cmd[j].C * Math.pow(cmd[j].previous,cmd[j].P)+cmd[j].S); 
				cmd[j].previous =T %  Minimum.numCol;
			}
		int count = 0;
		for(int j = 0; j<64; j++)
			count += (bitStatus>>j)&1;
		System.out.println(count);
	}
}

class Command{
	int F,I,C,P,S;
	int previous;
	public Command(String in){
		this.F = cut(in,'F');
		this.I = cut(in,'I');
		this.C = cut(in,'C');
		this.P = cut(in,'P');
		this.S = cut(in,'S');
		this.previous = this.I;
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
