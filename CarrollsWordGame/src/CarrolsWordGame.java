/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: This method returns an array and has no parameters.
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: This method reads the words from the "words.txt" file using a file reader and a buffered reader.
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: It returns the contents in a string array.

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: This method takes no parameters and returns an arraylist.
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: The method reads the words provided through user input and puts them in an arraylist which it then returns.

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: This is a boolean method which takes an arraylist as a parameter.
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: Two for loops are used to compare each of the words.
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: When a word is found which is not unique the function returns as false.
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: When the loops are finished the function returns true;

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: This is a boolean method which takes a word and returns true if it is in the dictionary.
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: Yes the binarySearch method is used to search for the word in the array.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: If the value returned by the binarySearch method is >= 0 then the method returns true.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: This is a boolean method which takes two strings as parameters.
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: I changed the strings to char arrays and looped through each of them searching for differences. If there isn't just one difference then it returns false.

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: This is a boolean method which returns true if there is a word chain.
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: This method calls isUniqueList, isEnglishWord and isDifferentByOne and prints the appropriate response if it is true.

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: Calls the readDictionary function to read all the words from the file into a string.
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: Calls isWordChain and asks the user for input.

 Total Mark out of 100 (Add all the previous marks): 100
*/



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class CarrolsWordGame {

	final static int TOTAL_NUMBER_OF_WORDS = 658964;
	static String [] wordList = new String[TOTAL_NUMBER_OF_WORDS];
	static ArrayList <String> currentWords = new ArrayList<String>();
	static boolean finished;

	public static void main(String[] args) throws IOException {
		readDictionary();
		finished = false;
		while (!finished) {
			if (isWordChain()) {
				System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
			}
			else if (!finished){
				System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
			}
		}
		System.out.println("The game is over.");
	}

	static String [] readDictionary () throws IOException {
		Reader fileReader = new FileReader("src//words.txt");
		Reader bufferedFileReader = new BufferedReader(fileReader);
		String word = "";
		int current;
		int count = 0;
		while ((current = bufferedFileReader.read())!=-1) {
			if ((char)current=='\n') {
				wordList[count] = word;
				count++;
				word = "";
			}
			else {
				word += (char) current;
			}
		}

		bufferedFileReader.close();
		return wordList;
	}

	static ArrayList <String> readWordList () {
		Scanner readString = new Scanner(System.in);
		currentWords.clear();
		System.out.println("Enter a comma separated list of words (or an empty list to quit): ");
		Scanner input = new Scanner(readString.nextLine());
		
		input.useDelimiter(",[\\s+]");
		String word = "";
		if (!input.hasNext()) {
			currentWords = null;
		}
		while (input.hasNext()) {
			word = input.next(); 
			currentWords.add(word);
		}
		return currentWords;
	}

	static boolean isUniqueList (ArrayList <String> wordsToCheck) {
		for (int count = 0; count < wordsToCheck.size(); count++) {
			for (int innerCount = count+1; innerCount < wordsToCheck.size(); innerCount++) {
				if (wordsToCheck.get(count).equals(wordsToCheck.get(innerCount))) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean isEnglishWord (String theWord) {
		if (Arrays.binarySearch(wordList, theWord)>=0) {
			return true;
		}
		return false;
	}

	static boolean isDifferentByOne (String firstString, String secondString) {
		char [] firstWord = firstString.toCharArray();
		char [] secondWord = secondString.toCharArray();
		int differentCharacterCount = 0;
		if (firstWord.length != secondWord.length) {
			return false;
		}
		for (int count = 0; count < firstWord.length; count++) {
			if (firstWord[count] != secondWord[count]) {
				differentCharacterCount++;
			}
		}

		if (differentCharacterCount==1) {
			return true;
		}
		else {
			return false;
		}
	}

	static boolean isWordChain () {
		readWordList();
		if (currentWords == null) {
			finished = true;
			return false;
		}
		else {
			if (isUniqueList(currentWords)) {
				for (int count = 0; count < currentWords.size(); count++) {
					if (!isEnglishWord(currentWords.get(count))) {
						return false;
					}
				}
				for (int count = 1; count < currentWords.size(); count++) {
					if (!isDifferentByOne(currentWords.get(count-1), currentWords.get(count))) {
						return false;
					}
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

}
