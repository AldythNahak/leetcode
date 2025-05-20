class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        collectRange = []
        for i, n in enumerate(nums):
            if n == target:
                collectRange.append(i)
                
        if len(collectRange) == 0:
            return [-1, -1] 
        elif len(collectRange) == 1:
            return 2*collectRange
        else:
            return [collectRange[0], collectRange[-1]]
            
print(Solution().searchRange([5,7,7,8,8,10], 8))
print(Solution().searchRange([1], 1))
print(Solution().searchRange([3,3,3], 3))
print(Solution().searchRange([0,0,1,2,2], 2))