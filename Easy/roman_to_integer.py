class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        symbolMap = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
        s = str(s).upper()
        total = 0

        for i, c in enumerate(s):
            if c not in symbolMap:
                break
        
            if i > 0:
                if (c == "V" or c == "X") and s[i-1] == "I":
                    total -= 2
                
                if (c == "L" or c == "C") and s[i-1] == "X":
                    total -= 20
                
                if (c == "D" or c == "M") and s[i-1] == "C":
                    total -= 200
                    
            total += symbolMap.get(c)
        
        return total
    
print(Solution().romanToInt("MCMXCIV"))