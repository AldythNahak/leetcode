class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        if not digits:
            return []
        
        TELEPHONE_MAP = {
            "2": ["a", "b", "c"],
            "3": ["d", "e", "f"],
            "4": ["g", "h", "i"],
            "5": ["j", "k", "l"],
            "6": ["m", "n", "o"],
            "7": ["p", "q", "r", "s"],
            "8": ["t", "u", "v"],
            "9": ["w", "x", "y", "z"],
        }
        
        combination = []
        
        def dfs(i, tree):
            if i == len(digits):
                combination.append("".join(tree))
                return
            
            for c in TELEPHONE_MAP[digits[i]]:
                tree.append(c)
                dfs(i+1, tree)
                tree.pop()
        
        dfs(0, [])    
        return combination
        
print(Solution().letterCombinations("23"))