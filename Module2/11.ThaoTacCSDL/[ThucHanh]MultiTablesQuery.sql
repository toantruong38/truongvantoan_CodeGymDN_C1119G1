use `classicmodels`;

select c.customernumber,
    c.customername,
    c.phone,
    p.paymentdate,
    p.amount
from customers c
inner join payments p
on c.customernumber=p.customernumber
where city='Las Vegas';

select c.customernumber,
    c.customername,
    o.ordernumber,
    o.status
from customers c
left join orders o
on c.customernumber=o.customernumber;

select c.customernumber,
    c.customername,
    o.ordernumber,
    o.status
from customers c 
left join orders o
on c.customernumber=o.customernumber
where ordernumber is null;









