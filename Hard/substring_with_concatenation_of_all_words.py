import itertools
import random


class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """    
        
        listCheckWords = list(set(words))
        if len([s.find(k) for k in listCheckWords if s.find(k) >= 0]) == 0:
            return []
        
        permutations = itertools.permutations(words)
        collectKeywords = list(set(["".join(p) for p in permutations]))
        indexMatch = sorted([i for k in collectKeywords for i in range(len(s)) if s.startswith(k, i)])

        return indexMatch
        
print(Solution().findSubstring("barfoothefoobarman", ["foo","bar"])) #[0,9]
print(Solution().findSubstring("barfoofoobarthefoobarman", ["bar","foo","the"])) #[0,9]
print(Solution().findSubstring("foobarfoobar", ["foo","bar"])) #[0,3,6]