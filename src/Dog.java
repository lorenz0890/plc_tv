import java.util.Comparator;

public class Dog<T> extends Animal implements Comparator<Dog<T>>, Comparable<T> {
	
	Dog(int age){
		super();
		this.age = age;
	}
	
	Dog(){
		this.age = -1;
	}
	
	private int age;
	
	public int getAge() { return age; }
	
	public static void testClassMethod() {
		System.out.println("The static method in Dog"); 
	} 
	public void testInstanceMethod () { 
		System.out.println("The instance method in Dog"); 
	}

	@Override
	public int compare(Dog o1, Dog o2) {
		return o1.getAge() - o2.getAge();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int compareTo(T o) {
		try{
			return this.getAge() - ((Animal)o).getSize();
		}
		catch (Error e){
			System.out.println();
			return 0;
		}
	}

}
