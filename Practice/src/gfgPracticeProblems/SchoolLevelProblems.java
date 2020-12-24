package gfgPracticeProblems;

import java.util.Scanner;

public class SchoolLevelProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CamelCaseCharCount();
		//SwapTwoNumbersCollectively();
		//DeleteAlternateChar();
		//SubstringPractice();
		//SumOfArrayElementsCollectively();
		//PrintRepeatedlyDecreasingString();
		//ProductOfArrayElementsCollectively();
		//PrintArrayElementAt();
		//PrintLongestName();
		//LowerToUpperCaseCollectively();
		//PrintLargestElementOfArray();
		//ChangeStringAsPer1stChar();
		//PrintMaxAndMinOfArray();
		//CountSmallerThanGivenElement();
		//CountLettersInString();
		//CompareArrayedSkills();
		//ReverseVowels();
		//PrintReverseArrayCollectively();
		//RemoveSpacesCollectively();
		//PrintIntegersInString();
		//CalculateCuboidStats();
		//ConvertFirstLetterToUpper();
		//SwitchCaseExample();
		//PrintAverageAtEveryPoint();
		//PrintStringsReversedCollectively();
		//PrintSumAndAverageCollectively();
		//IsArrayPerfect();
		//IsPalindrome();
		//PrintStringsShrinkingTriangle_Downwards();
		//IsArrayPalindromic();
		//UnderStandingBreak();
		/*
		 * long sum = seriesSum(3);
		 
		System.out.print("sum: " + sum);
		*/
		//SumOfSeries(5);
		/*
		long[] arr = {5512, 9493, 6319, 7495, 1725, 9719, 8305, 410, 4862, 2154, 8357, 5887, 1151, 4483, 6770, 5179};
		long minValueToBalance = minValueToBalance(arr, 16);
		System.out.print("minValueToBalance: " + minValueToBalance);
		*/
		PrintMinimumNoToMakeSumEven();
		/*
		for (int i = 0; i < "abc".length(); i++) {
			String str = ReplaceCharAtIndexWithGivenChar("abc", '.', i);
			System.out.println("replaced string: '" + str + "'");	
		}
		
		
		String wholeString = "";
		for (int i = 0; i < "abc".length(); i++) {
			String str = ReplaceCharAtWithGivenCharWithGivenTimes("abc", '.', i);
			wholeString = wholeString.concat(str + ",");
			// System.out.println("replaced string: '" + str + "'");	
		}
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
		*/
		
		/*
		 * Scanner scan = new Scanner(System.in); String str = scan.nextLine(); for (int
		 * i = 0; i < str.length(); i++) { System.out.println((int)str.charAt(i)); }
		 * scan.close();
		 * 
		 * String str = "hriday"; for (int i = 0; i < str.length(); i++) {
		 * System.out.println(str.charAt(i)+ ": " + (int)str.charAt(i) + ","); }
		 
		String wholeString = "";
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for (int i = 0; i < num; i++) {
			wholeString = wholeString.concat("A");
			System.out.println("wholeString: " + wholeString);
			System.out.println("i: " + i);
		}
		*/
		//NumbersExample();
		/*
		String value = RoundValuesToDecimal(23.5, 2);
		System.out.println("value: '" + value + "'");
		value = RoundValuesToDecimal(552.28283, 2);
		System.out.println("value: '" + value + "'");
	*/
		
	}
	
	public static void NumbersExample() {
		System.out.println("int/int: " + 10/3);

		System.out.println("float/int: " + ((float)10/3));
		
		System.out.println("float/float: " + ((float)10/(float)3));
		
		System.out.println("float: " + ((float)(10/3)));
		
		System.out.println("double/int: " + ((double)10/3));
		System.out.println("double/int: " + ((double)10/(double)3));
		
		System.out.println("double: " + (double)(10/3));
		
		System.out.println("int/double: " + 10/(double)3);
		
		System.out.println("double: "+(Math.round(((float)23.5000*(float)100))/(float)100));
		System.out.println("round: "+((float)Math.round(23.5000*100)/(float)100));
		double value = RoundToDecimals(23.50, 2);
		
		System.out.println("value: '" + value + "'");
	}

	public static String RoundValuesToDecimal(double value, int decimals) {
		String result = value+"", temp = (value-(int)value+"");
		//System.out.print("value: " + value);
		int requiredZeroes = decimals - temp.substring(temp.indexOf(".")+1, temp.length()).length();
		//System.out.print("requiredZeroes: " + requiredZeroes);
		if (requiredZeroes >= 0) {
			for (int i = 0; i < requiredZeroes; i++) {
				result = result.concat("0");
			}		
		} else {
			double tempValue = RoundToDecimals(value, 2);
			//System.out.print("rounded value: " + value);
			result = tempValue+"";
		}
		
		return result;
	}

	public static void CamelCaseCharCount() {
		Scanner scan = new Scanner(System.in);
		// System.out.println("Enter total testCases: ");
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			// System.out.println("Enter " + i + "th string: ");
			String str = scan.nextLine();
			wholeString = wholeString.concat(str + ",");
		}
		for (int i = 0; i < wholeString.split(",").length; i++) {
			String str = wholeString.split(",")[i];
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if ((int) str.charAt(j) <= 90 && (int) str.charAt(j) >= 65) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

	public static void SwapTwoNumbersCollectively() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String numString = "";
		int num1 = 0, num2 = 0;
		for (int i = 0; i < testCases; i++) {
			num1 = Integer.parseInt(scan.next());
			numString = numString.concat(num1 + ",");
			num2 = Integer.parseInt(scan.next());
			numString = numString.concat(num2 + ",");
		}
		for (int i = 0; i < numString.split(",").length; i+=2) {			
			num1 = Integer.parseInt(numString.split(",")[i]);
			num2 = Integer.parseInt(numString.split(",")[i+1]);
			num1 = num1 - num2;
			num2 = num1 + num2;
			num1 = num2 - num1;
			System.out.print(num1 + " " + num2);
			System.out.println();
		}
	}

	public static void DeleteAlternateChar() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			String str = scan.nextLine();
			wholeString = wholeString.concat(str + ",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			String str = wholeString.split(",")[i];
			String result = str;
			for (int j = 1; j <= str.length()/2; j++) {
				result = CharRemoveAt(result, j);
			}
			System.out.println(result);	
		}
	}

	public static String CharRemoveAt(String str, int i) {
		return str.substring(0, i) + str.substring(i + 1);
	}
	
	public static void SubstringPractice() {
		String str = "Hriday";
		//System.out.println(str.substring(0));
		//System.out.println(str.substring(1));
		//System.out.println(str.substring(0, 1) + "," + str.substring(1 + 1));
		// Hriday -> Hiday(1) -> Hiay(2) -> Hia(3)
		/*
		for (int i = str.length()-1; i >= 0; i--) {
			System.out.print(str.charAt(i) + ", ");
		}
		*/
		System.out.println("str: '" + str + "';");
				
		str = "";
		System.out.println("str: '" + str + "';");
	}

	public static void SumOfArrayElementsCollectively() {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			int arraySize = scan.nextInt(), sum = 0;
			int arr[] = new int[arraySize];
			for (int j = 0; j < arraySize; j++) {
				arr[i] = scan.nextInt();
				sum += arr[i];
			}
			wholeString = wholeString.concat(sum+",");
		}
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}

	public static void ProductOfArrayElementsCollectively() {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			int arraySize = scan.nextInt(), product = 1;
			int arr[] = new int[arraySize];
			for (int j = 0; j < arraySize; j++) {
				arr[i] = scan.nextInt();
				product *= arr[i];
			}
			wholeString = wholeString.concat(product+",");
		}
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}
	
	public static void PrintArrayElementAt() {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			int arraySize = scan.nextInt(), index = scan.nextInt();
			int arr[] = new int[arraySize];
			for (int j = 0; j < arraySize; j++) {
				arr[j] = scan.nextInt();
			}
			wholeString = wholeString.concat(arr[index]+",");
		}
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}
	
	public static void PrintRepeatedlyDecreasingString() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			String str = scan.nextLine();
			wholeString = wholeString.concat(str + ",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			String str = wholeString.split(",")[i];
			for (int j = str.length(); j > 0; j--) {
				System.out.println(str.substring(0, j));
			}
		}
	}

	public static void PrintLongestName() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter total test cases: ");
		int testCases = Integer.parseInt(scan.nextLine()), longestLength = 0;
		String wholeString = "", result = "";
		for (int i = 1; i <= testCases; i++) {
			System.out.println("Enter total words for " + i + "th test case: ");
			int totalWords = Integer.parseInt(scan.nextLine());
			for (int j = 1; j <= totalWords; j++) {
				System.out.println("Enter " + j + "/" + totalWords + " word for " + i + "th test case: ");
				String str = scan.nextLine();
				if (j == 1) {
					longestLength = str.length();	
					result = str;
				}
				if (str.length() > longestLength) {
					longestLength = str.length();
					result = str;
				}
			}
			wholeString = wholeString.concat(result + ",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}

	public static void LowerToUpperCaseCollectively() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			String str = scan.nextLine(), result = "";
			
			for (int j = 0; j < str.length(); j++) {
				if ((int)str.charAt(j) <= 122 && (int)str.charAt(j) >= 97) {
					result = result.concat((char)((int)str.charAt(j)-32)+"");
				} else {
					result = result.concat(str.charAt(j)+"");
				}
			}
			wholeString = wholeString.concat(result + ",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}

	public static void PrintLargestElementOfArray() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter total test cases: ");
		int testCases = Integer.parseInt(scan.next()), largestElement = 0, result = 0;
		String wholeString = "";
		for (int i = 1; i <= testCases; i++) {
			System.out.println("Enter total elements for " + i + "th test case: ");
			int totalElements = Integer.parseInt(scan.next());
			int arr[] = new int[totalElements];
			for (int j = 0; j < totalElements; j++) {
				System.out.println("Enter " + (j+1) + "/" + totalElements + " element for " + i + "th test case: ");
				arr[j] = Integer.parseInt(scan.next());
				if (j == 0) {
					largestElement = arr[j];	
					result = largestElement;
				}
				if (arr[j] > largestElement) {
					largestElement = arr[j];
					result = largestElement;
				}
			}
			wholeString = wholeString.concat(result + ",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}

	public static void ChangeStringAsPer1stChar() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			String str = scan.nextLine();
			if ((int)str.charAt(0) <= 122 && (int)str.charAt(0) >= 97) {
				str = ConvertStringToLowerCase(str);
			} else {
				str = ConvertStringToUpperCase(str);
			}
			wholeString = wholeString.concat(str + ",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}
	
	public static String ConvertStringToUpperCase(String str) {
		String result = "";
		for (int j = 0; j < str.length(); j++) {
			if ((int)str.charAt(j) <= 122 && (int)str.charAt(j) >= 97) {
				result = result.concat((char)((int)str.charAt(j)-32)+"");
			} else {
				result = result.concat(str.charAt(j)+"");
			}
		}
		return result;
	}
	
	public static String ConvertStringToLowerCase(String str) {
		String result = "";
		for (int j = 0; j < str.length(); j++) {
			if ((int)str.charAt(j) <= 90 && (int)str.charAt(j) >= 65) {
				result = result.concat((char)((int)str.charAt(j)+32)+"");
			} else {
				result = result.concat(str.charAt(j)+"");
			}
		}
		return result;
	}

	public static void PrintMaxAndMinOfArray() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter total test cases: ");
		int testCases = Integer.parseInt(scan.next()), largestElement = 0, smallestElement = 0, result = 0;
		String wholeString = "";
		for (int i = 1; i <= testCases; i++) {
			System.out.println("Enter total elements for " + i + "th test case: ");
			int totalElements = Integer.parseInt(scan.next());
			int arr[] = new int[totalElements];
			for (int j = 0; j < totalElements; j++) {
				System.out.println("Enter " + (j+1) + "/" + totalElements + " element for " + i + "th test case: ");
				arr[j] = Integer.parseInt(scan.next());
				if (j == 0) {
					largestElement = arr[j];	
					smallestElement = arr[j];
					// result = largestElement;
				}
				if (arr[j] > largestElement) {
					largestElement = arr[j];
					// result = largestElement;
				}
				
				if (arr[j] < smallestElement) {
					smallestElement = arr[j];
				}
				
				//smallestElement = (largestElement < smallestElement) ? largestElement : smallestElement;
			}
			//System.out.println("smallest: " + smallestElement + ", largest: " + largestElement);
			wholeString = wholeString.concat(largestElement + "," + smallestElement + ",");
			largestElement = 0;
			smallestElement = 0;
		}
		
		for (int i = 0; i < wholeString.split(",").length; i+=2) {
			System.out.println(wholeString.split(",")[i] + " " + wholeString.split(",")[i+1]);
		}
	}

	public static void PrintArrayWithoutTwoLargests() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter total test cases: ");
		int testCases = Integer.parseInt(scan.next()), largestElement = 0, largestElementIndex = 0, result = 0;
		String wholeString = "";
		for (int i = 1; i <= testCases; i++) {
			System.out.println("Enter total elements for " + i + "th test case: ");
			int totalElements = Integer.parseInt(scan.next());
			int arr[] = new int[totalElements];
			for (int j = 0; j < totalElements; j++) {
				System.out.println("Enter " + (j+1) + "/" + totalElements + " element for " + i + "th test case: ");
				arr[j] = Integer.parseInt(scan.next());
				if (j == 0) {
					largestElement = arr[j];	
					// result = largestElement;
					largestElementIndex = j;
				}
				if (arr[j] > largestElement) {
					largestElement = arr[j];
					// result = largestElement;
					largestElementIndex = j;
				}
				
				
			}
			
			wholeString = wholeString.concat(largestElement + ",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}
	
	public static int LargestElementOfArray(int arr[]) {
		int result = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (result < arr[i]) {
				result = arr[i];
			}
		}
		return result;
	}
	
	public static int[] GetArrayWithoutGivenIndex(int arr[], int index) {
		int result[] = new int[arr.length-1];
		String numString = "";
		for (int i = 0; i < arr.length; i++) {
			if (i != index) {
				numString = numString.concat(arr[i]+",");
			}		
		}
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt(numString.split(",")[i]);
		}
		return result;
	}

	public static void CountSmallerThanGivenElement() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter total test cases: ");
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 1; i <= testCases; i++) {
			System.out.println("Enter total elements for " + i + "th test case: ");
			int totalElements = Integer.parseInt(scan.nextLine());
			int arr[] = new int[totalElements];
			for (int j = 0; j < totalElements; j++) {
				System.out.println("Enter " + (j+1) + "/" + totalElements + " element for " + i + "th test case: ");
				arr[j] = Integer.parseInt(scan.nextLine());
			}
			System.out.println("Enter value: ");
			int givenValue = Integer.parseInt(scan.nextLine()), count = 0;
			
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] <= givenValue) {
					count++;
				}
			}
			wholeString = wholeString.concat(count + ",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}
	
	public static void CountLettersInString() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			String str = scan.nextLine();
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (((int)str.charAt(j)<=122 && (int)str.charAt(j)>=97) || ((int)str.charAt(j)<=90 && (int)str.charAt(j)>=65)) {
					count++;
				}
			}
			wholeString = wholeString.concat(count + ",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}

	public static void CompareNumbers() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			String result = "";
			int A = Integer.parseInt(scan.next()), B = Integer.parseInt(scan.next());
			if (A > B) {
				result = A + " is greater than " + B;
			} else if (A < B) {
				result = A + " is less than " + B;
			} else {
				result = A + " is equals to " + B;
			}
		}
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}	
	}

	public static void CompareArrayedSkills() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter total test cases: ");
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 1; i <= testCases; i++) {
			int a1[] = new int[3], b1[] = new int[3];
			int a1Score = 0, b1Score = 0;
			System.out.println("Enter elements for a1: ");
			for (int j = 0; j < a1.length; j++) {
				a1[j] = Integer.parseInt(scan.next());
			}
			System.out.println("Enter elements for b1: ");
			for (int j = 0; j < b1.length; j++) {
				b1[j] = Integer.parseInt(scan.next());
				if (b1[j] > a1[j]) {
					b1Score++;
				}
				if (b1[j] < a1[j]) {
					a1Score++;
				}
			}
			wholeString = wholeString.concat(a1Score + "," + b1Score + ",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i+=2) {
			System.out.println(wholeString.split(",")[i] + " " + wholeString.split(",")[i+1]);
		}
	}

	public static void ReverseVowels() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			String str = scan.nextLine(), vowelString = "";
			for (int j = str.length()-1; j >= 0; j--) {
				if (IsVowel(str.charAt(j))) {
					vowelString = vowelString.concat(str.charAt(j)+"");
				}
			}
			for (int j = 0; j < str.length(); j++) {
				if (IsVowel(str.charAt(j))) {
					str = str.substring(0, j) + vowelString.charAt(0) + str.substring(j+1);
					vowelString = CharRemoveAt(vowelString, 0);
				}
			}
			wholeString = wholeString.concat(str + ",");
		}
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}
	
	public static boolean IsVowel(char c) {
		switch(c) {
		case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':
			return true;
		default: return false;
		}
	}
	
	public static void PrintReverseArrayCollectively() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 1; i <= testCases; i++) {
			int elements = Integer.parseInt(scan.next());
			int arr[] = new int[elements];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(scan.next());
				//wholeString = arr[j]+""+wholeString;
			}
			for (int j = arr.length-1; j >=0 ; j--) {
				wholeString = wholeString.concat(arr[j]+" ");
			}
			wholeString = wholeString.concat(",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}

	public static void RemoveSpacesCollectively() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			String str = scan.nextLine(), result = "";
			for (int j = 0; j < str.length(); j++) {
				if ((int)(str.charAt(j))!=32) {
					result = result.concat(str.charAt(j)+"");
				}
			}
			wholeString = wholeString.concat(result + ",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}

	public static void PrintIntegersInString() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			String str = "23an25hf22", result = "";
			for (int j = 0; j < str.length(); j++) {
				if (((int)(str.charAt(j))<=57 && (int)(str.charAt(j))>=48) || ((int)(str.charAt(j))==32)) {
					result = result.concat(str.charAt(j)+"");
				} else {
					result = result.concat(" ");
				}
			}
			/*
			result = (result.trim() == "") ? "No Integers": result;
			// System.out.println("result: '" + result.split(" ")[0] + "'");
			String temp = "";
			for (int j = 0; j < result.split(" ").length; j++) {
				temp = temp.concat(result.split(" ")[j]);
				System.out.println("temp: '" + temp + "'");
			}*/
			String temp = "";
			for (int j = 0; j < result.split(" ").length; j++) {
				System.out.println("result: '" + result.split(" ")[j] + "'");
			}
			wholeString = wholeString.concat(temp + ",");
			//
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}

	public static void CalculateCuboidStats() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			int length = Integer.parseInt(scan.next()), height = Integer.parseInt(scan.next()), width = Integer.parseInt(scan.next());
			long tsa = 2 * (length * height + height * width + width * length);
			long volume = length * height * width;
			wholeString = wholeString.concat(tsa + " " + volume + ",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}

	public static void ConvertFirstLetterToUpper() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			String str = scan.nextLine(), result = "";
			if (str.trim().length() > 0) {
				for (int j = 0; j < str.split(" ").length; j++) {
					String word = str.split(" ")[j];
					//word = word.replace(word.charAt(0), (char)((int)word.charAt(0)-32));
					word = (char)((int)word.charAt(0)-32) + word.substring(0, 0) + word.substring(1);
					result = result.concat(word + " ");
				}
	
				wholeString = wholeString.concat(result + ",");
			}
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}

	public static void SwitchCaseExample() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			int choice = Integer.parseInt(scan.nextLine());
			double area=0;
			switch(choice) {
			case 1:
				int radius = Integer.parseInt(scan.nextLine());
				area = Math.PI * radius * radius;
				break;
			case 2: 
				int length = Integer.parseInt(scan.next()), breadth = Integer.parseInt(scan.next());
				area = length * breadth;
				break;
			default: area = 0;
			}
			wholeString = ((area-(int)area) > 0) ? wholeString.concat(area + ",") : wholeString.concat((int)area + ",");
		}
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}
	
	public static void PrintAverageAtEveryPoint() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			int elements = Integer.parseInt(scan.nextLine());
			int arr[] = new int[elements], sum = 0;
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(scan.next());
				sum += arr[j];
				wholeString = wholeString.concat(sum/(j+1)+ " ");
			}
			wholeString = wholeString.concat(",");
		}
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}

	public static void PrintStringsReversedCollectively() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			String A = scan.nextLine(), B = scan.nextLine();
			for (int j = A.length()-1; j >= 0; j--) {
				wholeString = wholeString.concat(A.charAt(j)+"");
			}
			for (int j = B.length()-1; j >= 0; j--) {
				wholeString = wholeString.concat(B.charAt(j)+"");
			}			
			wholeString = wholeString.concat(",");
		}
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}

	public static void PrintSumAndAverageCollectively() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			int elements = Integer.parseInt(scan.nextLine());
			int arr[] = new int[elements], sum = 0;
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(scan.next());
				sum += arr[j];
			}
			String average = RoundValuesToDecimal((double)sum/elements, 2);
			//System.out.print("(double)sum/elements: " + (double)sum/elements);
			wholeString = wholeString.concat(sum + " " + average + ",");
		}
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}
	
	public static double RoundToDecimals(double value, int decimals) {
		//System.out.println("value in RoundToDecimals: " + value);
		return ((double)Math.round((double)(value*Math.pow(10,decimals)))/Math.pow(10,decimals));
	}

	public static void IsPalindrome() {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		char leftPosition = str.charAt(0), rightPosition = str.charAt(str.length()-1);
		while(leftPosition <= rightPosition) {
			if (leftPosition != rightPosition) {
				System.out.print(str + " is Not Palindrome");
				return;
			}
			leftPosition++;
			rightPosition--;
		}
		System.out.print(str + " is Palindrome");	
	}
	
	public static void IsArrayPerfect() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			int elements = Integer.parseInt(scan.next());
			int arr[] = new int[elements];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(scan.next());
			}
			int leftPosition = 0, rightPosition = arr.length-1;
			boolean isPerfect = true;
			while(leftPosition <= rightPosition) {
				//System.out.println("leftPosition: '" + leftPosition + "', rightPosition: '" + rightPosition + "'");
				if (arr[leftPosition] != arr[rightPosition]) {
					isPerfect = false;
					//System.out.println("Terminated when arr[leftPosition]: '" + arr[leftPosition] + "', arr[rightPosition]: '" + arr[rightPosition] + "'");
					break;
				}
				leftPosition++; 
				rightPosition--;
			}
			
			wholeString = (isPerfect) ? wholeString.concat("PERFECT" + ",") : wholeString.concat("NOT PERFECT" + ",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}

	public static void PrintStringsShrinkingTriangle_Downwards() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			String A = scan.nextLine(), result = "";
			for (int j = 0; j < A.length(); j++) {
				String str = ReplaceCharAtWithGivenCharWithGivenTimes(A, '.', j);
				wholeString = wholeString.concat(str+",");
			}
		}
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}
	
	public static String ReplaceCharAtIndexWithGivenChar(String str, char c, int index) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (i != index) {
				result = result.concat(str.charAt(i)+"");
			} else {
				result = result.concat(c+"");
			}
		}
		return result;
	}
	
	public static String ReplaceCharAtWithGivenCharWithGivenTimes(String str, char c, int times) {
		String result = "";
		for (int i = 0; i < times; i++) {
			result = result.concat(c+"");
		}
		result = result.concat(str.substring(times, str.length()));
		return result;
	}
	
	public static void IsArrayPalindromic() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			int elements = Integer.parseInt(scan.next());
			int arr[] = new int[elements];
			boolean isArrayPalindromic = true;
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(scan.next());
				isArrayPalindromic = IsPalindrome(arr[j]+"");
				if (!isArrayPalindromic) {
					break;
				}
			}
			wholeString = (isArrayPalindromic) ? wholeString.concat("1" + ",") : wholeString.concat("0" + ",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}
	
	public static boolean IsPalindrome(String str) {
		int leftPointer = 0, rightPointer = str.length()-1;
		while(leftPointer <= rightPointer) {
			if (str.charAt(leftPointer) != str.charAt(rightPointer)) {
				return false;
			}
			leftPointer++;
			rightPointer--;
		}
		return true;
	}

	public static void UnderStandingBreak() {
		int i = 0;
		while(i++<5) {
			if (i == 3) {
				System.out.print(i + " ");
				break;
			}
			System.out.print(i + " ");
		}
	}

    public static long seriesSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n+seriesSum(n-1);
    }
    
    public static void SumOfSeries(int n) {
    	long sum = 0;
    	for (int i=0; i <=n; i+=2) {
    		sum = sum + i + i + 1;
    		//sum+=i+1;
    	}
    	System.out.print("sum: " + sum);
    }
    
    public static long minValueToBalance(long a[] ,int n)
    {
        long rightSum = 0, leftSum= 0;
        for(int i=0; i < a.length; i++){
            if (i < n/2) {
                leftSum += a[i];
            } else {
                rightSum += a[i];
            }
        }
        
        System.out.println("leftSum: " + (5512+9493+6319+7495+1725+9719+8305+410));
        System.out.println("leftSum: " + leftSum);
        System.out.println("rightSum: "+ rightSum);
        return (leftSum - rightSum > 0) ? (leftSum - rightSum) : (rightSum-leftSum);
    }
    
    public static void PrintMinimumNoToMakeSumEven() {
    	int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    	//int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    	int sum = 0, minimumNoToMakeSumEven = 0;
    	for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
    	minimumNoToMakeSumEven = (sum % 2 == 0) ? 2 : 1;
    	System.out.println("minimumNoToMakeSumEven: " + minimumNoToMakeSumEven);
    }

    public static void PrintMaxIlluminatedDays() {
    	int[] arr = {1, 1, 2};
    	int maxDays = arr[0];
    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i] >= maxDays) {
    			maxDays = arr[i];
    		}
		}
    	System.out.println("maxDays: " + maxDays);
    }
}
