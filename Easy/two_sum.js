/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums = [], target = 0) {
  const list = new Map();

  for (let i = 0; i < nums.length; i++) {
    const s = target - nums[i];

    if (list.has(s)) {
      return [list.get(s), i];
    }

    list.set(nums[i], i);
  }

  return [];
};

console.log(twoSum([2, 7, 11, 15], 9)); //[0, 1]
console.log(twoSum([3, 2, 4], 6)); //[1, 2]
console.log(twoSum([3, 3], 6)); //[0, 1]
console.log(twoSum([-3, 4, 3, 90], 0)); //[0, 2]
