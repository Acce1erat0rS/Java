public class Singleton{
	int value;
	private static Singleton sgt = new Singleton();
	private Singleton(){}
	public static Singleton getSingleton(){
		return sgt;
	}
	public static void main(String[] args){
		
		Singleton sgt = Singleton.getSingleton();
		Singleton sgt2 = Singleton.getSingleton();
		sgt.value = 20;
		sgt2.value = 200;
		System.out.println(sgt.value+"+"+ sgt2.value);
	}
}
