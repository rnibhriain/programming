
public class SwapClass {
	
	private static int x;
	private static int y;
	
	public static void setX (int newX) {
		x = newX;
	}
	
	public static void setY (int newY) {
		y = newY;
	}
	
	public static void swap () {
		x = x - y;
		y = y + x;
		x = y - x;
	}
	

	public static void main(String[] args) {
		setX(3);
		setY(4);
		System.out.println("x = " + x + " y = " + y);
		swap();
		System.out.println("x = " + x + " y = " + y);
		
		
	}

}
