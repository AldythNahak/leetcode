/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    const regx = new RegExp(`^${p}$`);
    return regx.test(s);
};

console.log(isMatch("aa", "a")); //False
console.log(isMatch("aa", "a*")); //True
console.log(isMatch("ab", ".*")); //True