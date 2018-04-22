const Cart = require("../src/cart");

test("Cart has no assert", () => {
    new Cart(3).add("shoes");
});
test("Cart has irrelevant assert", () => {
    expect(new Cart(3).add("shoes")).toBe(false);
});
test("Cart asserts few things", () => {
    const cart = new Cart(3);
    cart.add("shoes");
    expect(cart.items.length).toBe(1);
});
