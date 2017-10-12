import java.util.Scanner;
import java.util.regex.*;

// 原型模式类，负责输入、调用和输出：
public class Exp2{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("请输入两个复系数多项式的加法、减法和乘法。输入finish结束：");
			String line = scanner.nextLine();
			if(line.equals("finish")){
				System.out.println("GoodBye");
				return;
			}
			String regex = "\\[.*?\\]";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(line);
			int s1,s2,e1,e2;

			m.find();
			s1 = m.start()+1;
			e1 = m.end()-1;

			m.find();
			s2 = m.start()+1;
			e2 = m.end()-1;


			String strOper = line.substring(s1,e1);
			Polynomial oper = Polynomial.parsePolynomial(strOper);
			String strOped = line.substring(s2,e2);
			Polynomial oped = Polynomial.parsePolynomial(strOped);
			String op = line.substring(e1+1,s2-1).trim();
			System.out.println("两个多项式的运算结果为：");
			System.out.println(eval(oper,oped,op));
		}
//		[ (1+2i)x^0 + (1+2i)x^1 ] + [ (1+2i)x^0 + (1+2i)x^1 ]
//		[ (1+2i)x^0 + (1+2i)x^1 ] - [ (1+2i)x^0 + (1+2i)x^1 ]
//		[ (1+2i)x^0 + (1+2i)x^1 ] * [ (1+2i)x^0 + (1+2i)x^1 ]
	}

	public static Polynomial eval(Polynomial a,Polynomial b,String op){
		switch (op){
			default:
				System.out.println("Further feature not available.");
				return null;
			case "+":
				return a.add(b);
			case "-":
				return a.subtract(b);
			case "*":
				return a.multiply(b);
		}
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
		double m_real = this.real * multiplier.real - this.imag * multiplier.imag;
		double m_imag = this.imag * multiplier.real + this.real * multiplier.imag;
		Complex m_buff = new Complex(m_real, m_imag);
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
	public String toString() {
		// Add your code here.
		String buffer = "";
		int flag = 0;
		for(int i = 0; i<this.coeff.length; i++){
			if(!coeff[i].isZero())
			{
				if(flag>0)
					buffer = buffer +  " + ";
			buffer = buffer +"(" + coeff[i].toString() + ")" +  variable + "^" + i;
			flag++;
			}
		}
		if(buffer == "")
			buffer = "0";
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
		for(int i = 0;i<coeff.length;i++)
			coeff[i] = new Complex(0,0);
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

// 多项式整理，把高次幂去掉。
// 例如 (1+2i)x^0 + (0+0i)x^1 + (3.3-7i)x^2 + (0+0i)x^3
// 整理为：(1+2i)x^0 + (0+0i)x^1 + (3.3-7i)x^2
	public Polynomial trim(){
		// Add your code here.
		int i;
		for(i = this.coeff.length-1;i>=0;i--)
			if(!this.coeff[i].isZero())
				break;
		if(i==0)
			i=1;
		Complex[] new_coeff = new Complex[i];
		for(i = 0;i< new_coeff.length;i++)
			new_coeff[i] = this.coeff[i];
		this.coeff = new_coeff;
		return new Polynomial(this.variable,new_coeff);
	}

// 多项式求相反数
	public Polynomial negative(){
		// Add your code here.
		Polynomial out = new Polynomial();
		out.coeff = new Complex[this.coeff.length];
		for(int i = 0;i<this.coeff.length;i++)
			out.coeff[i] = this.coeff[i].negative();
		out.variable = this.variable;
		return out;
	}

// 多项式相加：
	public Polynomial add(Polynomial addend){
		// Add your code here.
		if(this.variable!=addend.variable)
			throw new RuntimeException();
		int largerPower = this.coeff.length>addend.coeff.length?this.coeff.length:addend.coeff.length;
		Complex[] c = new Complex[largerPower];
		for(int i=0;i<addend.coeff.length;i++){
			c[i] = addend.coeff[i].clone();
		}
		for(int i=0;i<this.coeff.length;i++){
			c[i] = c[i].add(this.coeff[i]);
		}
		Polynomial p_return = new Polynomial(this.variable,c);
		return p_return;
	}

// 多项式相减：
	public Polynomial subtract(Polynomial subtract){
		// Add your code here.
		return this.add(subtract.negative());
	}

// 多项式相乘：
	public Polynomial multiply(Polynomial multiplier){
		// Add your code here.
		int length = this.coeff.length+multiplier.coeff.length;
		Complex[] p_out = new Complex[length];
		for(int i=0;i<length;i++)
			p_out[i] = new Complex(0,0);
		for(int i=0;i<this.coeff.length;i++)
			for(int j = 0;j<multiplier.coeff.length;j++){
				p_out[i+j] = p_out[i+j].add(this.coeff[i].multiply(multiplier.coeff[j]));
			}
		return new Polynomial(this.variable,p_out);
	}
}
