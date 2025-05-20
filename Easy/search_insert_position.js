/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function (nums, target) {
  let index = 0;
  for (let i = 0; i < nums.length; i++) {
    if(nums[i] >= target) {
      index = i;
      break;
    }
  }

  if (nums.length > 0 && index == 0 && nums[nums.length - 1] < target) {
    return nums.length;
  }

  return index;
};

console.log(searchInsert([1, 3, 5, 6], 5));
