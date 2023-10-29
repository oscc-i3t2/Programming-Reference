/* Leetcode Problem Link: https://leetcode.com/problems/next-permutation/

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.
*/


import java.util.*;
class Solution {
    public static void nextPermutation(int[] nums) {
        int check = nums.length - 2;
        int num = check;
        int flag = 0;

        // Finding the first decreasing element from the right
        while (num >= 0) {
            if (nums[num + 1] > nums[num]) {
                flag = 1;
                // Finding the smallest number greater than the current element
                int min = num + 1;
                for (int k = num + 2; k < nums.length; k++) {
                    if (nums[k] > nums[num] && nums[k] <= nums[min])
                        min = k;
                }

                // Swapping the elements
                int temp = nums[num];
                nums[num] = nums[min];
                nums[min] = temp;

                // Reversing the sub-array to the right of the modified element
                int k = 1;
                while (k <= (nums.length - (num + 1)) / 2) {
                    int t = nums[num + k];
                    nums[num + k] = nums[nums.length - k];
                    nums[nums.length - k] = t;
                    ++k;
                }

                break;
            }
            num -= 1;
        }

        // If the array is non-increasing, reverse the whole array
        if (flag == 0) {
            for (int i = 0; i < nums.length / 2; i++) {
                int t = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = t;
            }
        }
    }

    // Main function for testing the nextPermutation method
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Original Array: " + Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println("Next Permutation: " + Arrays.toString(nums));
    }
}
