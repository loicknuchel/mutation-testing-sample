function fizzBuzz(n) {
    if (n % 15 === 0) return "FizzBuzz";
    else if (n % 3 === 0) return "Fizz";
    else if (n % 5 === 0) return "Buzz";
    else return n.toString();
}

/**
 * Take a list of item prices and calculate the bill :
 * - if total is higher than 50, apply 10% overall discount
 * - if more than 5 items, apply 100% discount on cheapest one
 * - if many discount apply, use the higher one
 */
function getPrice(prices) {
    let total = sum(prices);
    let discount = 0;
    if (total >= 50) {
        discount = total * 0.1;
    }
    if (prices.length >= 5) {
        let minPrice = min(prices);
        if (minPrice > discount) {
            discount = minPrice;
        }
    }
    return total - discount;
}

function sum(values) {
    let result = 0;
    for (let i = 0; i < values.length; i++) {
        result = result + values[i];
    }
    return result;
}

function min(values) {
    let result = null;
    for (let i = 0; i < values.length; i++) {
        if (result == null || result > values[i]) {
            result = values[i];
        }
    }
    return result;
}

module.exports = {
    fizzBuzz: fizzBuzz,
    getPrice: getPrice
};
