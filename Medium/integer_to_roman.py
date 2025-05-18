import math

class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        symbolMap = [
            ("M", 1000), ("CM", 900), ("D", 500), ("CD", 400),
            ("C", 100), ("XC", 90), ("L", 50), ("XL", 40),
            ("X", 10), ("IX", 9), ("V", 5), ("IV", 4), ("I", 1)
        ]
        
        romanText = ""
        
        for symbol, val in symbolMap:
            if num >= val:
                totalSymbol = int(math.floor(num/val))
                for i in range(totalSymbol):
                    romanText += symbol
                    num -= val
    
        return romanText
    
    
print(Solution().intToRoman(3749)); #MMMDCCXLIX
print(Solution().intToRoman(58)); #LVIII