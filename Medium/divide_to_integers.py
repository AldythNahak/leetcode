class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        INT_MIN = - (2**31)
        INT_MAX = (2**31) - 1
        
        if dividend < INT_MIN:
            dividend = INT_MIN
    
        if divisor > INT_MAX:
            divisor = INT_MAX
        
        if divisor == 0:
            return 0
        
        divideNumber = int(float(dividend) / float(divisor))
        
        if divideNumber > INT_MAX:
            return INT_MAX
        elif divideNumber < INT_MIN:
            return INT_MIN
        
        return divideNumber
        
        
        
print(Solution().divide(10, 3));  #3
print(Solution().divide(7, -3)); #-2
print(Solution().divide(-2147483648, -1)); #2147483647
print(Solution().divide(2147483647, 2)); #1073741823