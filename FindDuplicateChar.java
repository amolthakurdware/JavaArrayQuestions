import java.util.ArrayList;

/**
 * How to find duplicate characters in String using ArrayList
 * 
 * @author Amol Thakurdware
 *
 */
public class FindDuplicateChar {
	public static void main(String[] args) {
		String inputStr="bbqfeyaraaar";
		//1) Create an arraylist of duplicate chars
		ArrayList<Character> duplicateChars=createListOfDuplicateChars(inputStr);
		//2) Print the arraylist of duplicate chars
		printResult(duplicateChars);
	}

	private static void printResult(ArrayList<Character> duplicateChars) {
		for(char c:duplicateChars) {
			System.out.print(c);
		}
	}

	private static ArrayList<Character> createListOfDuplicateChars(String inputStr) {
		char[] charArray = inputStr.toCharArray();
		ArrayList<Character> duplicateChars=new ArrayList<Character>();
		ArrayList<Character> temp=new ArrayList<Character>();
		for(char c:charArray) {
			if(!temp.contains(c)) {
				temp.add(c);
			}else {
				if(!duplicateChars.contains(c)) {
				duplicateChars.add(c);
				}
			}
		}
		return duplicateChars;
	}
}
