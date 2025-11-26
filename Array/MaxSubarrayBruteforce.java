public class MaxSubarrayBruteforce {
    public static void maxSubArraySum(int nums[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i<nums.length;i++){
            int start = i;
            for(int j = i; j<nums.length; j++){
                int end = j;
                currSum = 0;
                for(int k = start; k<=end; k++){
                   //subarray ka sum nikalenge
                   currSum += nums[k];
                }
                System.out.println(currSum);
                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("max sum = " + maxSum);
    }
    public static void main(String args[]){
        int nums[] =  {1, -2, 6, -1, 3};
        maxSubArraySum(nums);
    }
}

//explanation
// First Iteration (i = 0, start = 0)
// We are considering subarrays starting at index 0 (i.e., {1, -2, 6, -1, 3}).
// Inner loop (j = 0 to 4):
// Subarray from index 0 to 0 ([1]):

// currSum = 1
// maxSum is updated to 1.
// Subarray from index 0 to 1 ([1, -2]):

// currSum = 1 + (-2) = -1
// maxSum remains 1.
// Subarray from index 0 to 2 ([1, -2, 6]):

// currSum = 1 + (-2) + 6 = 5
// maxSum is updated to 5.
// Subarray from index 0 to 3 ([1, -2, 6, -1]):

// currSum = 1 + (-2) + 6 + (-1) = 4
// maxSum remains 5.
// Subarray from index 0 to 4 ([1, -2, 6, -1, 3]):

// currSum = 1 + (-2) + 6 + (-1) + 3 = 7
// maxSum is updated to 7.
// At the end of the first outer loop iteration, maxSum = 7.

// Second Iteration (i = 1, start = 1)
// Now, we are considering subarrays starting at index 1 (i.e., {-2, 6, -1, 3}).
// Inner loop (j = 1 to 4):
// Subarray from index 1 to 1 ([-2]):

// currSum = -2
// maxSum remains 7.
// Subarray from index 1 to 2 ([-2, 6]):

// currSum = -2 + 6 = 4
// maxSum remains 7.
// Subarray from index 1 to 3 ([-2, 6, -1]):

// currSum = -2 + 6 + (-1) = 3
// maxSum remains 7.
// Subarray from index 1 to 4 ([-2, 6, -1, 3]):

// currSum = -2 + 6 + (-1) + 3 = 6
// maxSum remains 7.
// At the end of the second outer loop iteration, maxSum = 7.

// Third Iteration (i = 2, start = 2)
// Now, we are considering subarrays starting at index 2 (i.e., {6, -1, 3}).
// Inner loop (j = 2 to 4):
// Subarray from index 2 to 2 ([6]):

// currSum = 6
// maxSum remains 7.
// Subarray from index 2 to 3 ([6, -1]):

// currSum = 6 + (-1) = 5
// maxSum remains 7.
// Subarray from index 2 to 4 ([6, -1, 3]):

// currSum = 6 + (-1) + 3 = 8
// maxSum is updated to 8.
// At the end of the third outer loop iteration, maxSum = 8.

// Fourth Iteration (i = 3, start = 3)
// Now, we are considering subarrays starting at index 3 (i.e., {-1, 3}).
// Inner loop (j = 3 to 4):
// Subarray from index 3 to 3 ([-1]):

// currSum = -1
// maxSum remains 8.
// Subarray from index 3 to 4 ([-1, 3]):

// currSum = -1 + 3 = 2
// maxSum remains 8.
// At the end of the fourth outer loop iteration, maxSum = 8.

// Fifth Iteration (i = 4, start = 4)
// Now, we are considering subarrays starting at index 4 (i.e., {3}).
// Inner loop (j = 4 to 4):
// Subarray from index 4 to 4 ([3]):
// currSum = 3
// maxSum remains 8.
// At the end of the fifth outer loop iteration, maxSum = 8.

// Final Output
// After all iterations, the maximum subarray sum is 8.