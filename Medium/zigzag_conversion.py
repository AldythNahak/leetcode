class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if len(s) == 0 or len(s) > 1000 or numRows <= 1 or numRows > 1000:
            return s
        
        collectZigzag = ["" for _ in range(numRows)]
        currRow = 0
        isStraight = True
        
        for _, c in enumerate(s):
            if currRow == 0:
                isStraight = True
            elif currRow == numRows - 1:
                isStraight = False
            
            collectZigzag[currRow] += c
                
            if isStraight:
                currRow += 1
            else:
                currRow -= 1
                

        return "".join(collectZigzag)
        
        
# print(Solution().convert("PAYPALISHIRING", 3))
print(Solution().convert("AB", 1))
        