public  class yh{
	public static void main(String[] args){
		int[][] arr = new int[10][];
		for(int i=0;i<10;i++){
			arr[i] = new int[i+1];
		}
		for(int i=0;i<10;i++){
			arr[i][0] = 1;
			arr[i][arr[i].length-1] = 1;
			if(i>1){
				for(int j = 1;j<arr[i].length-1;j++)
					arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
			}
		}
		for(int i=0;i<10;i++){
			for(int n=0 ;n<15-i-1;n++)
				System.out.print("  ");
			for(int j=0;j<arr[i].length;j++)
				System.out.printf("%4d",arr[i][j]);
			System.out.print("\n");
		}
	}

}

