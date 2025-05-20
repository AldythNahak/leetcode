class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        countValidParentheses = 0
        
        for i in range(len(s) - 1):
            currP = s[i]
            nextP = s[i+1]
            
            if currP == "(" and nextP == ")":
                countValidParentheses += 2
            else:
                countValidParentheses -= 1
        
        return countValidParentheses
    
print(Solution().longestValidParentheses("(()"))
print(Solution().longestValidParentheses(")()())"))
print(Solution().longestValidParentheses(""))
print(Solution().longestValidParentheses("()(()"))

