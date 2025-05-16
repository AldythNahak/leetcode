/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
  if (s == "" || s.length > 50000) {
    return 0;
  }

  let longestSubtstring = 1;
  let startIndex = {};
  let startPosition = 0;
  const strSplit = s.split("");
 
  strSplit.forEach((c, i) => {
    if(Object.hasOwn(startIndex, c)) {
        if(startIndex[c] >= startPosition) {
            startPosition = startIndex[c] + 1;
        }
    }

    startIndex[c] = i;
    longestSubtstring = Math.max(longestSubtstring, i - startPosition + 1);
  });

  return longestSubtstring;
};

console.log(lengthOfLongestSubstring("abcabcbb")); //3
console.log(lengthOfLongestSubstring("bbbbb")); //1
console.log(lengthOfLongestSubstring("pwwkew")); //3
console.log(lengthOfLongestSubstring("")); //0
console.log(lengthOfLongestSubstring("au")); //2
console.log(lengthOfLongestSubstring("aab")); //2
