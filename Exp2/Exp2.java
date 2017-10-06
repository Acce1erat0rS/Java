import java.util.*;
import java.util.Scanner;
import java.util.regex.*;

// 原型模式类，负责输入、调用和输出：
public class Exp2{
	public static void main(String[] args){
			Complex c[] = new Complex[3];
			c[0] = Complex.parseComplex("1+1i");
			c[1] = Complex.parseComplex("2-2i");
			c[2] = Complex.parseComplex("3+30i");
			Polynomial p = new Polynomial('x',c);
			System.out.println(p);
			System.out.println("------");
			p = Polynomial.parsePolynomial("(1+2i)x^0 + (3+4i)x^1 + (5+6i)x^2");
			System.out.println(p);
	}
}

// 复数类：
class Complex implements Cloneable{
	private double real; //实部
	private double imag; //虚部

// 构造方法：
	public Complex(double real, double imag){
		// Add your code here.
		this.real = real;
		this.imag = imag;
	}

// 把本对象转变成一个形如"2 - 3i"的字符串：
	public String toString(){
		// Add your code here.
		if(imag >= 0)
			return this.real + "+"+this.imag + "i";
		else
			return this.real + "-"+(-this.imag) + "i";
	}

// 把一个形如"2 - 3i"的字符串转换成一个Complex类型对象：
	public static Complex parseComplex(String strComplex){
		// Add your code here.
		String real_regex = "\\p{Punct}?\\d";
		String imag_regex = "\\p{Punct}?\\di";
		Pattern real_p = Pattern.compile(real_regex);
		Pattern imag_p = Pattern.compile(imag_regex);
		Matcher m_real = real_p.matcher(strComplex);
		Matcher m_imag = imag_p.matcher(strComplex);
		m_real.find();
		m_imag.find();
		String realString = strComplex.substring(m_real.start(),m_real.end());
		String imagString = strComplex.substring(m_imag.start(),m_imag.end()-1);
		int real = Integer.parseInt(realString);
		int imag = Integer.parseInt(imagString);
		Complex c_buff = new Complex(real,imag);
		return c_buff;
	}

// 显示本对象信息：
	public void display(){
		//Add your code here.
		System.out.println(this);
	}

// 克隆本对象：
	public Complex clone(){
		// Add your code here.
		Complex m_c = new Complex(this.real,this.imag);
		return m_c;
	}

// 判断该复数是不是0：
	public boolean isZero(){
		// Add your code here.
		if((this.real == 0) && (this.imag == 0))
			return true;
		else
			return false;
	}

// 复数相加：
	public Complex add(Complex addend){
		// Add your code here.
		real = this.real + addend.real;
		imag = this.imag + addend.imag;
		Complex m_buff = new Complex(real, imag);
		return m_buff;
	}

// 复数求相反数：
	public Complex negative(){
		// Add your code here.
		real = - this.real;
		imag = - this.imag;
		Complex m_buff = new Complex(real, imag);
		return m_buff;

	}

// 复数相减：
	public Complex subtract(Complex subtrahend){
		// Add your code here.
		real = this.real - subtrahend.real;
		imag = this.imag - subtrahend.imag;
		Complex m_buff = new Complex(real, imag);
		return m_buff;
	}

// 复数相乘：
	public Complex multiply(Complex multiplier){
		// Add your code here.
		real = this.real * multiplier.real - this.imag * multiplier.imag;
		imag = this.imag * multiplier.real + this.real * multiplier.imag;
		Complex m_buff = new Complex(real, imag);
		return m_buff;
	}
}

// 复系数多项式类：
class Polynomial implements Cloneable{
	private char variable; // 变量名称
	private Complex[] coeff = null; // 复系数数组，从0次幂开始不间断。
	
// 空构造方法：
	public Polynomial(){
	}
	
// 构造方法：
	public Polynomial(char variable, Complex[] coeff){
		// Add your code here
		this.variable = variable;
		this.coeff = new Complex[coeff.length];
		for(int i = 0; i<coeff.length; i++)
			this.coeff[i] = coeff[i].clone();
	}

// 把多项式对象转换成形如 (2-3i)x^0 + (-1+2i)x^1 的形式：
	public String toString(){
		// Add your code here.
		String buffer = "";
		for(int i = 0; i<this.coeff.length; i++){
			if(i>0)
				buffer = buffer +  " + ";
			buffer = buffer +"(" + coeff[i].toString() + ")" +  variable + "^" + i;
		}
		return buffer;
	}

// 把形如(2-3i)x^0 + (-1+2i)x^1 的形式的字符串转换成多项式：
	public static Polynomial parsePolynomial(String strPolynomial){
		// Add your code here.
		//先找到variable
		String regex = "\\p{Alpha}\\^";
		Pattern  p = Pattern.compile(regex);
		Matcher m = p.matcher(strPolynomial);
		m.find();
		char variable = strPolynomial.charAt(m.start());
		//判断变量的最高次幂
		int max = 0;
		regex = "\\^\\d+";
		p = Pattern.compile(regex);
		m = p.matcher(strPolynomial);
		while(m.find()){
			int start = m.start()+1;
			int end = m.end();
			String strValue = strPolynomial.substring(start,end);
			int value = Integer.parseInt(strValue);
			if(value>max)
				max = value;
		}
		//parse
		Complex coeff[] = new Complex[max+1];
		regex = "\\(\\d\\p{Punct}?\\di\\)x\\^\\d+";
		p = Pattern.compile(regex);
		m = p.matcher(strPolynomial);
		while(m.find()) {
			int start = m.start()+1;
			int end = m.end();
			String strValue = strPolynomial.substring(start,end);
			String a[] = strValue.split("x\\^");
			int pow = Integer.parseInt(a[1]);
			coeff[pow] = Complex.parseComplex(a[0]);
		}
		Polynomial result = new Polynomial(variable,coeff);
		return result;
	}

// 显示多项式：
	public void display(){
		// Add your code here.
		System.out.println(this.toString());
	}

// 多项式深克隆：
	public Polynomial clone(){
		// Add your code here.

		Complex n_coeff[] = new Complex[this.coeff.length];
		for(int i=0;i<this.coeff.length;i++)
			n_coeff[i] = coeff[i].clone();
		Polynomial poly = new Polynomial(this.variable,n_coeff);
		return poly;

	}

// 多项式浅克隆：
	public Polynomial shallowCopy(){
		// Add your code here.
		Polynomial poly = new Polynomial(this.variable,this.coeff);
		return poly;
	}

// 多项式设置某个参数：
	public void setCoeff(int pos, Complex val){
		// Add your code here.
		this.coeff[pos] = val.clone();
	}
/*
// 多项式整理，把高次幂去掉。
// 例如 (1+2i)x^0 + (0+0i)x^1 + (3.3-7i)x^2 + (0+0i)x^3
// 整理为：(1+2i)x^0 + (0+0i)x^1 + (3.3-7i)x^2
	public Polynomial trim(){
		// Add your code here.
		for()
	}
/*
// 多项式求相反数
	public Polynomial negative(){
		// Add your code here.
	}

// 多项式相加：
	public Polynomial add(Polynomial addend){
		// Add your code here.
	}

// 多项式相减：
	public Polynomial subtract(Polynomial subtract){
		// Add your code here.
	}

// 多项式相乘：
	public Polynomial multiply(Polynomial multiplier){
		// Add your code here.
	}

*/
}
