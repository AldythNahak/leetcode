class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        collectSum = []

        if len(nums) < 3 or len(nums) > 3000: 
            return collectSum
        
        totalNum = len(nums)
        nums = sorted(nums)
        
        for i in range(totalNum - 2):
            if i > 0 and nums[i] == nums[i-1]: 
                continue
            
            iLeft, iRight = i+1, totalNum-1
            while iLeft < iRight :
                listSumNum = sorted([nums[iLeft], nums[i], nums[iRight]])
                sumNum = sum(listSumNum)
                if sumNum == 0:
                    collectSum.append(listSumNum)
                    while iLeft < iRight and nums[iLeft] == nums[iLeft+1]:
                        iLeft += 1
                        
                    while iLeft < iRight and nums[iRight] == nums[iRight-1]:
                        iRight -= 1

                    iLeft += 1
                    iRight -= 1
                elif sumNum < 0:
                    iLeft += 1
                else:
                    iRight -= 1
            
        def sortListNum(num):
            return num[2]
            
        collectSum.sort(key=sortListNum)
        
        return collectSum
  
  
print(Solution().threeSum([-1, 0, 1, 2, -1, -4])) #[[-1,-1,2],[-1,0,1]]
print(Solution().threeSum([0, 0, 0]))             #[[0,0,0]]
print(Solution().threeSum([3, -2, 1, 0]))         #[]
print(Solution().threeSum([1, -1, -1, 0]))        #[[-1,0,1]]
print(Solution().threeSum([-1, 0, 1, 0]))         #[[-1,0,1]]
print(Solution().threeSum([2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10]))
#[[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]
  