/*
 * The program takes in a string with any characters and any number of characters, 
 * and determines if the string "is valid" depending on the rules listed in the
 * problem.
 *
 * @author Teagan Gao
 * @version 1.0
 * @since 2021-10-19
 */

import java.util.*;

public class Main {

	/*
	 * @param str, input string for validity to be determined
	 */
	public static String isValid(String s) {
		// convert string into char array and array with unique characters only (set)
		char[] letters = s.toCharArray();
		Set<Character> lettersSet = new HashSet<Character>();
		Character[] lettersUniq = new Character[lettersSet.size()];
		for(char c : letters) {
			lettersSet.add(c);
		}
		
		lettersUniq = lettersSet.toArray(lettersUniq);
	
		// if the string is less than four characters, then that means the string is either
		// of length zero (lol) or a length that will always return "YES"
		if(letters.length < 4) return "YES";
		
		// create an array with the frequencies of all the unique characters in the string
		int[] freqencies = new int[lettersSet.size()];
		Arrays.sort(letters);

		int minFreq, maxFreq = 0;
		for(int i = 0; i < letters.length; i++) {
			for(int j = 0; j < lettersUniq.length; j++) {
				if(Character.toString(letters[i]).equals(Character.toString(lettersUniq[j]))) freqencies[j]++;
			}
		}

		// uses the minimum and maximum frequency to account for all test cases, including 
		// - case where all the characters appear the same number of times
		// - case where the one character can be removed to make the remaining characters
		// appear the same number of times
		// - case where one character can be removed, thereby completely removing it from
		// the equation (as if it never existed :3)
		Arrays.sort(freqencies);
		minFreq = freqencies[0];
		maxFreq = freqencies[freqencies.length-1];

		if(maxFreq == minFreq) return "YES";
		if((maxFreq-minFreq) == 1 && maxFreq > freqencies[freqencies.length-2]) return "YES";
		if(minFreq == 1 && freqencies[1] == maxFreq) return "YES";
		return "NO";
	}

	public static void main(String[] args) {
		// input from System.in
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();

		System.out.println(isValid(str));
	}
}
