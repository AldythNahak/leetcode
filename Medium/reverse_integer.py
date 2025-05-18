class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        strX = str(x)
        isNegative = strX[0] == "-"
        
        if isNegative:
            strX = "-"+strX[:0:-1]
        else:
            strX = strX[::-1]
        
        convToInteger = int(strX)
        
        if convToInteger < -(2**31) or convToInteger > (2**31)-1:
            return 0
        
        return convToInteger

print(Solution().reverse(123)); #321
print(Solution().reverse(-123)); #-321
print(Solution().reverse(1534236469)); #0