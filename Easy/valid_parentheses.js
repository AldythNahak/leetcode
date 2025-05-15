/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  const lenS = s.length;

  if (lenS % 2 !== 0 || lenS > 10000) {
    return false;
  }

  const mapParentheses = {
    "(": ")",
    "[": "]",
    "{": "}",
  };
  const mapParenthesesList = Object.entries(mapParentheses).flat();

  var collectParentheses = [];

  for (let i = 0; i < lenS; i++) {
    if(i == 0 && Object.values(mapParentheses).includes(s[i])) {
      return false;
    }

    if(!mapParenthesesList.includes(s[i])) {
      return false;
    }

    if(typeof mapParentheses[s[i]] !== "undefined") {
      collectParentheses.push(s[i]);
      continue;
    }

    lastCheck = collectParentheses.slice(-1);
    if(lastCheck !== "undefined" && mapParentheses[lastCheck] == s[i]) {
      collectParentheses.pop();
      continue;
    } else {
      return false;
    }
  }

  return collectParentheses.length == 0;
};

console.log(isValid("(]")); //false
console.log(isValid("()[]{}")); //true
console.log(isValid("([])")); //true
console.log(isValid("(}{)")); //false
console.log(isValid("([{}])")); //true
console.log(isValid("(){}}{")); //false
console.log(isValid("(([]){})")); //true