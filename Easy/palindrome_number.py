class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        strX = str(x)
        return strX == strX[::-1]
    
print(Solution().isPalindrome(121)) #true
print(Solution().isPalindrome(-121)) #false
print(Solution().isPalindrome(10)) #false