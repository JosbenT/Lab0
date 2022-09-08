package lab2;

public class Lab02P4Wrapper {

	public static int[] productExceptSelf(int[] nums) {
		/*ADD YOUR CODE HERE*/
		int answer[] = new int[nums.length];
        answer[0] = 1;

        for(int i = 1; i < nums.length; i++) {
             answer[i] = answer[i-1] * nums[i - 1];
        }
        
        int product = 1;

        for(int i = nums.length-1; i >= 0; i--) {
            answer[i] = answer[i] * product;
            product = product * nums[i];
        }
        return answer;
	}

	public static void main(String[] args) {
//		Input: nums = [1,2,3,4]
		int[] nums = {1,2,3,4};
//		Output: ans	= [24,12,8,6]
		int[] answer = productExceptSelf(nums);
		
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		
		
		
		
	}
}
