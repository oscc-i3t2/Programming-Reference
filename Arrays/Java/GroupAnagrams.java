/* Leetcode Problem Link: https://leetcode.com/problems/group-anagrams/

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/




import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashSet to store unique sorted strings
        HashSet<String> set = new HashSet<>();
        // Array to store sorted strings for each input string
        String[] sortedStrs = new String[strs.length];

        // Loop through the input strings
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            // Convert the string to a character array and sort it
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String sortedWord = new String(letters);

            // Add the sorted string to the set
            set.add(sortedWord);
            sortedStrs[i] = sortedWord;
        }

        // List to store the final grouped anagrams
        List<List<String>> finalList = new ArrayList<>();

        // Iterate through the set of unique sorted strings
        for (String item : set) {
            List<String> list = new ArrayList<String>();
            // Check for anagrams and add them to the list
            for (int i = 0; i < sortedStrs.length; i++) {
                if (item.equals(sortedStrs[i]))
                    list.add(strs[i]);
            }
            // Add the list of anagrams to the final list
            finalList.add(list);
        }
        return finalList;
    }

    // Main function to test the groupAnagrams function
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] inputStrings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(inputStrings);

        // Print the grouped anagrams
        for (List<String> anagrams : result) {
            System.out.print("[");
            for (String str : anagrams) {
                System.out.print(str + " ");
            }
            System.out.print("] ");
        }
    }
}
