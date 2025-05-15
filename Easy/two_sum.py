class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        lists = {}
        for i, n in enumerate(nums):
            s = target - n
            if s in lists:
                return [lists[s], i]
            
            lists[n] = i
        
print(Solution().twoSum([2,7,11,15], 9)) #[0, 1]
print(Solution().twoSum([3,2,4], 6)) #[1, 2]
print(Solution().twoSum([3,3], 6)) #[0, 1]
print(Solution().twoSum([-3,4,3,90], 0)) #[0, 2]
