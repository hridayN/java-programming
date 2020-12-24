package gfgPracticeProblems;

import java.util.Scanner;

public class BasicLevelProblems {

	public static void main(String[] args) {
		//RotateArray();
		/*
		int[] arr = { 1, 2, 3, 4, 5 };
		arr = RotateArrayClockwiseByGivenRotation(arr, 4);
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + ", ");
		}
		*/
		BinarySearch();
	}
	
	public static void RotateArray() {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		String wholeString = "";
		for (int i = 0; i < testCases; i++) {
			int elements = Integer.parseInt(scan.next()), rotation = Integer.parseInt(scan.next());
			int arr[] = new int[elements];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(scan.next());
			}
			int[] rotatedArr = RotateArrayClockwiseByGivenRotation(arr, rotation);
			for (int j = 0; j < rotatedArr.length; j++) {
				wholeString = wholeString.concat(rotatedArr[j] + " ");
			}
			wholeString = wholeString.concat(",");
		}
		
		for (int i = 0; i < wholeString.split(",").length; i++) {
			System.out.println(wholeString.split(",")[i]);
		}
	}
	
	public static int[] RotateArrayClockwiseByGivenRotation(int[] arr, int rotation) {
		int[] rotatedArray = new int[arr.length];
		int rotatedArrayIndex = rotatedArray.length-rotation;
		for (int i = 0; i < rotation; i++) {
			rotatedArray[rotatedArrayIndex] = arr[i];
			rotatedArrayIndex++;
		}

		rotatedArrayIndex = 0;
		for (int i = rotation; i < arr.length; i++) {
			rotatedArray[rotatedArrayIndex] = arr[i];
			rotatedArrayIndex++;
		}
		return rotatedArray;
	}

	public static void BinarySearch() {
		int[] arr = {1, 2, 3, 4, 5};
		int left = 0, right = arr.length-1, mid = (left+right)/2, valueToFind = 6, foundAtIndex = -1;
		while(left <= right) {
			if (valueToFind == arr[mid]) {
				foundAtIndex = mid;
				System.out.print(valueToFind + " found at index: " + mid);
				break;
			} else if (valueToFind < arr[mid]) {
				right = mid-1;
				mid = (left+right)/2;
			} else if (valueToFind > arr[mid]) {
				left = mid + 1;
				mid = (left+right)/2;
			}
		}
		if (foundAtIndex == -1) {
			System.out.print(valueToFind + " not exists in array");
		}
	}

}
