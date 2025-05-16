class Solution(object):
  def isValid(self, s):
    """
    :type s: str
    :rtype: bool
    """
    mapParentheses = {"(": ")","[": "]", "{": "}"}
    collectParentheses = []
    
    for i, c in enumerate(s):
      if i == 0 and c in mapParentheses.values():
        return False
          
      if c not in mapParentheses.keys() and c not in mapParentheses.values():
        return False
      
      if len(collectParentheses) == 0 and c in mapParentheses.values():
        return False
      
      if mapParentheses.__contains__(c):
        collectParentheses.append(c)
        continue
      
      lastCheck = collectParentheses[-1]
      if mapParentheses.get(lastCheck) == c:
        collectParentheses.pop()
        continue
      else:
        return False

    return len(collectParentheses) == 0

print(Solution().isValid("(]")) #false
print(Solution().isValid("()[]{}")) #true
print(Solution().isValid("([])")) #true
print(Solution().isValid("(}{)")) #false
print(Solution().isValid("([{}])")) #true
print(Solution().isValid("(){}}{")) #false
print(Solution().isValid("(([]){})")) #true