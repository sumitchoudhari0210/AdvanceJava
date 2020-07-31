package example1;

public class Test {
public static void main(String[] args) {
	Runnable r=()-> {
		
			System.out.println("Run lambda expresion");
			
		
	};
	Thread t= new Thread(r);
	t.start();
}
}
