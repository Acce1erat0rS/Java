class A{
	String str = "VARIABLE A\n";
	void print(){
		System.out.println("I'm in class A");
	}
}

class B extends A{
	String str = "VARIABLE B\n";
	void print(){
		System.out.println("I'm in class B");
	}
}

public class Extends{
	public static void main(String[] args){
		A a = new A();
		a.print();
		System.out.println(a.str);

		B b = new B();
		b.print();
		System.out.println(b.str);

		A anotherA = b;
		anotherA.print();
		System.out.println(anotherA.str);
	}
}
