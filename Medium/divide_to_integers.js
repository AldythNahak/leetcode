/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
var divide = function (dividend, divisor) {
    const INT_MIN = -(2**31);
	const INT_MAX = (2**31) - 1;

    if (dividend < INT_MIN) {
		dividend = INT_MIN;
	}

	if (divisor > INT_MAX) {
		divisor = INT_MAX;
	}

    if (divisor == 0) {
		return 0;
	}

    let divideNumber = parseFloat(dividend)/parseFloat(divisor);
    divideNumber = Math.trunc(divideNumber);
    
    if (divideNumber > INT_MAX) {
		return INT_MAX
	} else if (divideNumber < INT_MIN) {
		return INT_MIN
	}

    return divideNumber
};

console.log(divide(10, 3)); //3
console.log(divide(7, -3)); //-2
console.log(divide(-2147483648, -1)); //2147483647
console.log(divide(2147483647, 2)); //1073741823
