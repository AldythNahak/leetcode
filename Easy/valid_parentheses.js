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
  const oddNumber = Array.from({ length: lenS }, (_, i) => i + 1).filter(n => n % 2 === 1);
  var indexMatch = [];

  for (let i = 0; i < lenS; i++) {
    let currStr = s[i];
    let nextStrMatch = "";
    let lastStrMatch = "";

    if (indexMatch.includes(i)) {
      continue;
    }
    
    for(let odd in oddNumber) {
        if(odd + i < lenS) {
            nextStrMatch = s[i + odd]
            const isMatch = [currStr, nextStrMatch]
                .filter((v) => v !== "")
                .every((val) => mapParenthesesList.includes(val));

            if(!isMatch) {
                return false;
            }

            if(mapParentheses[currStr] == nextStrMatch) {
                indexMatch.push(i);
                indexMatch.push(i + odd);
                break;
            }
        }
    }

    // if(i + 1 < lenS) {
    //     nextStrMatch = s[i + 1];
    // }

    // if (i + 1 < lenS - 1 - i) {
    //   lastStrMatch = s[lenS - 1 - i];
    // }

    // const isMatch = [currStr, nextStrMatch, lastStrMatch]
    //   .filter((v) => v !== "")
    //   .every((val) => mapParenthesesList.includes(val));

    // if (!isMatch) {
    //   return false;
    // }

    // if (indexMatch.includes(i)) {
    //   continue;
    // }

    // // console.log(
    // //   `${i}, C = ${i}-${currStr} ; N = ${i + 1}-${nextStrMatch} ; L = ${
    // //     lenS - 1 - i
    // //   }-${lastStrMatch}`
    // // );

    // if (typeof mapParentheses[currStr] !== "undefined") {
    //   if (nextStrMatch !== "" && mapParentheses[currStr] == nextStrMatch) {
    //     indexMatch.push(i);
    //     indexMatch.push(i + 1);
    //     continue;
    //   } else if (
    //     lastStrMatch !== "" &&
    //     mapParentheses[currStr] == lastStrMatch
    //   ) {
    //     indexMatch.push(i);
    //     indexMatch.push(lenS - 1 - i);
    //     continue;
    //   } else {
    //     return false;
    //   }
    // }

    // return false;
  }


  return lenS == indexMatch.length;

  return true;
};

console.log(isValid("(]")); //false
console.log(isValid("()[]{}")); //true
console.log(isValid("([])")); //true
console.log(isValid("(}{)")); //false
console.log(isValid("([{}])")); //true
console.log(isValid("(){}}{")); //false
console.log(isValid("(([]){})")); //false