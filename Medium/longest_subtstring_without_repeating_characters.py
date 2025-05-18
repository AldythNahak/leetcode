class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s or len(s) > 50000:
            return 0
        
        longestSubtstring = 1
        startIndex = {}
        startPosition = 0
            
        for i, c in enumerate(s):
            if c in startIndex and startIndex[c] >= startPosition:
                startPosition = startIndex[c] + 1
                
            startIndex[c] = i
            longestSubtstring = max(longestSubtstring, i - startPosition + 1)
            
        return longestSubtstring
        
print(Solution().lengthOfLongestSubstring("abcabcbb")) #3
print(Solution().lengthOfLongestSubstring("bbbbb")) #1
print(Solution().lengthOfLongestSubstring("pwwkew")) #3
print(Solution().lengthOfLongestSubstring("")) #0
print(Solution().lengthOfLongestSubstring("au")) #2
print(Solution().lengthOfLongestSubstring("aab")) #2

#NOTE: TIME OUT ERROR on Leetcode 
