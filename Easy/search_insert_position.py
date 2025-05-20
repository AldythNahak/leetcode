class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        index = 0
        for i, n in enumerate(nums):
            if n >= target:
                index = i
                break
        
        if len(nums) > 0 and index == 0 and nums[len(nums) - 1] < target:
            return len(nums)
        
        return index