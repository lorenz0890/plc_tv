import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test {
	
	public static SortedSet<Cat> ssc = new TreeSet<Cat>(new Comparator<Cat>(){
		@Override
		public int compare(Cat o1, Cat o2) {
			return o1.getAge() - o2.getAge();
			}
		}); 
	
	public static SortedSet<Dog<? extends Animal>> ssa = new TreeSet<Dog<? extends Animal>>();
	
	
	public static SortedSet<Animal> ssa2 = new TreeSet<Animal>(
			(Object l, Object r) -> { return l.toString().compareTo(r.toString()); });
	
	public static void main (String[] args) { 
		
		System.out.println("TEST INHERITANCE \n");
        Cat myCat = new Cat(5); 
        Animal myAnimal = myCat; // kein slicing, weil wir mit referencen arbeiten.
        Animal.testClassMethod();
        myAnimal.testClassMethod(); 
        myAnimal.testInstanceMethod();
        
        System.out.println();
        myAnimal = (Animal)myCat;
        Cat.testClassMethod();
        myAnimal.testClassMethod(); 
        myAnimal.testInstanceMethod();
        
        
        

        System.out.println("TEST SORTED SET MIT ANON COMPARATOR UND ANON CLASS\n");
        
        for (int i = 1; i < 100; i += 17){
        	Test.ssc.add(new Cat(i));
        	Test.ssc.add(new Cat (i*i){
	        		@Override
	    			public void testInstanceMethod () { 
	    			System.out.println("The instance method in AnonCat"); 
        		}
        	});
        }
        
        for (Cat c : ssc) { System.out.print("Age:" + c.getAge() +" "); c.testInstanceMethod(); };
        
        
        
        
        System.out.println("TEST SORTED SET MIT IMPLEMENTIERTEM COMPARATOR UND  \n");
        
        for (int i = 1; i < 100; i += 17){
        	Test.ssa.add(new Dog<Animal>(i));
        	Test.ssa.add(new Dog<Animal> (i+i){
	        		@Override
	    			public void testInstanceMethod () { 
	    			System.out.println("The instance method in AnonDog"); 
        		}
        	});
        }
        
        for (Dog<? extends Animal> d : ssa) { System.out.print("Age:" + d.getAge() +" "); d.testInstanceMethod(); };
       
	}
}
