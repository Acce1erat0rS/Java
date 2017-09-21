public class Point{
	double x;
	double y;
	public Point(float x,float y){
		this.x = x;
		this.y = y;
	}

	@Override public String toString(){
		return "("+ x +","+y+")";
	}

	public int locate(Point Center){
		if(this.x-Center.x>0){
			if(this.y-Center.y>0)
				return 3;
			else
				return 2;
		}
		else if(this.x-Center.x==0||this.y-Center.y==0)
			return -1;
		else{
			if(this.y-Center.y>0)
				return 1;
			else
				return 0;
		}
	}

	public static void main(String[] args){
		Point p = new Point(3,4);
		Point pivot = new Point(4,3);
		System.out.println("The point is "+p);
		System.out.println("Which is in the "+p.locate(pivot)+"th Quadrant");
	}
}
