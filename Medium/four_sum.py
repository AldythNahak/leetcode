class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        collectSum = []

        if len(nums) < 1 or len(nums) > 200: 
            return collectSum
        
        totalNum = len(nums)
        nums = sorted(nums)
        
        for i in range(totalNum - 3):
            if i > 0 and nums[i] == nums[i-1]: 
                continue
        
            if nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target:
                break
        
            if nums[i] + nums[totalNum-1] + nums[totalNum-2] + nums[totalNum-3] < target:
                continue
            
            for j in range(i+1, totalNum - 2):
                if j > i+1 and nums[j] == nums[j-1]:
                    continue
                
                if nums[i] + nums[j] + nums[j+1] + nums[j+2] > target:
                    break
                
                if nums[i] + nums[j] + nums[totalNum-1] + nums[totalNum-2] < target:
                    continue
                
                pointerLeft, pointerRight = j + 1, totalNum - 1
                while pointerLeft < pointerRight:
                    listSumNum = sorted([nums[i], nums[j], nums[pointerLeft], nums[pointerRight]])
                    total = sum(listSumNum)
                    if total == target:
                        collectSum.append(listSumNum)
                        pointerLeft += 1
                        pointerRight -=1

                        while pointerLeft < pointerRight and nums[pointerLeft] == nums[pointerLeft - 1]:
                            pointerLeft += 1
                        while pointerLeft < pointerRight and nums[pointerRight] == nums[pointerRight + 1]:  
                            pointerRight -=1
                    elif total < target:
                        pointerLeft += 1
                    else:
                        pointerRight -=1
                    
            
        return collectSum
        
# print(Solution().fourSum([1,0,-1,0,-2,2], 0))
print(Solution().fourSum([-1,0,1,2,-1,-4], -1))