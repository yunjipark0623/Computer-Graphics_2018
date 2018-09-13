class A {
	private int i = 2;//i는 클래스A에서만 쓰인다 
	int j = 4;//j는 전역변 
	
	public void method() {//method라는 생성자 
		System.out.println("i + j = " + (i + j));
	}
}

class B extends A {//class B인데 A에 상속받았다는 뜻 
	int k = 6;
	
	public void myMethod() {
		System.out.println("k + j = " + (k + j));//클래스 A에 상속받았기 때문에 정의가 되어있지 않은 변수 j를 쓸 수 있다. 
	}
}

public class inheritance {
	public static void main(String[] args) {
		B obj = new B();//생성자 만듬, B에대한 객 obj를 만듬 
		
		obj.j = 10;//객체에게 j의 값을 10으로 다시 부여해라라는 뜻 
		obj.method();
		obj.myMethod();
		//obj.i = 15;
	}
}

/*상위 클래스는 public으로 정의되 있어야 한다.
 * 하위 클래스에 대한 객체가 생성될 때 상위 클래스의 생성자가 먼저 호출된다.
 * 그래서 obj.method();를 호출했을 때 i + j의 값이 12가 되는 것을 확인할 수 있다.
 */
