class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if len(nums1) > 1000 or len(nums2) > 1000:
            return None
        
        joinArr = sorted(nums1 + nums2)
        lenJoinArr = len(joinArr)
        
        if lenJoinArr == 0 or lenJoinArr > 2000:
            return None
        
        mid = lenJoinArr // 2
        if lenJoinArr % 2 == 1:
            return float(joinArr[mid])
        else:
            return (joinArr[mid - 1] + joinArr[mid]) / 2.0
        
        
        
        
print(Solution().findMedianSortedArrays([1,3], [2]))
print(Solution().findMedianSortedArrays([1,2], [3,4]))