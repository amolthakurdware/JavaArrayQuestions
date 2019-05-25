import java.util.HashMap;
import java.util.Set;

/** 
 * Program to find count of characters in a string
 * 
 * I/P=abcdabcdabbc
 * O/P=a3b4c3d2
 * 
 * @author Amol Thakurdware
 */
class CharCountInStringUsingMap{
	public static void main(String[] args) {
		String inputStr="abcdabcdabbc";
//		1) Populate a HashMap
		HashMap<Character,Integer> resultMap=createHashMapFromString(inputStr);
//		2) Print result from HashMap		
		printResult(resultMap);
	}

	private static void printResult(HashMap<Character, Integer> resultMap) {
		Set<Character> keySet = resultMap.keySet();
		for(Character c:keySet) {
			System.out.print(c+""+resultMap.get(c));
		}
		
	}

	private static HashMap<Character, Integer> createHashMapFromString(String inputStr) {
		HashMap<Character, Integer>  resultMap=new HashMap<Character, Integer> ();
		char[] charArray = inputStr.toCharArray();
		for(Character c:charArray) {
			if(!resultMap.containsKey(c)) {
				resultMap.put(c, 1);
			}else {
				Integer count = resultMap.get(c);
				++count;
				resultMap.put(c, count);
			}
		}
		return resultMap;
	}
}