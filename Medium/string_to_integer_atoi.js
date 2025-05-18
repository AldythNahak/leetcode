/**
 * @param {string} s
 * @return {number}
 */
var myAtoi = function (s) {
    s = s.trim();

    if(s.length == 0 || s.length > 200) {
        return 0;
    }

    let collectString = "";
    let isNegative = s[0] == "-";

    for(let i = 0; i < s.length; i++) {
        if ((i == 0 && isNegative) || (i == 0 && s[i] == '+')) {
            continue;
        }

        console.log(parseInt(s[i]) === NaN)

        if(parseInt(s[i]) === NaN) {
            break;
        }

        collectString += s[i];
    }

    console.log(collectString)

};

console.log(myAtoi("1337c0d3"));
// console.log(myAtoi("words and 987"));
// console.log(myAtoi("  -042"));
// console.log(myAtoi("20000000000000000000"));
// console.log(myAtoi("   +0 123"));
// console.log(myAtoi("21474836460"));
