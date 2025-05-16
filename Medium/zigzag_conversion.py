class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        mapLetter = [[] for _ in range(numRows)]
        # strReverse = list(s)[::-1]
        # print(strReverse)
        start = 0
        iLetter = 0
        
        for i, _ in enumerate(mapLetter):
            if iLetter > len(s):
                break
            
            if start == 0:
                mapLetter[i].append(s[iLetter])
            
            iLetter += 1
            
            if start < numRows:
                start = 0
            else:
                start += 1
        
        print(mapLetter)
        
        
print(Solution().convert("PAYPALISHIRING", 3))
        