class matrix{
	int[][] matrix;
	int length,width;
	public matrix(int width,int length){
		this.length = length;
		this.width = width;
		matrix = new int[width][length];
		//for(int i=0;i<width;i++)
		//	matrix[i] = new int[length];
		for(int i=0;i<length;i++)
			for(int j=0;j<width;j++)
				matrix[j][i] = 0;
	}
	public void setOn(int x, int y){
		matrix[x][y] = 1;
	}
	public void setOff(int x,int y){
		matrix[x][y] = 0;
	}
	public void show(){
		String buffer = "";
		for(int i=0;i<width;i++){
			buffer = "";
			for(int j = 0;j<length;j++){
				if(matrix[i][j] == 1)
					buffer+="*";
				else
					buffer+=" ";
			}
		System.out.println(buffer);
		}
	}
	public void Bresenham(int x1,int y1,int x2,int y2){
		int dx = x2-x1;
		int dy = y2-y1;
		int ux = dx>0?1:-1;
		int uy = dy>0?1:-1;
		int x = x1,y=y1,eps;

		eps = 0;
		dx = Math.abs(dx);
		dy = Math.abs(dy);

		if(dx>dy){
			for(x = x1;x!=x2;x+=ux)
			{
				setOn(x,y);
				eps+=dy;
				if((eps<<1)>=dx){
					y+=uy;eps-=dx;
				}
			}
		}
		else{
			for(y=y1;y!=y2;y+=uy){
				setOn(x,y);
				eps+=dx;
				if((eps<<1)>=dy){
					x+=ux;eps-=dy;
				}
			}
		}
	}
}

public class Screen{
	public static void main(String[] args){
		matrix m = new matrix(15,60);
	//	for(int i=0;i<15;i++)
	//		for(int j=0;j<60;j++){
	//			m.setOn(i,j);
	//		}
		m.Bresenham(3,5,12,44);
		m.show();
	}
}
