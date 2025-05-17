class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s or len(s) > 1000:
            return s
        
        if s == str(s)[::-1]:
            return s
        
        resultMatch = s[0]
        for i in range(len(s)):
            for j in range(i + 1, len(s) + 1):
                if str(s)[i] != str(s)[j-1]:
                    continue
            
                if j>1 and i+1 < len(s) and str(s)[i+1] != str(s)[j-2]:
                    continue
               
                if len(resultMatch) >= j - i:
                    continue
                
                strJoin = str(s)[i:j]
                
                if strJoin == str(strJoin)[::-1]:
                    resultMatch = strJoin
                
        return resultMatch
        
print(Solution().longestPalindrome("cbbd"))
print(Solution().longestPalindrome("babad"))
print(Solution().longestPalindrome("abcdbbfcba"))
print(Solution().longestPalindrome("cstgvkbrxacmpxdxxktktvpdzcuxmnhvuxdgsmskgeeawzeikhtmhdvnccbrgifpzmiuytfmeyfoxsntrdtxeuxcqsndexbgfxnthqwveujqzemloooyddparbjcuiwpopjwvvmwblsamkhjhlnoxinkpsempexmipifsfwzxbetgvfnkngzxcpizwctpdlpngjpyovmjllxfiwktghkxvyelwjwdztujmunijfsfdvmhgqhlpouewgyznphlmccjmqaqncwbeqheohibafqfunfywmrvqvjygjwqoclijwkcfiuaiymeagdbwyejnvtosxylptbtyoahfzfmwzrkhzdamknleroffmsqcaryibamgdpcumlhrblypddzhaxfeztokgogzgvpfvlmetiwsamhdidmvxavleryfyakendwrbslcavlqkerrnvpuzhdgwzuyorxzbkzhxhpbvkflgxouvaavxrdzsjlgrmogzvlhhdidldsxqhrqlryaanffhxnutcycnczuedtrwcnfiqrtoafvdfnfhxhyjivzalozrbrajboecfyalisxxanduzraqdrbzsbkobaieqpzcawrunxucypqyjnmrlrlivrrwwhdpekeelsphhunzbhkkejvqfopjsuholutgmtnleqdrntbqgrobnuhqpdkbjtikijkdiwqvnxgajaaqgswrdamzv"))