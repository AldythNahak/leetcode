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

        if(s[i].match(/^[0-9]/g) == null) {
            break;
        }

        collectString += s[i];
    }

    let resultInt = parseInt(collectString);
    if(!resultInt) {
        return 0;
    }

    if(isNegative) {
        resultInt = -(collectString)
    }   

    if(resultInt < -(2**31)) {
		return -(2**31);
	} else if (resultInt > (2**31)-1) {
		return (2**31) - 1;
	}
    
    return resultInt
};

console.log(myAtoi("1337c0d3"));
console.log(myAtoi("words and 987"));
console.log(myAtoi("  -042"));
console.log(myAtoi("20000000000000000000"));
console.log(myAtoi("   +0 123"));
console.log(myAtoi("21474836460"));
