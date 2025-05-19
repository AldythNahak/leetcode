/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
  if (strs.length == 0 || strs.length > 200) {
    return "";
  }

  strs = strs.sort((a, b) => a.length - b.length)
  const lenShortText = strs[0].length;
  let collectPrefix = [];

  for (let i = 0; i < lenShortText; i++) {
    if(collectPrefix.length == i) {
        collectPrefix.push(strs[0][i]);
    }

    if (i > collectPrefix.length || collectPrefix.length == 0) {
        break;
    }

    for (let j = 0; j < strs.length; j++) {
        if (strs[j] === "") {
            continue;
        }

         if (strs[j][i] !== collectPrefix[i]) {
            collectPrefix.pop();
            break;
        }
    }
  }

  return collectPrefix.join("");
};

console.log(longestCommonPrefix(["flower","flow","flight"])); //fl
console.log(longestCommonPrefix(["flower","flow",""])); //fl
console.log(longestCommonPrefix(["flower","flower","flower","flower"])); //flower
console.log(longestCommonPrefix(["ab", "a"])); //a
console.log(longestCommonPrefix(["", ""])); //
console.log(longestCommonPrefix(["dog","racecar","car"])); //
console.log(longestCommonPrefix(["a"])); //a