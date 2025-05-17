/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
  if (s.length == 0 || s.length > 1000) {
    return s;
  }

  if (s == s.split("").reverse().join("")) {
    return s;
  }

  var resultMatch = s[0];
  for (let i = 0; i < s.length; i++) {
    for (let j = i + 1; j <= s.length; j++) {
      if (s[i] != s[j - 1]) {
        continue;
      }

      if (j > 1 && i + 1 < s.length && s[i + 1] != s[j - 2]) {
        continue;
      }

      if (resultMatch.length >= j - i) {
        continue;
      }

      let strJoin = s.slice(i, j);
      let strJoinReverse = strJoin.split("").reverse().join("");

      if (strJoin == strJoinReverse) {
        resultMatch = strJoin;
      }
    }
  }

  return resultMatch;
};

console.log(longestPalindrome("cbbd"));
console.log(longestPalindrome("babad"));
console.log(longestPalindrome("ccd"));
