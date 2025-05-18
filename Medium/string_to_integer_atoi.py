class Solution(object):
    def myAtoi(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.strip()
        cStr = []
        t = 1
        for i, c in enumerate(s):
            if i == 0 and c == "-":
                t = -1
                continue
                 
            try:
                if c not in ["0", "."] and not int(c):
                    break
                
                cStr.append(c)
            except:
                break

        if len(cStr) == 0:
            return 0
        
        nums = float("".join(cStr)) * t
        
        if nums <= -2**31-1:
            return -2**31-1
       
        if nums >= 2**31-1:
            return 2**31-1
        
        return int(nums) 