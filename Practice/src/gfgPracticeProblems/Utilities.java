package gfgPracticeProblems;

public class Utilities {

	public static void main(String[] args) {
		int[] arr = {1, 5, 3, 2, 0, 4 };
		//int[] arr = { 5, 4, 3, 2, 1, 0 };
		//arr = BubbleSort(arr);
		//arr = SelectionSort(arr);
		arr = InsertionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	public static int[] BubbleSort(int[] arr) {
		int leftValue = 0, rightValue = 1, comparison = 1, round = 0;
		boolean sorted = false;
		while (sorted == false) {
			int swaps = 0;
			round++;
			System.out.println("****" + round + "th round ****");
			while (rightValue < (arr.length-round)) {
				System.out.println(comparison++ + "th comparison: " + arr[leftValue] + " with " + arr[rightValue]);
				if (arr[leftValue] > arr[rightValue]) {
					// swap
					int a = arr[leftValue], b = arr[rightValue];
					a = a - b;
					b = a + b;
					a = b - a;
					arr[leftValue] = a;
					arr[rightValue] = b;
					swaps++;
					System.out.println("swapped " + arr[leftValue] + " with " + arr[rightValue]);
				}
				leftValue++;
				rightValue++;
			}
			leftValue = 0;
			rightValue = 1;
			if (swaps == 0) {
				sorted = true;
			}
			
		}
		return arr;
	}

	public static int[] SelectionSort(int[] arr) {
		int startIndex = 0, round = 1, comparison = 1;
		while (startIndex < (arr.length-1)) {
			System.out.println("****" + (round++) + "th round ****");
			int smallest = arr[startIndex], indexToSwap = startIndex;
			for (int i = (startIndex+1); i < arr.length; i++) {
				System.out.println(comparison++ + "th comparison: " + smallest + " with " + arr[i]);
				if (smallest > arr[i]) {
					smallest = arr[i];
					indexToSwap = i;
				}
			}
			// swap
			if (smallest != arr[startIndex]) {
				int a = arr[indexToSwap], b = arr[startIndex];
				System.out.println("swapped " + b + " with " + a);
				a = a - b;
				b = a + b;
				a = b - a;
				arr[indexToSwap] = a;
				arr[startIndex] = b;
			}
			startIndex++;
		}
		return arr;
	}
	
	public static int GetLeastElement(int[] arr) {
		int smallest = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (smallest > arr[i]) {
				smallest = arr[i];
			}
		}
		return smallest;
	}

	public static int[] InsertionSort(int[] arr) {
		int startIndex = 1, comparison = 1, round = 1;
		while (startIndex < arr.length) {
			System.out.println("****" + (round++) + "th round ****");
			int temp = arr[startIndex], gapIndex = -1;
			for(int i = startIndex-1; i >= 0; i--) {
				// if any value to the left of temp is greater, move it to right till temp
				System.out.println(comparison++ + "th comparison: " + arr[i] + " with " + temp);
				if (arr[i] > temp) {
					arr[i+1] = arr[i];
					System.out.println("moved " + arr[i] + " from index '"+ i + "' to '" + (i+1) + "'");
					gapIndex = i;
				} else {
					System.out.println("Since " + arr[i] + " < " + temp + ", end of round " + (round-1));
					break;
				}
			}
			startIndex++;
			if (gapIndex != -1) {
				arr[gapIndex] = temp;	
				System.out.println("Placed " + temp + " at index '" + gapIndex + "'");
			}
			System.out.println();
		}
		return arr;
	}
}
