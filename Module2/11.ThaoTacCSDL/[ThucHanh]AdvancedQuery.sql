select productCode,
    productName,
    buyprice,
    quantityinstock
from products
where buyprice>56.76 and quantityinstock>10;

select productCode,
    productName,
    buyprice,
    textDescription
from products
inner join productlines
on products.productline=productlines.productline
where buyprice > 56.76 and buyprice < 95.59;

select productCode,
    productName,
    buyprice,
    quantityinstock,
    productvendor,
    productline
from products
where productline='Classic Cars' or
    productvendor='Min Lin Diecast'
