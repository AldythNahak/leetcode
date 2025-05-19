class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        return str(haystack).find(needle)
        
        
print(Solution().strStr("sadbutsad", "sad"))
print(Solution().strStr("leetcode", "leeto"))