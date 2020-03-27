class Product {
  name;
  price;
  description;
  imgUrl;
  quantity;

  constructor(name, price, description, imgUrl) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.imgUrl = imgUrl;
  }

  get name() {
    return this.name;
  }
  get price() {
    return this.price;
  }
  get description() {
    return this.description;
  }
  get imgUrl() {
    return this.imgUrl;
  }
  get quantity() {
    return this.quantity;
  }
  set quantity(quantity) {
    this.quantity = quantity;
  }
}

const getProducts = () => {
  return initiateProducts();
};

const initiateProducts = () => {
  let desProduct1 = `Màn hình: 6.1", Liquid Retina
CPU: Apple A13 Bionic 6 nhân
RAM: 4 GB, ROM: 64 GB
Camera: Chính 12 MP & Phụ 12 MP
Selfie: 12 MP
PIN: 3110 mAh, có sạc nhanh`;
  let desProduct2 = `Màn hình: 6.5", Super Retina XDR
CPU: Apple A13 Bionic 6 nhân
RAM: 4 GB, ROM: 64 GB
Camera: 3 camera 12 MP
Selfie: 12 MP
PIN: 3969 mAh, có sạc nhanh`;
  let desProduct3 = `Màn hình: 6.1", Liquid Retina
CPU: Apple A13 Bionic 6 nhân
RAM: 4 GB, ROM: 256 GB
Camera: Chính 12 MP & Phụ 12 MP
Selfie: 12 MP
PIN: 3110 mAh, có sạc nhanh`;
  let desProduct4 = `Màn hình: 4.7", Retina HD
CPU: Apple A10 Fusion 4 nhân
RAM: 2 GB, ROM: 32 GB
Camera: 12 MP
Selfie: 7 MP
PIN: 1960 mAh`;
  let desProduct5 = `Màn hình: 6.1", Liquid Retina
CPU: Apple A13 Bionic 6 nhân
RAM: 4 GB, ROM: 64 GB
Camera: Chính 12 MP & Phụ 12 MP
Selfie: 12 MP
PIN: 3110 mAh, có sạc nhanh`;
  let imgUrl1 =
    "https://cdn.tgdd.vn/Products/Images/42/153856/iphone-11-red-600x600.jpg";
  let imgUrl2 =
    "https://cdn.tgdd.vn/Products/Images/42/200533/iphone-11-pro-max-green-600x600.jpg";
  let imgUrl3 =
    "https://cdn.tgdd.vn/Products/Images/42/210648/iphone-11-256gb-white-600x600.jpg";
  let imgUrl4 =
    "https://cdn.tgdd.vn/Products/Images/42/74110/iphone-7-gold-600x600.jpg";
  let imgUrl5 =
    "https://cdn.tgdd.vn/Products/Images/42/210654/iphone-11-pro-max-512gb-gold-600x600.jpg";

  return new Array(
    new Product("iPhone 11 64GB", 21690000, desProduct1, imgUrl1),
    new Product("iPhone 11 Pro Max 64GB", 31890000, desProduct2, imgUrl2),
    new Product("iPhone 11 256GB", 25490000, desProduct3, imgUrl3),
    new Product("iPhone 7 32GB", 9790000, desProduct4, imgUrl4),
    new Product("iPhone 11 Pro Max 512GB", 42990000, desProduct5, imgUrl5)
  );
};
