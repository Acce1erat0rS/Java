public class PointN{
	double [] coords;
	public PointN(double ... coords){
		this.coords = coords;
	}

	@Override public String toString(){
		return "";
	}

	public int locate(PointN Center){
		int quads = 0;
		for(int i=0;i<coords.length;i++){
			if(Center.coords[i]<this.coords[i])
				quads = (quads<<1)|1;
			else if(Center.coords[i] > this.coords[i])
				quads = quads<<1;
			else
				return -1;
		}
		return quads;
	}


	public static void main(String[] args){
		PointN p = new PointN(3,4,5,6,7,8);
		PointN pivot = new PointN(1,2,3,4,5,6);
		System.out.println("The point is "+p);
		System.out.println("Which is in the "+p.locate(pivot)+"th Quadrant");
	}
}
