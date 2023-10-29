/* Leetcode Problem Link: https://leetcode.com/problems/longest-consecutive-sequence/

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
*/


import java.util.HashSet;

class Solution {
    public static int longestConsecutive(int[] nums) {
        // Creating a HashSet to store all the numbers in the array
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // Initializing the variable to store the maximum count of consecutive elements
        int maxCount = 0;
        
        // Iterating through the array to find the longest consecutive sequence
        for (int j = 0; j < nums.length; j++) {
            int count = 0;
            // Checking if the set does not contain the previous number in the sequence
            if (!set.contains(nums[j] - 1)) {
                count++;
                int l = 1;
                // Checking for consecutive numbers in the sequence
                while (set.contains(nums[j] + l)) {
                    count++;
                    l++;
                }
                // Updating the maximum count if necessary
                maxCount = Math.max(maxCount, count);
            }
        }
        // Returning the maximum count of consecutive elements
        return maxCount;
    }

    // Main function to test the `longestConsecutive` method
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2}; // Example array of integers
        int result = longestConsecutive(nums);
        System.out.println("The length of the longest consecutive elements sequence is: " + result);
    }
}
