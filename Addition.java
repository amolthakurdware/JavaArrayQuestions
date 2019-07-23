
/**
 * Interview question: Program to add two numbers, digit by digit.
 * Multi-digit operation is not allowed.
 * You have to remember your primary school and add two numbers digit by digit
 * @author Amol Thakurdware
 */

public class Addition {
	
	public static void main(String[] args) {
		//1) Declare input values
		int no1=789;
		int no2=35;
		
		//2) Split the number to get digit array
		int[] no1Arr=getDigitArray(no1);
		int[] no2Arr=getDigitArray(no2);
		
		//3) Add two digit array
		int result=addDigitArrays(no1Arr,no2Arr);
		
		//4) Print the addition
		System.out.println("Print result:"+result);		
	}

	/**
	 * This method prepend zeros to array if both array are not of same size
	 * and then perform addition digit by digit.
	 * @param digitArray1
	 * @param digitArray2
	 * @return
	 */
	private static int addDigitArrays(int[] digitArray1, int[] digitArray2) {
		/*
		 * If both digit array do not have same size, 
		 * find out the small array and prepend the small array with zeros.
		 * */
		int digitArray1Size = digitArray1.length;
		int digitArray2Size = digitArray2.length;
		if(digitArray1Size>digitArray2Size) {
			digitArray2=prependZeros(digitArray2,digitArray1Size-digitArray2Size);
			digitArray2Size = digitArray2.length;
			
		}else if(digitArray1Size<digitArray2Size) {
			digitArray1=prependZeros(digitArray1,digitArray2Size-digitArray1Size);
			digitArray1Size = digitArray1.length;
		}
		
		return addEquiSizedDigitArray(digitArray1, digitArray2, digitArray1Size);
	}

	/**
	 * Add two digit arrays of same size
	 * @param digitArray1
	 * @param digitArray2
	 * @param digitArraySize
	 * @return
	 */
	private static int addEquiSizedDigitArray(int[] digitArray1, int[] digitArray2, int digitArraySize) {
		int carryForward=0;
		String stringResult="";
		int unitPlace=-1;
		
		for(int i=(digitArraySize-1);i>=0;i--) {
			int intermediateSum=carryForward+digitArray1[i]+digitArray2[i];
			carryForward=0;
			int digitCount = getDigitCount(intermediateSum);
			if(digitCount>1) {
				unitPlace=intermediateSum%10;	
				carryForward=intermediateSum/10;
			}else {
				unitPlace=intermediateSum;
			}
			stringResult=unitPlace+stringResult;		
		}
		
		if(carryForward>0) {
			stringResult=carryForward+stringResult;
		}

		return Integer.parseInt(stringResult);
	}

	/**
	 * Prepends zeros to digit array
	 * @param digitArray
	 * @param countOfZero
	 * @return digitArray Prepended with zeros.
	 */
	private static int[] prependZeros(int[] digitArray, int countOfZero) {
		/* Create an empty array.
		 * Default value of integer array elements is zero.
		 * */
		int[] zeroPrependedArray=new int[digitArray.length+countOfZero];
		
		/* Following loop will skip first 'countOfZero' elements.
		 * And copies elements of digitArray in zeroPrependedArray.
		 * 
		 * 'countOfZero' is the input variable.
		 * */
		for(int i=0;i<zeroPrependedArray.length;i++) {
			if(i<countOfZero) {
				continue;
			}else {
				zeroPrependedArray[i]=digitArray[i-countOfZero];
			}
		}
		return zeroPrependedArray;
	}
	

	/**
	 * This method accepts an integer and split the number to create array of integer.
	 * Every digit of the input number is an element of the array.
	 * 
	 * @param number
	 * @return digitArray
	 */
	private static int[] getDigitArray(int number) {
		//Get digit count of the number
		int digitCount=getDigitCount(number);
		//Declare blank array
		int digitArray[]=new int[digitCount];
		
		//Split the number and populate digitArray
		for(int i=digitCount-1;i>=0;i--) {
			digitArray[i]=number%10;
			number=number/10;
		}
		return digitArray;
	}

	/**
	 * This method accepts an integer and return count of digits.
	 * @param number
	 * @return digitCount
	 */
	private static int getDigitCount(int number) {
		int digitCount=0;
		do{
			number=number/10;
			digitCount++;
		}while(number>9);
		digitCount++;
		return digitCount;
	}
}
