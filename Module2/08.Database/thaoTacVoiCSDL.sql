use classicmodels;

select *
from customers
limit 10;

update customers
set addressline2='level 2'
where customerNumber=103;

delete from classicmodels where customerNumber=103;