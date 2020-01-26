
create database `db_design`;

use `db_design`;
create table if not exists `Categories`
(
    `category_id` int not null auto_increment,
    primary key(`category_id`),
    `name` nvarchar(50) not null unique,
    `description` nvarchar(500) null
);

create table if not exists `Suppliers`
(
    `supplier_id` int not null auto_increment,
    primary key(`supplier_id`),
    `name` nvarchar(100) not null,
    `email` varchar(50) not null unique,
    `Phone_Number` varchar(50) null,
    `Address` nvarchar(500) not null
);

create table if not exists `Customers`
(
    `customer_id` varchar(50) not null,
    primary key(`customer_id`),

    `first_Name` nvarchar(50) not null,

    `last_Name` nvarchar(50) not null,

    `Phone_Number` varchar(50) null,

    `address` nvarchar(500) not null,

    `email` varchar(50) not null unique,

    `birthDay` datetime null
);

create table if not exists `Employees`
(
    `employee_id` varchar(50) not null,
    primary key(`employee_id`),

    `first_Name` nvarchar(50) not null,

    `last_Name` nvarchar(5) not null,

    `Phone_Number` varchar(50) null,

    `address` nvarchar(500) not null,

    `email` varchar(50) not null unique,

    `birthDay` datetime null
);

create table if not exists `Products`
(
    `product_id` int auto_increment not null ,
    primary key(`product_id`),

    `name` nvarchar(50) not null,

    `image_url` nvarchar(1000) not null,

    `price` decimal(18,2) not null check(`price`>=0) default 0,

	`discount` decimal(18,2) not null check(`discount` between 0 and 100) default 0,

	`stock` decimal(18,2) not null default 0,  

	`category_id` int not null,
	foreign key(`category_id`) references `Categories`(`category_id`),

	`Supplier_id` int not null,
	foreign key(`Supplier_id`) references `Suppliers`(`Supplier_id`),

	`Description` nvarchar(4000) not null
);

create table if not exists `Orders`
(
    `order_id` int not null auto_increment,
    primary key(`order_id`),

    `created_date` datetime default current_timestamp ,

    `shipped_date` datetime null ,

    `status` varchar(50) not null default 'waiting',

    `Description` nvarchar(4000) null,

    `shipping_Address` nvarchar(500) not null,

    `shipping_city` nvarchar(50) not null,

    `payment_Type` varchar(20) default 'cash' ,

    `customer_id` varchar(50) not null,
    foreign key(`customer_id`) references `customers`(`customer_id`),

	
    `employee_id` varchar(50) not null,
    foreign key(`employee_id`) references `Employees`(`employee_id`)
);

create table if not exists `OrderDetails`
(
    `order_detail_id` int not null auto_increment,
    primary key(`order_detail_id`),

    `order_id` int not null,
    foreign key(`order_id`) references `Orders`(`order_id`),

    `product_id` int not null,
    foreign key(`product_id`) references `Products`(`product_id`),

    `quantity` decimal(18,2) not null
);




















