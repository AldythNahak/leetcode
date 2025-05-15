/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    const symbolMap = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000};
    s = s.toUpperCase().split("");

    return s.map((c, i) => {
        if(Object.hasOwn(symbolMap, c)) {
            let total = symbolMap[c];
            if(i > 0) {
                if ((c == "V" || c == "X") && s[i-1] == "I") {
                    total -= 2;
                }

                if ((c == "L" || c == "C") && s[i-1] == "X") {
                    total -= 20;
                }

                if ((c == "D" || c == "M") && s[i-1] == "C") {
                    total -= 200;
                }
            }

            return total;
        }
    }).reduce((a, b) => Number(a) + Number(b), 0);
};

console.log(romanToInt("MCMXCIV"));