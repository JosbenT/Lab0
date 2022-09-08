package lab2;

import java.util.Arrays;

public class Lab03P1Wrapper2 {
	
	public static int[] twoSum(int[] array, int targetSum) {
		/*ADD YOUR CODE HERE*/
		int l, r;
		int[] answer = new int[2];

		/* Sort the elements */
		Arrays.sort(array);

		/* Now look for the two candidates
		        in the sorted array*/
		l = 0;
		r = array.length - 1;
		while (l < r) {
			if (array[l] + array[r] == targetSum) {
				answer[0] = array[l];
				answer[1] = array[r];
				return answer;
			}
			else if (array[l] + array[r] < targetSum) {
				l++;
			}
			else // A[i] + A[j] > sum
				r--;
		}
		int[] noAnswer = new int[0];
		return noAnswer;
	}
}
