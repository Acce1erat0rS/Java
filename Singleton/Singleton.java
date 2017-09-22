public class Singleton{
	int value;
	private Singleton sgt = new Singleton();
	private Singleton(int value){
		this.value = value;
	}
	public static Singleton getSingleton(){
		return sgt;
	}
	public static void main(String[] args){
		Singleton sgt = Singleton.getSingleton();
	}
}
