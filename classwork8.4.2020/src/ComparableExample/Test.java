package ComparableExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		List <Employee>l= new ArrayList<>();
		
	
		Employee e1= new Employee();
		e1.setId(1);
		e1.setName("Sumit");
		e1.setAge(28);
		
		Employee e2= new Employee();
		e2.setId(2);
		e2.setName("Ashish");
		e2.setAge(29);
		
		l.add(e1);
		l.add(e2);
			
		 Collections.sort(l, new Comparable(){
		       public int compare(Object o1, Object o2) {
		           return -1;
		           // it can also return 0, and 1
		        }
		    });

		for (Employee emp : l) {
			System.out.println(emp.getId());
			System.out.println(emp.getName());
			System.out.println(emp.getAge());
			System.out.println();
			
		}
		
	
}
}
