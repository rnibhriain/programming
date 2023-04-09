import java.util.Scanner;

public class StackTest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Stack stack = new Stack();
		
		
		boolean finished = false;
		while (!finished) {
			System.out.println("Enter a number (or say stop to stop entering numbers)");
			if (!input.hasNextInt()) {
				String string = input.next();
				if (string.equalsIgnoreCase("stop")) {
					finished = true;
				}
				else {
					System.out.println("Incorrect Input");
				}
			}
			else {
				stack.push(input.nextInt());
			}
		}
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.search(3));
		stack.move(4);
		System.out.println(stack.peek());
		
		input.close();

	}

}
