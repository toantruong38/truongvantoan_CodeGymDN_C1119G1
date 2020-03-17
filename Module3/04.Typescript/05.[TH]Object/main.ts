interface User {
  name: string;
  age: number;
}
let user: User = {
  name: "John Wick",
  age: 30
};
console.log(user);

class Shape {
  constructor(protected _x?: number, protected _y?: number) {}
  get x() {
    return this._x;
  }
  get y() {
    return this._y;
  }

  set x(x: number) {
    this._x = x;
  }
  set y(y: number) {
    this._y = y;
  }

  toString() {
    return `x:${this.x},y:${this.y}`;
  }
}

interface Area {
  getArea(): number;
}

class Rectangle extends Shape implements Area {
  constructor(x?: number, y?: number) {
    super(x, y);
  }
  getArea(): number {
    return this.x * this.y;
  }
}
const rectangle = new Rectangle();
rectangle.x = 10;
rectangle.y = 20;
console.log(rectangle);
console.log(rectangle.getArea());
