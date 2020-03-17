let user = {
    name: "John Wick",
    age: 30
};
console.log(user);
class Shape {
    constructor(_x, _y) {
        this._x = _x;
        this._y = _y;
    }
    get x() {
        return this._x;
    }
    get y() {
        return this._y;
    }
    set x(x) {
        this._x = x;
    }
    set y(y) {
        this._y = y;
    }
    toString() {
        return `x:${this.x},y:${this.y}`;
    }
}
class Rectangle extends Shape {
    constructor(x, y) {
        super(x, y);
    }
    getArea() {
        return this.x * this.y;
    }
}
const rectangle = new Rectangle();
rectangle.x = 10;
rectangle.y = 20;
console.log(rectangle);
console.log(rectangle.getArea());
