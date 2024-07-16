/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful properly formatted, variable names and CONSTANTS?
        Mark out of 10: 10
        Comment:   Yes all variable and constant names were relevant and formatted correctly.
 2. Did I implement the getVerse function correctly and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  getVerse is implemented and called correctly.
 3. Did I implement the getChristmasGift function correctly using a switch statement and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  the getChristmasGift uses a switch statement to get the correct gift.
 4. Did I implement the getOrdinalString function correctly using if or conditional operators and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  The getOrdinalString function uses a conditional operator to get the correct ordinal Number.
 5. Does the program produce the output correctly?
       Mark out of 10: 10
        Comment:  The program produces the correct output.
 6. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment: I answered all questions honestly.
 Total Mark out of 100 (Add all the previous marks): 100
*/ 


public class TwelveDaysExtended {

	public static final int NUMBER_OF_DAYS = 12;
	public static final String FIRST_PART_ONE = "On the ";
	public static final String FIRST_PART_TWO = " day of Christmas \n";
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
		
		for (int verse = 1; verse <= NUMBER_OF_DAYS; verse++) {  }
		
	}
	
	public static String getVerse (int verse) {
		String song = "";
		for (int count = 1; count <= verse; count++) {
			song = getChristmasGift(count) + song;
		}
		return FIRST_PART_ONE + getOrdinalString(verse) + FIRST_PART_TWO + SECOND_PART + song;
	}

	public static String getChristmasGift (int verse) {
		switch (verse) {
		case 1:
			return FIRST_VERSE;
		case 2:
			return SECOND_VERSE;
		case 3:
			return THIRD_VERSE;
		case 4:
			return FOURTH_VERSE;
		case 5:
			return FIFTH_VERSE;
		case 6:
			return SIXTH_VERSE;
		case 7:
			return SEVENTH_VERSE;
		case 8:
			return EIGHTH_VERSE;
		case 9:
			return NINTH_VERSE;
		case 10:
			return TENTH_VERSE;
		case 11:
			return ELEVENTH_VERSE;
		case 12:
			return TWELFTH_VERSE;

		}
		return "";
	}
	
	public static String getOrdinalString (int verse) {
		
		String ordinalNumber = verse==1?"first":verse==2?"second":verse==3?"third":verse==4?"fourth":verse==5?"fifth":verse==6?"sixth":verse==7?
				"seventh":verse==8?"eighth":verse==9?"ninth":verse==10?"tenth":verse==11?"eleventh":verse==12?"twelfth":" ";
		return ordinalNumber;
	}
	
}
