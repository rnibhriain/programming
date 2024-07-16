/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5:5
        Comment: All variable names were relevant.

 2. Did I indent the code appropriately?

        Mark out of 5:5
        Comment:  I indented using tabs.

 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:20
        Comment:  createCipher first creates a 2D array of numbers corresponding to letters. 
        The first for loop sets the first column as the numbers from 0-26. 
        It also sets the second column, randomly assigning a number to each location.
        There is also an inner for loop which makes sure that numbers do not repeat.
        The second for loop sets all of the letters in a second array to the numbers they correspond to. 
        As there is no need to return a value the return type was set to void.

 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  20
        Comment:encrypt has a for loop to check each character against he first column in the cipherKey and changes it to the character in the second column.
        As there is no need to return a value the return type was set to void.

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20: 20
        Comment:decrypt has a for loop which checks each character against the second column of the cipher key and changes it to the character in the first column.
        As there is no need to return a value the return type was set to void

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

       Mark out of 25: 25
        Comment:The main body of a function obtains a string from the user and, providing the string is not "quit", calls the createCipher function.
        It then encrypts the string and prints the encrypted string. Then the string is decrypted and printed also.

 7. How well did I complete this self-assessment?

        Mark out of 5:5
        Comment:I answered all questions honestly.

 Total Mark out of 100 (Add all the previous marks): 100

*/ 
import java.util.Scanner;
import java.util.Random;

public class Cipher2 {
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz ";
	public static final String INPUT_STATEMENT = "Enter some plaintext (Or enter quit):";
	public static final String QUIT = "quit";
	public static void main(String[] args) {
		boolean finished = false;
		Scanner input = new Scanner(System.in);
		Random  generator = new Random();
		String plainTextEntered = "";
		char [] characterArray= {};
		String alphabet = (ALPHABET);
		char [] alphabetArray = alphabet.toCharArray();
		int [] [] cipherKeyCreator = new int[alphabetArray.length][2];
		char [] [] cipherKey = new char[alphabetArray.length][2];
		String encryptedString = "";
		String decryptedString = "";
		while(!finished) {
			System.out.println(INPUT_STATEMENT);
			plainTextEntered = input.nextLine();
			plainTextEntered = plainTextEntered.toLowerCase();
			if (plainTextEntered.equals(QUIT)) {
				finished = true;
			}
			else {
				characterArray = plainTextEntered.toCharArray();
				createCipher(alphabetArray, cipherKeyCreator, cipherKey, generator);
				encrypt(characterArray, cipherKey);
				encryptedString = new String(characterArray);
				System.out.println(encryptedString);
				decrypt(characterArray, cipherKey);
				decryptedString = new String(characterArray);
				System.out.println(decryptedString);
			}
		}
		input.close();
	}

	public static void createCipher(char alphabetArray[], int cipherKeyCreator[][], char cipherKey[][], Random generator) {

		for (int count = 0; count < cipherKeyCreator.length; count ++) {
			cipherKeyCreator[count][0] = count;
			cipherKeyCreator[count][1] = generator.nextInt(27);
			for (int multipleCheck = 0; multipleCheck < count; ) {
				if (cipherKeyCreator[count][1] == cipherKeyCreator[multipleCheck][1]) {
					cipherKeyCreator[count][1] = generator.nextInt(27);
					multipleCheck = 0;
				}
				else {
					multipleCheck++;
				}
			}
		}
		for(int count = 0; count < cipherKey.length ; count++) {
			cipherKey [count][0] = alphabetArray [count];
			cipherKey[count][1] = alphabetArray[cipherKeyCreator[count][1]];
		}
	}

	public static void encrypt(char characterArray[], char cipherKey[][]) {
		for (int count = 0; count < characterArray.length; count ++) {
			for (int encryptCount =0; encryptCount < cipherKey.length; encryptCount++ ) {
				if (characterArray[count] == cipherKey[encryptCount][0]) {
					characterArray[count] = cipherKey[encryptCount][1];
					encryptCount = cipherKey.length;
				}
			}
		}
	}

	public static void decrypt(char characterArray[], char cipherKey[][]) {
		for (int count = 0; count < characterArray.length; count ++) {
			for (int decryptCount =0; decryptCount < cipherKey.length; decryptCount++ ) {
				if (characterArray[count] == cipherKey[decryptCount][1]) {
					characterArray[count] = cipherKey[decryptCount][0];
					decryptCount = cipherKey.length;
				}
			}
		}
	}
}
