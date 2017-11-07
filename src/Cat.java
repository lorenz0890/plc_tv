public class Cat extends Animal { 
	Cat(int age){
		super();
		this.age = age;
	}
	
	Cat(){
		age = -1;
	}
	
	private int age;
	
	public int getAge() {return age; }
	
	public static void testClassMethod() { 
		System.out.println("The static method in Cat"); 
	} 
	public void testInstanceMethod () { 
		System.out.println("The instance method in Cat"); 
	} 
}