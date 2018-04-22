const demo = require("../src/demo");

test("fizzBuzz should return FizzBuzz on zero", () => {
    expect(demo.fizzBuzz(0)).toBe("FizzBuzz");
});
test("fizzBuzz should return Fizz on three", () => {
    expect(demo.fizzBuzz(3)).toBe("Fizz");
});
test("fizzBuzz should return 4 on four", () => {
    expect(demo.fizzBuzz(4)).toBe("4");
});
test("fizzBuzz should return Buzz on five", () => {
    expect(demo.fizzBuzz(5)).toBe("Buzz");
});


test("getPrice should be normal price with few and cheap items", () => {
    expect(demo.getPrice([4, 7, 1, 12])).toBe(24);
});
test("getPrice should be get 10% discound on expensive items", () => {
    expect(demo.getPrice([10, 20, 30])).toBe(54);
});
test("getPrice should be get one free item when buy many", () => {
    expect(demo.getPrice([3, 5, 2, 8, 1, 4])).toBe(22);
});
test("getPrice should test boundary conditions", () => {
    expect(demo.getPrice([5, 10, 15, 20])).toBe(45); // 50 total value boundary
    expect(demo.getPrice([7, 8, 15, 10, 10])).toBe(43); // 5 item boundary
});
