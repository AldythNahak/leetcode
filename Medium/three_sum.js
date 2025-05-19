/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (nums) {
  let collectSum = [];
  if (nums.length < 3 || nums.length > 3000) {
    return collectSum;
  }

  const totalNum = nums.length;
  nums = nums.sort((a, b) => a - b);

  for (let i = 0; i < totalNum - 2; i++) {
    if (i > 0 && nums[i] == nums[i - 1]) {
      continue;
    }

    let iLeft = i + 1;
    let iRight = totalNum - 1;

    while (iLeft < iRight) {
      let listSumNum = [nums[iLeft], nums[i], nums[iRight]].sort((a, b) => a - b);
      let sumNum = listSumNum.reduce((a, b) => parseInt(a) + parseInt(b), 0);

      if (sumNum == 0) {
        collectSum.push(listSumNum);

        while (iLeft < iRight && nums[iLeft] == nums[iLeft + 1]) {
          iLeft++;
        }

        while (iLeft < iRight && nums[iRight] == nums[iRight - 1]) {
          iRight--;
        }

        iLeft++;
        iRight--;
      } else if (sumNum < 0) {
        iLeft++;
      } else {
        iRight--;
      }
    }
  }

  collectSum = collectSum.sort((a, b) => a[0] - b[0]);

  return collectSum;
};

console.log(threeSum([-1, 0, 1, 2, -1, -4])); //[[-1,-1,2],[-1,0,1]]
console.log(threeSum([0, 0, 0])); //[[0,0,0]]
console.log(threeSum([3, -2, 1, 0])); //[]
console.log(threeSum([1, -1, -1, 0])); //[[-1,0,1]]
console.log(threeSum([-1, 0, 1, 0])); //[[-1,0,1]]
console.log(
  threeSum([2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10])
);
//[[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]
