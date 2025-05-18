import re

class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        
        if len(s) == 0 or len(s) > 20 or len(p) == 0 or len(p) > 20:
            return False
        
        return bool(re.search("^"+p+"$", s))
        
print(Solution().isMatch("aa", "a")) #False
print(Solution().isMatch("aa", "a*")) #True
print(Solution().isMatch("ab", ".*")) #True