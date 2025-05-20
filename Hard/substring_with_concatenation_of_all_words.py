from collections import Counter

class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """    
        # Simple but Limited time out
        # permutations = itertools.permutations(words)
        # collectKeywords = list(set(["".join(p) for p in permutations]))
        # indexMatch = sorted([i for k in collectKeywords for i in range(len(s)) if s.startswith(k, i)])
        # return indexMatch

        if not words or len(words) > 5000:
            return []
        
        if not s or len(s) > 10**4:
            return []
    
        lenText = len(s)
        lenKeyword = sum(len(k) for k in words)
        
        if lenText < lenKeyword:
            return []
        
        totalKeyword = len(words)
        counterKeyword = Counter(words)        
        indexMatch = []
        
        for i in range(len(s) - lenKeyword + 1):
            counterKeywordCheck = counterKeyword.copy()
            startIndex = i
            totalMatch = 0

            while totalMatch < totalKeyword:
                isMatch = False
                for keyword in counterKeywordCheck:
                    if counterKeywordCheck[keyword] > 0 and str(s).startswith(keyword, startIndex):
                        counterKeywordCheck[keyword] -= 1
                        startIndex += len(keyword)
                        totalMatch += 1
                        isMatch = True
                        break

                if not isMatch:
                    break

            if totalMatch == totalKeyword:
                indexMatch.append(i)

        return indexMatch
                
        
print(Solution().findSubstring("barfoothefoobarman", ["foo","bar"])) #[0,9]
# print(Solution().findSubstring("barfoofoobarthefoobarman", ["bar","foo","the"])) #[0,9]
# print(Solution().findSubstring("foobarfoobar", ["foo","bar"])) #[0,3,6]
print(Solution().findSubstring("foobarfoobar", ["foo","bar"])) #[0,3,6]