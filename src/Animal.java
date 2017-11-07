public class Animal { 
	int size;
	Animal(){
		int size = 99;
	}
	public int getSize(){ return size; }
	public static void testClassMethod () { 
		System.out.println("The static method in Animal"); 
	} 
	public void testInstanceMethod() { 
		System.out.println("The instance method in Animal"); 
	} 
}