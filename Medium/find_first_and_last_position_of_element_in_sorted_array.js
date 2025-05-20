/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    let collectRange = [];
    nums.forEach((n, i) => {
        if(n == target) {
            collectRange.push(i);
        }
    });

    if(collectRange.length == 0) {
        return [-1,-1];
    } else if (collectRange.length == 1) {
        return Array(2).fill(collectRange).flat()
    } 

    return [collectRange[0], collectRange[collectRange.length-1]];
};

console.log(searchRange([5,7,7,8,8,10], 8));
console.log(searchRange([1], 1));
console.log(searchRange([3,3,3], 3));
console.log(searchRange([0,0,1,2,2], 2));