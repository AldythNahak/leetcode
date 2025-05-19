class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        return len([v for v in nums if v != val])
        
print(Solution().removeElement([3, 2, 2, 3], 3))
print(Solution().removeElement([0, 1, 2, 2, 3, 0, 4, 2], 2))
        