/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function (s, numRows) {
  if (s.length == 0 || s.length > 1000 || numRows <= 1 || numRows > 1000) {
    return s;
  }

  let collectZigzag = [];
  let isStraight = false;
  let currRow = 0;

  for (let i = 0; i < s.length; i++) {
    if (typeof collectZigzag[currRow] == "undefined") {
      collectZigzag.push("");
    }

    if (currRow == 0) {
      isStraight = true;
    } else if (currRow == numRows - 1) {
      isStraight = false;
    }

    collectZigzag[currRow] += s[i];

    if (isStraight) {
      currRow += 1;
    } else {
      currRow -= 1;
    }
  }
  
  return collectZigzag.join("");
};

console.log(convert("PAYPALISHIRING", 3));
