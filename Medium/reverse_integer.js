/**
 * @param {number} x
 * @return {number}
 */
var reverse = function (x) {
    let strX = x.toString();
    const isNegative = strX[0] == "-";

    if(isNegative) {
        strX = "-" + strX.substring(1, strX.length).split("").reverse().join("");
    } else {
        strX = strX.split("").reverse().join("");
    }

    let convToInteger = parseInt(strX);

    if (convToInteger < -(2 ** 31) || convToInteger > (2 ** 31) - 1) {
        return 0;
    }

    return convToInteger;
};

console.log(reverse(123)); //321
console.log(reverse(-123)); //-321
console.log(reverse(1534236469)); //0
