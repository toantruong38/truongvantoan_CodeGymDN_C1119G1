use `classicmodels`;

select status 
from `orders`
group by status;

select status,
    count(*) as 'So luong status'
from `orders`
group by status;

select status, 
    sum(quantityOrdered*priceEach) as amount
from `orders` o
inner join `orderdetails ` od
    on o.ordernumber=od.ordernumber
group by status;

select ordernumber,
    sum(quantityOrdered*priceEach) as total
from `orderdetails`
group by ordernumber;

select year(orderdate) as year,
    sum(quantityOrdered*priceEach) as total
from `orders` o
inner join `orderdetails ` od
    on o.ordernumber=od.ordernumber
where status='shipped'
group by year
having year>2003;
