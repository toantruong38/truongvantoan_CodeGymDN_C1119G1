use `classicmodels`;

select *
from customers;

select customernumber,
    contactlastname,
    contactfirstname,
    phone,
    city
from customers;

select customernumber,
    contactlastname,
    contactfirstname,
    phone,
    city
from customers
where contactfirstname='Peter'
    and city='Melbourne';

select customernumber,
    contactlastname,
    contactfirstname,
    phone,
    city
from customers
where contactfirstname like '%A%';

select customernumber,
    contactlastname,
    contactfirstname,
    phone,
    city
from customers
where customernumber between
    103 and 125;

select customernumber,
    contactlastname,
    contactfirstname,
    phone,
    city
from customers
where city in ('USA','France','Spain');

select customernumber,
    contactlastname,
    contactfirstname,
    phone,
    city
from customers
order by contactfirstname asc;

select customernumber,
    contactlastname,
    contactfirstname,
    phone,
    city
from customers
order by contactfirstname desc;

select count(country) as 'So khach hang song o Fance'
from customers 
where city='France';

insert into customers
(
    customernumber,
    customername,
    contactfirstname,
    contactlastname,
    phone,
    addressline1,
    city,
    country
);
values
(
    500,
    'AgileLead',
    'Lan',
    'Tran',
    '0978822683',
    'Ham Nghi',
    'Ha noi',
    'Viet nam'
);

update `customers`
set customername='Baane Mini Imports'
where customername=103;

delete from `customers`
where city='Nantest';
















