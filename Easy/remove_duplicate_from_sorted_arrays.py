class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return len(list(set(nums)))
    
print(Solution().removeDuplicates([0,0,1,1,1,2,2,3,3,4]))
print(Solution().removeDuplicates([1,1,2]))