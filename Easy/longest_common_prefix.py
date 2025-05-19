class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 0 or len(strs) > 200:
            return ""
        
        def sortByLen(s):
            return len(s)
        
        strs.sort(key=sortByLen)
        lenShortText = len(strs[0])
        collectPrefix = []
        
        for i in range(lenShortText):
            if len(collectPrefix) == i:
                collectPrefix.append(strs[0][i])
                
            if i > len(collectPrefix) or len(collectPrefix) == 0:
                break
                
            for _, text in enumerate(strs):               
                if not text:
                    continue 
                
                if text[i] != collectPrefix[i]:
                    if len(collectPrefix) > 0:
                        collectPrefix.pop()
                    break        
        
        return "".join(collectPrefix)
    
print(Solution().longestCommonPrefix(["flower","flow","flight"])) #fl
print(Solution().longestCommonPrefix(["flower","flow",""])) #fl
print(Solution().longestCommonPrefix(["flower","flower","flower","flower"])) #flower
print(Solution().longestCommonPrefix(["ab", "a"])) #a
print(Solution().longestCommonPrefix(["", ""])) #
print(Solution().longestCommonPrefix(["a"])) #a

