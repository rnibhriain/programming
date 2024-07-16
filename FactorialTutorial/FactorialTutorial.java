
public class FactorialTutorial {

	public static void main(String[] args) {
		System.out.println(String.format("%d", calculateFactorial(6)));
	}
	
	public static int calculateFactorial (int number) {
		int answer = number;
		if (number == 1) {
			answer = 1;
		}
		else {
			answer =  answer * calculateFactorial(number-1);
		}
		return answer;
	}

}
