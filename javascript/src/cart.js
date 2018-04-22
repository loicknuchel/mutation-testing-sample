function Cart(size) {
    this.items = [];

    this.add = function (item) {
        console.log("item add: " + item);
        const exists = this.items.indexOf(item) >= 0;
        if (this.items.length < size) {
            this.items.push(item);
        }
        return exists;
    }
}

module.exports = Cart;
