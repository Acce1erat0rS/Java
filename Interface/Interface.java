interface A{
	// 接口中的方法默认为public abstract
	void eat();
}

interface B{
	void eat();
	void run();
}

interface C extends A,B{
	void stand();
}
class Father{
	public void run(){
		System.out.println("Father running");
	}
}

//1、接口的多继承不产生歧义
//2、因为MyClass不是abstract 的，所以要实现所有接口。
class MyClass extends Father implements A,B,C{
	public void stand(){
		System.out.println("Standing");
	}

	public void eat(){
		System.out.println("eatting");
	}
}	

public class Interface{
	public static void main(String[] args){
		MyClass c = new MyClass();
		c.stand();
		c.run();
		c.eat();
	}
}
