package find_the_index_of_the_first_occurrence_in_a_string;

class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

public class find_the_index_of_the_first_occurrence_in_a_string {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.strStr("sadbutsad", "sad"));
        System.out.println(solution.strStr("leetcode", "leeto"));
    }
}
