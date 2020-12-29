package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {

		try {
			demo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} // end main method

	public static void demo() throws Exception {
		System.out.println("This is a sample");
		throw new ArithmeticException("This is invalid");
		//int i = 1/0;
		//System.out.println("Completed");		
	} // end demo method
	
} // end class ExceptionHandlingDemo
