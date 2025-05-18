/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function (num) {
  const symbolMap = { M: 1000, CM: 900, D: 500, CD: 400, C: 100, XC: 90, L: 50, XL: 40, X: 10, IX: 9, V: 5, IV: 4, I: 1 };
  let romanText = "";

  Object.keys(symbolMap).forEach((symbol) => {
    const val = symbolMap[symbol];
    if (num >= val) {
      const totalSymbol = Math.floor(num / val);
      for (let i = 0; i < totalSymbol; i++) {
        romanText += symbol;
        num -= val;
      }
    }
  });

  return romanText;
};

console.log(intToRoman(3749)); //MMMDCCXLIX
console.log(intToRoman(58)); //LVIII
