/**
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function (s) {
  let countValidParentheses = 0;
  let storeIndex = [-1];

  for (let i = 0; i < s.length; i++) {
    if (s[i] == "(") {
      storeIndex.push(i);
    } else {
      storeIndex.pop();
      if (storeIndex.length == 0) {
        storeIndex.push(i);
      } else {
        countValidParentheses = Math.max(countValidParentheses, i - storeIndex[storeIndex.length - 1]);
      }
    }
  }

  return countValidParentheses;
};

console.log(longestValidParentheses("(()")); //2
console.log(longestValidParentheses(")()())")); //4
console.log(longestValidParentheses("")); //0
console.log(longestValidParentheses("()(()")); //2
console.log(longestValidParentheses("()(())")); //6
console.log(longestValidParentheses("()")); //6
