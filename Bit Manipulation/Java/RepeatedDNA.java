/*The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
  */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class RepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<Integer> word = new HashSet<>();
        Set<Integer> secondWord = new HashSet<>();
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            value <<= 2;
            value |= map[s.charAt(i) - 'A'];
            value &= 0xfffff;
            if (i < 9) {
                continue;
            }
            if (!word.add(value) && secondWord.add(value)) {
                result.add(s.substring(i - 9, i + 1));
            }
        }
        return result;
    }
}