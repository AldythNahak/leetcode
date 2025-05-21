/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function (nums, target) {
  if (nums.length < 3 || nums.length > 3000) {
    return 0;
  }

  let totalNum = nums.length;
  nums = nums.sort((a, b) => a - b);
  let lastSumClosest = nums[0] + nums[1] + nums[2];

  for (let i = 0; i < totalNum - 1; i++) {
    let iLeft = i + 1;
    let iRight = totalNum - 1;

    while (iLeft < iRight) {
      let sumNum = nums[iLeft] + nums[i] + nums[iRight];
      let closest = Math.abs(target - sumNum);
      let lastClosest = Math.abs(target - lastSumClosest);

      if (target == sumNum) {
        return sumNum;
      }

      if (closest < lastClosest) {
        lastSumClosest = sumNum;
      }

      if (sumNum < target) {
        iLeft++;
      } else {
        iRight--;
      }
    }
  }

  return lastSumClosest;
};

console.log(threeSumClosest([-1, 2, 1, -4], 1)); // 2
console.log(threeSumClosest([0, 0, 0], 1)); // 0
console.log(threeSumClosest([0, 1, 2], 3)); // 3
console.log(threeSumClosest([10, 20, 30, 40, 50, 60, 70, 80, 90], 1)); // 60
console.log(threeSumClosest([4, 0, 5, -5, 3, 3, 0, -4, -5], -2)); // -2
console.log(threeSumClosest([-4, 2, 2, 3, 3, 3], 0)); // 0
console.log(threeSumClosest([1, 1, 1, 0], 100)); // 3
