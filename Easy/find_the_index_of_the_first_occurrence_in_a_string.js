/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    return String(haystack).search(needle)
};

console.log(strStr("sadbutsad", "sad"));
console.log(strStr("leetcode", "leeto"));