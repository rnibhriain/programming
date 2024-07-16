/* SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5:5 
       Yes constants were used within the code.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5:5
       All constant names were relevant and formatted correctly.
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 10:10
       All variable names were relevant and formatted in lowerCamelCase.
   4. Did I indent the code appropriately?
       Mark out of 10:10
       The code was indented using tabs.
   5. Did I use an appropriate loop (or loops) to produce the different verses?
       Mark out of 20: 20
       A for loop was used to produce the verses.
   6. Did I use a switch to build up the verses?
       Mark out of 25: 25
       A switch was used to build up each verse.
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))?
       Mark out of 10: 10 
       There was no duplication of code and the lines which make up the verses.
   8. Does the program produce the correct output?
       Mark out of 10: 10
       The output is correct.
   9. How well did I complete this self-assessment?
       Mark out of 5:5
       I answered all questions honestly.
   Total Mark out of 100 (Add all the previous marks):100
 */



public class TwelveDays {

	public static final int NUMBER_OF_DAYS = 12;
	public static final String FIRST_PART_ONE = "On the ";
	public static final String FIRST_PART_TWO = "day of Christmas \n";
	public static final String SECOND_PART = "my true love sent to me:\n";
	public static final String FIRST_VERSE = "a Partridge in a Pear Tree. \n";
	public static final String SECOND_VERSE = "2 Turtle Doves \nand ";
	public static final String THIRD_VERSE = "3 French Hens\n";
	public static final String FOURTH_VERSE = "4 Calling Birds\n";
	public static final String FIFTH_VERSE = "5 Golden Rings\n";
	public static final String SIXTH_VERSE = "6 Geese a Laying\n";
	public static final String SEVENTH_VERSE = "7 Swans a Swimming\n";
	public static final String EIGHTH_VERSE = "8 Maids a Milking\n";
	public static final String NINTH_VERSE = "9 Ladies Dancing\n";
	public static final String TENTH_VERSE = "10 Lords a Leaping\n";
	public static final String ELEVENTH_VERSE = "11 Pipers Piping\n";
	public static final String TWELFTH_VERSE = "12 Drummers Drumming\n";


	public static void main(String[] args) {

		String verse = "";
		String verseNumber = "";

		for (int count = 0; count < NUMBER_OF_DAYS; count++) {

			switch (count) {
			case 0:
				verse = FIRST_VERSE + verse;
				verseNumber = "first ";
				break;
			case 1:
				verse = SECOND_VERSE + verse;
				verseNumber = "second ";
				break;
			case 2:
				verse = THIRD_VERSE + verse;
				verseNumber = "third ";
				break;
			case 3:
				verse = FOURTH_VERSE + verse;
				verseNumber = "fourth ";
				break;
			case 4:
				verse = FIFTH_VERSE + verse;
				verseNumber = "fifth ";
				break;
			case 5:
				verse = SIXTH_VERSE + verse;
				verseNumber = "sixth ";
				break;
			case 6:
				verse = SEVENTH_VERSE + verse;
				verseNumber = "seventh ";
				break;
			case 7:
				verse = EIGHTH_VERSE + verse;
				verseNumber = "eighth ";
				break;
			case 8:
				verse = NINTH_VERSE + verse;
				verseNumber = "ninth ";
				break;
			case 9:
				verse = TENTH_VERSE + verse;
				verseNumber = "tenth ";
				break;
			case 10:
				verse = ELEVENTH_VERSE +verse ;
				verseNumber = "eleventh ";
				break;
			case 11:
				verse = TWELFTH_VERSE + verse;
				verseNumber = "twelfth ";
				break;
			}
			System.out.print(FIRST_PART_ONE + verseNumber + FIRST_PART_TWO + SECOND_PART + verse);

		}



	}

}
