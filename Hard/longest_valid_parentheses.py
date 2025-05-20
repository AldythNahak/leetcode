class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        countValidParentheses = 0
        storeIndex = [-1]

        for i, c in enumerate(s):
            if c == "(":
                storeIndex.append(i)
            else:
                storeIndex.pop()
        
                if len(storeIndex) == 0:
                    storeIndex.append(i)
                else:
                    countValidParentheses = max(countValidParentheses, i - storeIndex[-1])
                
        return countValidParentheses
    
print(Solution().longestValidParentheses("(()")) #2
print(Solution().longestValidParentheses(")()())")) #4
print(Solution().longestValidParentheses("")) #0
print(Solution().longestValidParentheses("()(()")) #2
print(Solution().longestValidParentheses("()(())")) #6
print(Solution().longestValidParentheses("()")) #6


