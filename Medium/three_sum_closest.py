class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) < 3 or len(nums) > 3000 : return 0

        totalNum = len(nums)
        nums = sorted(nums)
        lastSumClosest = nums[0] + nums[1] + nums[2]

        for i, n in enumerate(nums):
            iLeft, iRight = i+1, totalNum-1
            while iLeft < iRight:
                sumNum = nums[iLeft] + nums[i] + nums[iRight]
                closest = abs(target - sumNum)
                lastClosest = abs(target - lastSumClosest)
                
                if target == sumNum:
                    return sumNum
                
                if closest < lastClosest:
                    lastSumClosest = sumNum
                    
                if sumNum < target:
                    iLeft += 1
                else:
                    iRight -= 1

        return lastSumClosest
        
print(Solution().threeSumClosest([-1, 2, 1, -4], 1)) #2
print(Solution().threeSumClosest([0, 0, 0], 1)) #0
print(Solution().threeSumClosest([0, 1, 2], 3)) #3
print(Solution().threeSumClosest([10, 20, 30, 40, 50, 60, 70, 80, 90], 1)) #60
print(Solution().threeSumClosest([4, 0, 5, -5, 3, 3, 0, -4, -5], -2)) #-2
print(Solution().threeSumClosest([-4, 2, 2, 3, 3, 3], 0)) #0
print(Solution().threeSumClosest([1, 1, 1, 0], 100)) #3