/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
  if (nums1.length > 1000 || nums2.length > 1000) {
    return 0;
  }

  let joinArr = nums1.concat(nums2).sort((a, b) => Number(a) - Number(b));
  let lenJoinArr = joinArr.length;

  if (lenJoinArr == 0 || lenJoinArr > 2000) {
    return 0;
  }

  let mid = Math.floor(lenJoinArr / 2);
  if (lenJoinArr % 2 === 1) {
    return parseFloat(joinArr[mid]);
  }

  return parseFloat((joinArr[mid - 1] + joinArr[mid]) / 2.0);
};

console.log(findMedianSortedArrays([1, 2, 3, 4, 5], [6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17]));
